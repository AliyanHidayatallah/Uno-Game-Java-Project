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
 * Representation of a player
 *
 * @author Nam Tran Nguyen  // DONE
 *
 * @version 1.0.0 2024-03-26 Initial implementation
 */
public class Player
    {
    // DONE implement this

	private Hand hand ;
    private static int nextId = 1; 
    private int id;
    private String name;

	public Player( String name )
	{
		this.id = nextId++;
		this.name = name;
        this.hand = new Hand();
    }

	public Hand getHand()
	{
		return hand ;
	}
	public void setHand(Hand hand)
	{
		this.hand = hand;
	}

	public int getId()
	{
        return id;
    }
	public String getName()
	{
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        // OPTIONAL for testing and debugging

        }	// end main()

    }	// end class Player
