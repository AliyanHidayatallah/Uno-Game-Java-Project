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

//import java.util.ArrayList ;
//import java.util.Collections ;
//import java.util.List ;
import java.util.Objects ;

/**
 * Representation of a playing card with a suit and rank.
 * <p>
 * The suit and rank are immutable.
 *
 * @author Dave Rosenberg
 *
 * @version 1.0.0 2020-11-19 initial version<br>
 * @version 2.0.0 2021-12-08
 *     <ul>
 *     <li>add support for face up/down
 *     <li>add {@code matches()}
 *     </ul><br>
 * @version 2.1.0 2022-11-06 support dynamic switching to compare cards based on suit and rank or
 *     rank alone<br>
 * @version 2.2.0 2024-03-26
 *     <ul>
 *     <li>minor cosmetic changes
 *     <li>revise {@code toString()} for greater formatting flexibility and control
 *     </ul><br>
 *
 * @author Aliyan Hidayatallah    // TODO
 *
 * @version 2.3.0 2024-03-26 Modifications for use for our game
 */
public class Card implements Comparable<Card>
    {
	// Enum for Color
    enum Color {
        RED, BLUE, GREEN, YELLOW, NONE;
    }

    // Enum for Value
    enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR;
    }

    // Instance variables
    private final Color color;
    private final Value value;


    // Constructor
    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    // Getter methods
    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    // Overriding methods
    @Override
    public int compareTo(Card other) {
        // Compare based on color and then value
        int colorComparison = this.color.compareTo(other.color);
        if (colorComparison != 0) {
            return colorComparison;
        } else {
            return this.value.compareTo(other.value);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return this.color == other.color && this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, value);
    }

    @Override
    public String toString() {
        return color + " " + value;
    }



    public boolean isCapable(Card previousCard) {
        return this.color == previousCard.getColor() ||
                this.value == previousCard.getValue() ||
                this.color == Color.NONE;
    }
    public boolean isReverse() {
        return this.value == Value.REVERSE;
    }

    public boolean isSkip() {
        return this.value == Value.SKIP;
    }

    public boolean isDrawTwo() {
        return this.value == Value.DRAW_TWO;
    }

    public boolean isWildDrawFour() {
        return this.value == Value.WILD_DRAW_FOUR;
    }

    public boolean isWild() {
        return this.value == Value.WILD;
    }

    /**
     * Sample demo program
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
    	Card redThree = new Card(Color.RED, Value.THREE);
        Card blueSkip = new Card(Color.BLUE, Value.SKIP);
        Card wildDrawFour = new Card(Color.NONE, Value.WILD_DRAW_FOUR);

        // Testing toString() method
        System.out.println("Red Three: " + redThree);
        System.out.println("Blue Skip: " + blueSkip);
        System.out.println("Wild Draw Four: " + wildDrawFour);

        // Testing compareTo() method
        System.out.println("Comparison:");
        System.out.println("Red Three compared to Blue Skip: " + redThree.compareTo(blueSkip));
        System.out.println("Blue Skip compared to Wild Draw Four: " + blueSkip.compareTo(wildDrawFour));
        System.out.println("Red Three compared to itself: " + redThree.compareTo(redThree));

        // Testing equals() method
        System.out.println("Equality:");
        System.out.println("Red Three equals to Blue Skip: " + redThree.equals(blueSkip));
        System.out.println("Red Three equals to itself: " + redThree.equals(redThree));

        }	// end main()

    }	// end class Card