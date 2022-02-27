package aud01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MultipleDeck {
    private List<Deck> decks;

    public MultipleDeck(int number){
        this.decks=new ArrayList<>();
        decks=IntStream.range(0,number).mapToObj(d -> new Deck()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Deck deck : decks){
            sb.append(deck);
            sb.append("\n");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        MultipleDeck decks=new MultipleDeck(4);
        System.out.println(decks);
    }
}
