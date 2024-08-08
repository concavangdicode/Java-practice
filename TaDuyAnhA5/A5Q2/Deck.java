/*
*
* [Deck.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeaul]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 2]
*
* PURPOSE: [Create method to shuffle the deck]
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<String> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"1,", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(rank + " of " + suit);
            }
        }
    }

    public void shuffle() {
        /* TODO */
        shuffleRecursion(cards.size() - 1);
    }
    //Fisher-Yates (AKA Knuth Shuffling algorithm)
    private void shuffleRecursion(int index){
        if(index > 0){
            Random r = new Random(); 
            //random an index
            int indexRandom = r.nextInt(index + 1); 
            //obtain current card and card at random position
            String currentCard = cards.get(index); 
            String randomCard = cards.get(indexRandom); 
            //swap their position
            cards.set(index, randomCard); 
            cards.set(indexRandom, currentCard); 
            //recursively shuffle the remaining cards
            shuffleRecursion(index - 1);
        }
    }


    public List<String> getCards() {
        return cards;
    }

    public void printDeck() {
        for (String card : cards) {
            System.out.println(card);
        }
    }
}
