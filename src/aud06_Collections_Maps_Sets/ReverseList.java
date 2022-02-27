package aud06_Collections_Maps_Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {

    public static void print(List<String> list){
        Collections.reverse(list);
        list.forEach(i -> System.out.println(i));

    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("ana");
        list.add("tea");
        list.add("boris");
        list.add("eros");
        list.add("mama");
        ReverseList.print(list);
    }
}
