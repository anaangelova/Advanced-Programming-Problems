package aud03_IO;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesTest {
    public static void main(String[] args) {
        Supplier<Integer> supplier1=new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random=new Random();
                return random.nextInt();
            }
        };
        Supplier<Integer> supplier2=() -> {
          Random random=new Random();
          return random.nextInt();
        };

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("The number is"+integer);
            }
        };
        Consumer<Integer> consumer2=(broj) -> {
            System.out.println("The number is"+broj);
        };

        Predicate<Integer> lessThan5=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer<5;
            }
        };

        Function<Integer,Integer> function1=new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer+1;
            }
        };
        Function<Integer,Integer> function2=(br1) -> {return br1+1;};

    }
}
