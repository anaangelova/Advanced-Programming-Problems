package Exercises_For_First_Partial_Exam.Arhiva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class NonExistingItemException extends Exception {
    int id;

    public NonExistingItemException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Item with id %d doesn't exist", id);
    }
}

abstract class Archive {
    protected int id;
    protected Date dateArchived;

    public Archive(int id) {
        this.id = id;
    }
}

class LockedArchive extends Archive {
    private Date dateToOpen;

    public LockedArchive(int id, Date dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    public Date getDateToOpen() {
        return dateToOpen;
    }

    public void setDateToOpen(Date dateToOpen) {
        this.dateToOpen = dateToOpen;
    }
}

class SpecialArchive extends Archive {
    private int maxOpen;
    private int timesOpen;

    public SpecialArchive(int id, int maxOpen) {
        super(id);
        this.maxOpen = maxOpen;
        this.timesOpen = 0;
    }

    public int getMaxOpen() {
        return maxOpen;
    }

    public void setMaxOpen(int maxOpen) {
        this.maxOpen = maxOpen;
    }

    public int getTimesOpen() {
        return timesOpen;
    }

    public void setTimesOpen(int timesOpen) {
        this.timesOpen = timesOpen;
    }
}

class ArchiveStore {
    private List<Archive> archiveList;
    private StringBuilder text;

    public ArchiveStore() {
        archiveList = new ArrayList<>();
        text = new StringBuilder();
    }

    public void archiveItem(Archive item, Date date) {
        item.dateArchived = date;
        archiveList.add(item);
        text.append(String.format("Item %d archived at %s\n", item.id, date.toString()));
    }

    public void openItem(int id, Date date) throws NonExistingItemException {
        Archive item = archiveList.stream().filter(a -> a.id == id)
                .findFirst().orElseThrow(() -> new NonExistingItemException(id));
        if (item.getClass() == LockedArchive.class) {
            LockedArchive lockedArchive = (LockedArchive) item;
            if (lockedArchive.getDateToOpen().after(date)) {
                text.append(String.format("Item %d cannot be opened before %s\n", item.id, lockedArchive.getDateToOpen().toString()));
                return;
            }
        } else {
            SpecialArchive specialArchive = (SpecialArchive) item;
            if (specialArchive.getTimesOpen() >= specialArchive.getMaxOpen()) {
                text.append(String.format("Item %d cannot be opened more than %d times\n", item.id, specialArchive.getMaxOpen()));
                return;
            }
            specialArchive.setTimesOpen(specialArchive.getTimesOpen() + 1);

        }
        text.append(String.format("Item %d opened at %s\n", item.id, date.toString()));

    }

    public String getLog() {
        return text.toString();
    }
}

public class ArchiveStoreTest {
    public static void main(String[] args) {
        ArchiveStore store = new ArchiveStore();
        Date date = new Date(113, 10, 7);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        int i;
        for (i = 0; i < n; ++i) {
            int id = scanner.nextInt();
            long days = scanner.nextLong();
            Date dateToOpen = new Date(date.getTime() + (days * 24 * 60
                    * 60 * 1000));
            LockedArchive lockedArchive = new LockedArchive(id, dateToOpen);
            store.archiveItem(lockedArchive, date);
        }
        scanner.nextLine();
        scanner.nextLine();
        n = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        for (i = 0; i < n; ++i) {
            int id = scanner.nextInt();
            int maxOpen = scanner.nextInt();
            SpecialArchive specialArchive = new SpecialArchive(id, maxOpen);
            store.archiveItem(specialArchive, date);
        }
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()) {
            int open = scanner.nextInt();
            try {
                store.openItem(open, date);
            } catch (NonExistingItemException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(store.getLog());
    }
}



