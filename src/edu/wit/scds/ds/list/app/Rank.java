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

/**
 * An enumeration of card ranks.
 *
 * @author David M Rosenberg
 *
 * @version 1.0.0 2016-03-16 initial version
 * @version 1.1.0 2022-11-06 add switches for standard vs alternate points and order
 *
 * @author Anthony Maldonado    // DONE
 *
 * @version 1.2.0 2024-03-26 Modifications for use for our game
 */
public enum Rank
    {

/**
 *
 */
// @formatter:off
//  Element     Display Name    Graphic     Color

    /*
     * Red UNO cards
     */

    /**
     * Red Zero
     */
    RED_ZERO("Zero", "0", "Red"),

    /**
     * Red One
     */
    RED_ONE("One", "1", "Red"),

    /**
     * Red Two
     */
    RED_TWO("Two", "2", "Red"),
    /**
     * Red Three
     */
    RED_THREE("Three", "3", "Red"),

    /**
     * Red Four
     */
    RED_FOUR("Four", "4", "Red"),

    /**
     * Red Five
     */
    RED_FIVE("Five", "5", "Red"),

    /**
     * Red Six
     */
    RED_SIX("Six", "6", "Red"),

    /**
     * Red Seven
     */
    RED_SEVEN("Seven", "7", "Red"),

    /**
     * Red Eight
     */
    RED_EIGHT("Eight", "8", "Red"),

    /**
     * Red Nine
     */
    RED_NINE("Nine", "9", "Red"),

    /**
     * Red Skip
     */
    RED_SKIP("Skip", "S", "Red"),

    /**
     * Red Draw Two
     */
    RED_DRAW_TWO("Draw Two", "+2", "Red"),

    /**
     * Red Reverse
     */
    RED_REVERSE("Reverse", "R", "Red"),


    /*
     * Blue UNO cards
     */

    /**
     * Blue Zero
     */
    BLUE_ZERO("Zero", "0", "Blue"),

    /**
     * Blue One
     */
    BLUE_ONE("One", "1", "Blue"),

    /**
     * Blue Two
     */
    BLUE_TWO("Two", "2", "Blue"),

    /**
     * Blue Three
     */
    BLUE_THREE("Three", "3", "Blue"),

    /**
     * Blue Four
     */
    BLUE_FOUR("Four", "4", "Blue"),

    /**
     * Blue Five
     */
    BLUE_FIVE("Five", "5", "Blue"),

    /**
     * Blue Six
     */
    BLUE_SIX("Six", "6", "Blue"),

    /**
     * Blue Seven
     */
    BLUE_SEVEN("Seven", "7", "Blue"),

    /**
     * Blue Eight
     */
    BLUE_EIGHT("Eight", "8", "Blue"),

    /**
     * Blue Nine
     */
    BLUE_NINE("Nine", "9", "Blue"),

    /**
     * Blue Skip
     */
    BLUE_SKIP("Skip", "S", "Blue"),

    /**
     * Blue Draw Two
     */
    BLUE_DRAW_TWO("Draw Two", "+2", "Blue"),

    /**
     * Blue Reverse
     */
    BLUE_REVERSE("Reverse", "R", "BLUE"),

    /*
     * Green UNO cards
     */

    /**
     * Green Zero
     */
    GREEN_ZERO("Zero", "0", "Green"),

    /**
     * Green One
     */
    GREEN_ONE("One", "1", "Green"),

    /**
     * Green Two
     */
    GREEN_TWO("Two", "2", "Green"),

    /**
     * Green Three
     */
    GREEN_THREE("Three", "3", "Green"),

    /**
     * Green Four
     */
    GREEN_FOUR("Four", "4", "Green"),

    /**
     * Green Five
     */
    GREEN_FIVE("Five", "5", "Green"),

    /**
     * Green Six
     */
    GREEN_SIX("Six", "6", "Green"),

    /**
     * Green Seven
     */
    GREEN_SEVEN("Seven", "7", "Green"),

    /**
     * Green Eight
     */
    GREEN_EIGHT("Eight", "8", "Green"),

    /**
     * Green Nine
     */
    GREEN_NINE("Nine", "9", "Green"),

    /**
     * Green Skip
     */
    GREEN_SKIP("Skip", "S", "Green"),

    /**
     * Green Draw Two
     */
    GREEN_DRAW_TWO("Draw Two", "+2", "Green"),

    /**
     * Green Reverse
     */
    GREEN_REVERSE("Reverse", "R", "Green"),

    /*
     * Yellow UNO cards
     */

    /**
     * Yellow Zero
     */
    YELLOW_ZERO("Zero", "0", "Yellow"),

    /**
     * Yellow One
     */
    YELLOW_ONE("One", "1", "Yellow"),

    /**
     * Yellow Two
     */
    YELLOW_TWO("Two", "2", "Yellow"),

    /**
     * Yellow Three
     */
    YELLOW_THREE("Three", "3", "Yellow"),

    /**
     * Yellow Four
     */
    YELLOW_FOUR("Four", "4", "Yellow"),

    /**
     * Yellow Five
     */
    YELLOW_FIVE("Five", "5", "Yellow"),

    /**
     * Yellow Six
     */
    YELLOW_SIX("Six", "6", "Yellow"),

    /**
     * Yellow Seven
     */
    YELLOW_SEVEN("Seven", "7", "Yellow"),

    /**
     * Yellow Eight
     */
    YELLOW_EIGHT("Eight", "8", "Yellow"),

    /**
     * Yellow Nine
     */
    YELLOW_NINE("Nine", "9", "Yellow"),

    /**
     * Yellow Skip
     */
    YELLOW_SKIP("Skip", "S", "Yellow"),

    /**
     * Yellow Draw Two
     */
    YELLOW_DRAW_TWO("Draw Two", "+2", "Yellow"),

    /**
     * Yellow Reverse
     */
    YELLOW_REVERSE("Reverse", "R", "Yellow"),


    /*
     * Wild UNO cards
     */

    /**
     * Wild card
     */
    WILD("Wild", "W", "None"),

    /**
     * Draw Four Card
     */
    WILD_DRAW_FOUR("Wild Draw Four", "+4", "None");

// @formatter:on


    // static fields
    /** when true, evaluations will use {@code altPoints} instead of {@code points} */
   // private static boolean useAltPoints = false ;
    /** when true, evaluations will use {@code altOrder} instead of {@code order} */
    //private static boolean useAltOrder = false ;

    // data fields
    /** 'pretty' name for the rank */
    private final String displayName;
    private final String graphic;
    private final String color;


    /*
     * constructor
     */


    /**
     * Sets all fields representing a card rank
     *
     * @param rankdisplayName
     *     more esthetically pleasing for display
     * @param rankgraphic
     *     the 'standard' icon
     * @param rankcolor
     *     color for the card
     */
    private Rank( final String rankdisplayName,
                  final String rankgraphic,
                  final String rankcolor)
        {
        this.displayName = rankdisplayName;
        this.graphic = rankgraphic;
        this.color = rankcolor;

        } // end constructor


    /*
     * getters
     */


    /**
     * Retrieves the display name
     *
     * @return the display name
     */
    public String getDisplayName()
        {
        return this.displayName ;

        } // end getDisplayName()


    /**
     * Retrieves the graphic/icon
     *
     * @return the graphic/icon
     */
    public String getGraphic()
        {
        return this.graphic ;

        } // end getGraphic()


    /**
     * Retrieves the color
     *
     * @return the color of the card
     */
    public String getColor()
        {
        return this.color ;

        } // end getColor()


    /*
     * utility methods
     */


    /**
     * For display, use the graphic/icon
     */
    @Override
    public String toString()
        {
        return this.graphic ;

        }   // end toString()


    /**
     * Test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        // display column headers
        System.out.printf( "%-5s %-8s %-8s %-8s%n", "#",
                           "Rank",
                           "Graphic",
                           "Color" ) ;

        // display each element of the enumeration
        for (final Rank aRank : Rank.values()) {
        System.out.printf("%-5d %-8s %-8s %-8s%n",
                          aRank.ordinal(),
                          aRank,
                          aRank.graphic,
                          aRank.color);

            }   // end for

        }   // end main()

    } // end enum Rank