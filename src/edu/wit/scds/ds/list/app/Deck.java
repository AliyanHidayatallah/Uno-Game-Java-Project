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


package edu.wit.scds.ds.list.app;

import java.util.Collections;

/**
 * Representation of a deck of cards
 *
 * @author Nam Tran Nguyen // DONE
 *
 * @version 1.0.0 2024-03-26 Initial implementation
 */

import edu.wit.scds.ds.list.app.Card.Color;
import edu.wit.scds.ds.list.app.Card.Value;

public class Deck extends Pile
	{
	// DONE implement this

	    // Constructor
	    public Deck()
	    {
	        super(); // Call the constructor of the superclass (Pile)
	        initializeDeck();
	    }

		/**
		 * Build a Deck
		 */
		private void initializeDeck() {
			addNumberCards();
			addActionAndZeroCards();
			addWildCards();
		}

	    /**
	     * Add the NumberCards(1-9) to build Deck.
	     *
	     * Although the cards has from 0-9,
	     * each color has 2 cards of number 1-9
	     * Card with number 0 has only 1 card
	     */
	    public void addNumberCards() {
	        for ( Color color : Color.values() )
	        {
	            if ( color != Color.NONE )
	            {
	                for (int i = 1; i <= 9; i++)
	                {
	                    addCard( new Card( color, Value.values()[i] ) );
	                }
	            }
	        } //end for-loop
	    } //end addNumberCards

	    /**
	     * Add the ActionCards and 0 to build Deck.
	     *
	     * Although the cards has from 0-9,
	     * each color has 2 cards of number 1-9
	     * Card with number 0 has only 1 card
	     */
	    private void addActionAndZeroCards() {
			for ( Color color : Color.values() )
			{
				if ( color != Color.NONE )
				{
					// Add only 1 card of with number 0
					addCard( new Card( color, Value.ZERO ) );
					addCard(new Card(color, Value.SKIP));
					addCard(new Card(color, Value.SKIP));
					addCard(new Card(color, Value.REVERSE));
					addCard(new Card(color, Value.REVERSE));
					addCard(new Card(color, Value.DRAW_TWO));
					addCard(new Card(color, Value.DRAW_TWO));
				}
			} // end for-loop
		} // end addActionAndZeroCards

	    /**
	     * Add the Wild Card to build Deck
	     */
	    private void addWildCards()
	    {
			for (int i = 0; i < 4; i++)
			{
				addCard( new Card( Color.NONE, Value.WILD ) );
				addCard( new Card( Color.NONE, Value.WILD_DRAW_FOUR ) );
			}
		} //end addWildCards

	    /**
	     * shuffle the deck
	     */
	    public void shuffle()
	    {
			Collections.shuffle( cards );
		}


	    /**
	     * Use the discard pile to re-stock the deck
	     * @param discardPile
	     */
	    public void reufillDeck(Pile discardPile)
	    {
			Card top = discardPile.peekFirstCard();
			shuffle();
			cards.add(top);
			for ( int i = 1; i < discardPile.size(); i++ )
			{
				cards.add(discardPile.get(i));
			}// end for loop
		}// end the refillDeck



	/**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
	public static void main( String[] args )
		{
        // OPTIONAL for testing and debugging

		}	// end main()

	}	// end class Deck
