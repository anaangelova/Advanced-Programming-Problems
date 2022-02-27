package Exercises_For_Second_PartialExam.FileSystem;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


class File implements Comparable<File>{
    String name;
    int size;
    LocalDateTime dateCreated;


    public File(String name, int size, LocalDateTime dateCreated) {
        this.name = name;
        this.size = size;
        this.dateCreated = dateCreated;
    }

    public boolean isHiddenAndWithSizeLessThan(int size) {
        return this.getSize() < size && this.getName().charAt(0) == '.';
    }

    @Override
    public String toString() {
        return String.format("%-10s %5dB %s", name, size, dateCreated.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getMonthAndDay(){
        return String.format("%s-%d",dateCreated.getMonth(),dateCreated.getDayOfMonth());
    }

    @Override
    public int compareTo(File o) {
        Comparator<File> comparator=Comparator.comparing(File::getDateCreated)
                .thenComparing(File::getName).thenComparing(File::getSize);
        return comparator.compare(this,o);
    }
}

class FileSystem {
    Map<Character, Set<File>> filesByFolder; //key: folder value: all files in folder
    List<File> allFiles;


    public FileSystem() {
        filesByFolder = new HashMap<>();
        allFiles = new ArrayList<>();
    }

    public void addFile(char folder, String name, int size, LocalDateTime createdAt) {
        File fileToAdd = new File(name, size, createdAt);

        filesByFolder.putIfAbsent(folder, new TreeSet<>());
        filesByFolder.get(folder).add(fileToAdd);

        allFiles.add(fileToAdd);
    }

    public List<File> findAllHiddenFilesWithSizeLessThen(int size) {
        return filesByFolder.values().stream().flatMap(s -> s.stream())
                .filter(f -> f.isHiddenAndWithSizeLessThan(size))
                .collect(Collectors.toList());
    }

    public int totalSizeOfFilesFromFolders(List<Character> folders) {

        return folders.stream().mapToInt(f -> {
            if (filesByFolder.containsKey(f)) {
                return filesByFolder.get(f).stream().mapToInt(file -> file.getSize()).sum();
            }
            return 0;
        }).sum();
    }

    public Map<Integer, Set<File>> byYear() {
       return allFiles.stream()
                .collect(Collectors.groupingBy(f -> f.getDateCreated().getYear()
                        , Collectors.toCollection(TreeSet::new)));
    }

    public Map<String, Long> sizeByMonthAndDay() {

        return allFiles.stream()
                .collect(Collectors.groupingBy(f -> f.getMonthAndDay(),
                        TreeMap::new
                        ,Collectors.summingLong(File::getSize)));
    }
}

public class FileSystemTest {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            fileSystem.addFile(parts[0].charAt(0), parts[1],
                    Integer.parseInt(parts[2]),
                    LocalDateTime.of(2016, 12, 29, 0, 0, 0).minusDays(Integer.parseInt(parts[3]))
            );
        }
        int action = scanner.nextInt();
        if (action == 0) {
            scanner.nextLine();
            int size = scanner.nextInt();
            System.out.println("== Find all hidden files with size less then " + size);
            List<File> files = fileSystem.findAllHiddenFilesWithSizeLessThen(size);
            files.forEach(System.out::println);
        } else if (action == 1) {
            scanner.nextLine();
            String[] parts = scanner.nextLine().split(":");
            System.out.println("== Total size of files from folders: " + Arrays.toString(parts));
            int totalSize = fileSystem.totalSizeOfFilesFromFolders(Arrays.stream(parts)
                    .map(s -> s.charAt(0))
                    .collect(Collectors.toList()));
            System.out.println(totalSize);
        } else if (action == 2) {
            System.out.println("== Files by year");
            Map<Integer, Set<File>> byYear = fileSystem.byYear();
            byYear.keySet().stream().sorted()
                    .forEach(key -> {
                        System.out.printf("Year: %d\n", key);
                        Set<File> files = byYear.get(key);
                        files.stream()
                                .sorted()
                                .forEach(System.out::println);
                    });
        } else if (action == 3) {
            System.out.println("== Size by month and day");
            Map<String, Long> byMonthAndDay = fileSystem.sizeByMonthAndDay();
            byMonthAndDay.keySet().stream().sorted()
                    .forEach(key -> System.out.printf("%s -> %d\n", key, byMonthAndDay.get(key)));
        }
        scanner.close();
    }
}

// Your code here

