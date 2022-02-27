package aud07_Collections_Maps_Sets_Part2.Imenik;

import java.util.*;

class DuplicateNumberException extends Exception {
    public DuplicateNumberException(String number) {
        super(String.format("Duplicate number: %s", number));
    }
}

class Contact {
    String name;
    String number;
    public static Comparator<Contact> comparator = Comparator.comparing(Contact::getName).thenComparing(Contact::getNumber);

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    List<String> getSubNumbers() {
        List<String> results = new ArrayList<>();
        for (int i = 3; i <= this.number.length(); i++) {
            for (int j = 0; j <= number.length() - i; j++) {
                results.add(number.substring(j, j + i));
            }
        }
        return results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, number);
    }
}

class PhoneBook {

    Map<String, String> phoneBookByNumbers;
    Map<String, Set<Contact>> phoneBookByNames;
    Map<String, Set<Contact>> phoneBookBySubnumber;

    public PhoneBook() {
        phoneBookByNumbers = new HashMap<>();
        phoneBookByNames = new HashMap<>();
        phoneBookBySubnumber = new HashMap<>();

    }


    public void addContact(String name, String number) throws DuplicateNumberException {
        if (phoneBookByNumbers.containsKey(number))
            throw new DuplicateNumberException(number);
        phoneBookByNumbers.put(number, name);

        Contact c = new Contact(name, number);

        phoneBookByNames.putIfAbsent(name, new TreeSet<>(Contact.comparator));
        phoneBookByNames.get(name).add(c);

        for (String s : c.getSubNumbers()) {
            phoneBookBySubnumber.putIfAbsent(s, new TreeSet<>(Contact.comparator));
            phoneBookBySubnumber.get(s).add(c);
        }


    }

    public void contactsByNumber(String number) {
        if (!phoneBookBySubnumber.containsKey(number)) {
            System.out.println("NOT FOUND");
            return;
        }
        phoneBookBySubnumber.get(number).stream().forEach(c -> System.out.println(c));


    }

    public void contactsByName(String name) {
        if (!phoneBookByNames.containsKey(name)) {
            System.out.println("NOT FOUND");
            return;
        }
        phoneBookByNames.get(name).stream().forEach(c -> System.out.println(c));
    }
}

public class PhoneBookTest {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            try {
                phoneBook.addContact(parts[0], parts[1]);
            } catch (DuplicateNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] parts = line.split(":");
            if (parts[0].equals("NUM")) {
                phoneBook.contactsByNumber(parts[1]);
            } else {
                phoneBook.contactsByName(parts[1]);
            }
        }
    }

}
