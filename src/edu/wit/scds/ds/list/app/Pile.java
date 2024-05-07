/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Spring, 2024
 *
 * Usage restrictions:
 *
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 *
 * Further, you may not post (including in a public repository such as on github)
 * nor otherwise share this code with anyone other than current students in my
 * sections of this course. Violation of these usage restrictions will be considered
 * a violation of the Wentworth Institute of Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 *
 * @formatter:on
 */


package edu.wit.scds.ds.list.app ;

import java.util.ArrayList;
import java.util.List ;

/**
 * Representation of a pile of card
 * <p>
 * the bottom card is at position 0
 *
 * @author Aliyan Hidayatallah
 *
 * @version 1.0.0 2024-03-26 Initial implementation
 */
public class Pile
    {

	// Data field
    protected List<Card> cards;

    // Constructor
    public Pile() {
        cards = new ArrayList<>();
    }

//    // Method to shuffle the pile
//    public void shuffle() {
//        Collections.shuffle(cards);
//    }
//
//    // Method to sort the pile
//    public void sort() {
//        Collections.sort(cards);
//    }

    // Method to add a card to the pile
    public void addCard(Card card) {
        cards.add(card);
    }

    // Method to remove a card from the pile
    public void removeCard(Card card) {
        cards.remove(card);
    }

    // Method to check if the pile contains a specific card
    public boolean containsCard(Card card) {
        return cards.contains(card);
    }

    // Method to get the size of the pile
    public int size() {
        return cards.size();
    }

    // Method to deal a card from the pile (remove and return the top card)
    public Card deal() {
        if (isEmpty()) {
            throw new IllegalStateException("Pile is empty. Cannot deal a card.");
        }
        return cards.remove(0);
    }
    public Card get(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        } else {
            // Handle the case where the index is out of bounds
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
    }

    // Method to peek at the first card in the pile
    public Card peekFirstCard() {
        if (isEmpty()) {
            throw new IllegalStateException("Pile is empty. Cannot peek at first card.");
        }
        return cards.get(0);
    }

    // Method to check if the pile is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Method to clear the pile (clear all cards)
    public void clear() {
        cards.clear();
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Your Card in hand: ");
        if (cards.isEmpty()) {
            sb.append("Empty");
        } else {
            for (int i = 0; i < cards.size(); i++) {
                sb.append(i).append(": ").append(cards.get(i));
                if (i < cards.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }


    // Main method for testing the Pile class
    public static void main(String[] args) {
        // Creating a Pile and adding some cards
        Pile pile = new Pile();
        Card card1 = new Card(Card.Color.RED, Card.Value.ONE);
        Card card2 = new Card(Card.Color.BLUE, Card.Value.SKIP);
        Card card3 = new Card(Card.Color.NONE, Card.Value.WILD_DRAW_FOUR);
        pile.addCard(card1);
        pile.addCard(card2);
        pile.addCard(card3);

        // Testing toString() method
        System.out.println("Pile: " + pile);

//        // Testing shuffle() method
//        pile.shuffle();
//        System.out.println("Shuffled Pile: " + pile);
//
//        // Testing sort() method
//        pile.sort();
//        System.out.println("Sorted Pile: " + pile);

        // Testing other methods
        System.out.println("Pile size: " + pile.size());
        System.out.println("Pile contains card2: " + pile.containsCard(card2));
        System.out.println("Pile contains card3: " + pile.containsCard(card3));

        // Removing a card from the pile and testing
        pile.removeCard(card2);
        System.out.println("Pile after removing card2: " + pile);
    }

    }	// end class Pile