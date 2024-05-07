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
import java.util.List;
/**
 * Representation of a hand of cards
 *
 * @author Aliyan Hidayatallah    // TODO
 *
 * @version 1.0.0 2024-03-26 Initial implementation
 */
public class Hand extends Pile
    {

	public Hand()
	{
		super();
	}
	   public Card removeCard(int index)
	   {
	        if (index >= 0 && index < cards.size()) {
	            return cards.remove(index);
	        } else {
	            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
	        }
	    }

	    public List<Card> getCards() {
	        return cards;
	    }






    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {

    	// Create a hand
        Hand hand = new Hand();

        // Add some cards to the hand
        Card card1 = new Card(Card.Color.RED, Card.Value.ONE);
        Card card2 = new Card(Card.Color.BLUE, Card.Value.SKIP);
        Card card3 = new Card(Card.Color.NONE, Card.Value.WILD_DRAW_FOUR);
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);

        // Display the hand
        System.out.println("Hand: " + hand);

//        // Shuffle the hand
//        System.out.println("Shuffling the hand...");
//        hand.shuffle();
//        System.out.println("Shuffled Hand: " + hand);
//
//        // Sorting the hand
//        System.out.println("Sorting the hand...");
//        hand.sort();
//        System.out.println("Sorted Hand: " + hand);

        // Remove a card from the hand
        System.out.println("Removing a card from the hand...");
        hand.removeCard(card2);
        System.out.println("Hand after removing card2: " + hand);

        // Check if the hand contains a specific card
        System.out.println("Does the hand contain card1? " + hand.containsCard(card1));
        System.out.println("Does the hand contain card2? " + hand.containsCard(card2));
        System.out.println("Does the hand contain card3? " + hand.containsCard(card3));

        }	// end main()

    }	// end class Hand