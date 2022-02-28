package Exercises_For_Second_PartialExam.BooksCollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollection{
    List<Book> books;
    public BookCollection(){
        this.books=new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void printByCategory(String category){
        books.stream()
                .filter(book -> book.category.equalsIgnoreCase(category))
                .sorted(Comparator.comparing(Book::getTitle).thenComparing(Book::getPrice))
                .forEach(System.out::println);
    }
    public List<Book> getCheapestN(int n){
        return books.stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Book::getTitle)).limit(n).collect(Collectors.toList());
    }
}
