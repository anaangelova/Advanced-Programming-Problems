package aud01;

import java.util.*;

public class Deck {
    //cuva 52 karti - objekti od tip PlayingCard i treba nie vo konstruktorot pravilno da ja popolnime taa lista!!!
    private List<PlayingCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            for (PlayingCard.TYPE type : PlayingCard.TYPE.values())
                this.cards.add(new PlayingCard(type, i));

        }
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public void setCards(List<PlayingCard> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    public void shuffleCards() {
        Collections.shuffle(this.cards);
    }

    public PlayingCard dealCard() {
        if (isEmpty()) return null;

        Random random = new Random();
        int index = random.nextInt(52);
        PlayingCard card = this.cards.get(index);
        if (!card.isPicked()) {
            card.setPicked(true);
            this.cards.set(index, card);
            return card;
        } else return dealCard();
    }

    public boolean isEmpty() {
        return this.cards.stream().allMatch(c -> c.isPicked());
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(PlayingCard card : cards){
            sb.append(card.toString());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffleCards();
        System.out.println(deck);

        System.out.println(deck.isEmpty());
        PlayingCard card;
        while ((card = deck.dealCard()) != null) {
            System.out.println(card);
        }
        System.out.println(deck.isEmpty());

    }
}
