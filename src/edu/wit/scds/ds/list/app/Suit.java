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
 * An enumeration of card suits. (Listing C-2 of Appendix C.)
 * <p>
 * You may want/need to adjust the priorities for your game. As provided, suits are ordered by
 * priority:<br>
 *
 * <pre>
 * Spades (highest) -> Diamonds -> Hearts -> Clubs -> none (lowest)
 * </pre>
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 *
 * @version 4.0
 *
 * @author David M Rosenberg
 *
 * @version 4.1.0 2016-03-16
 *     <ul>
 *     <li>enhanced definition: added display name and graphic
 *     <li>added test driver main()
 *     </ul>
 * @version 4.1.1 2021-11-19
 *     <ul>
 *     <li>fill in Javadoc comments
 *     <li>add Comparator/compare()
 *     </ul>
 * @version 4.2.0 2022-11-06 add switch for standard vs alternate priority
 *
 * @author Anthony Maldonado    // DONE
 *
 * @version 4.3.0 2024-03-26 Modifications for use for our game
 */
public enum Suit
    {

    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow"),
    DRAW_TWO("Draw Two"),
    DRAW_FOUR("Draw Four"),
    SKIP("Skip"),
    WILD("Wild"),
    REVERSE("Reverse");

    // data field
    private final String displayName;

    /**
     * Constructor to initialize each suit with a display name.
     * @param displayName1 The display name of the suit.
     */
    Suit(String displayName1) {
        this.displayName = displayName1;
    }

    /**
     * Retrieves the display name of the suit.
     * @return The display name of the suit.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Test driver for the Suit enum.
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        // Display column headers
        System.out.printf("%-5s %-8s%n", "Index", "Suit");

        // Display each suit in the enumeration
        for (Suit suit : Suit.values()) {
            System.out.printf("%-5d %-8s%n", suit.ordinal(), suit.getDisplayName());

            }   // end for

        }   // end main()

    }   // end enum Suit