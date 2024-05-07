package edu.wit.scds.ds.list.app;
/**
 * Representation of a game Uno
 *
 * @author Nam Tran Nguyen // DONE
 *
 * @version 1.0.0 2024-03-26 Initial implementation
 * @version 1.0.1 2024-03-5 create endGame
 * @version 1.0.2 2024-03-6 final version
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.wit.scds.ds.list.app.Card.Color;
import edu.wit.scds.ds.list.app.Card.Value;

public class Uno {
    private List<Player> players;
    private Deck deck;
    private Card currentCard;
    private int currentPlayerIndex;
    private boolean reverseDirection;
    private boolean gameOver;

    public Uno( int numPlayers )
    {
        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++)
        {
            players.add(new Player("Player " + (i + 1)));
        }
        deck = new Deck();
        deck.shuffle();
        // Take the first card from the deck, ensuring it's not WILD or WILD_DRAW_FOUR
        do {
            currentCard = deck.deal();
        }
        while (currentCard.getValue() == Value.WILD || currentCard.getValue() == Value.WILD_DRAW_FOUR);

        currentPlayerIndex = 0;
        reverseDirection = false;
        gameOver = false;
        dealInitialCardsToPlayers();
    }
    /**
     * Deal card from deck to player
     * Each Player has 7 cards
     */
    private void dealInitialCardsToPlayers()
    {
        for (Player player : players)
        {
            for (int i = 0; i < 7; i++)
            {
                player.getHand().addCard(deck.deal());
            }
        }
    }

    public void play()
    {
        System.out.println("Start The Uno!");

        while (!gameOver)
        {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("Current card: " + currentCard);

            // the player who runs the cards first will win
            if ( currentPlayer.getHand().isEmpty() )
            {
                System.out.println(currentPlayer.getName() + " wins!");
                gameOver = true;
                break;
            }

            System.out.println("Current player: " + currentPlayer.getName());
            System.out.println("Your hand: " + currentPlayer.getHand());

            if ( canPlay( currentPlayer )) {
                chooseCard( currentPlayer );
            } else {
                System.out.println( "You can't play any card. Drawing a card from the deck." );
                currentPlayer.getHand().addCard(drawCardFromDeck());
            }

            if ( currentPlayer.getHand().isEmpty() )
            {
                System.out.println( currentPlayer.getName() + " wins!" );
                gameOver = true;
                break;
            }

            System.out.println();
            updatePlayerIndex();
        } //end wile loop

        gameWinner();
    } //end play method

    /**
     *
     * Draw a card from deck
     */
    private Card drawCardFromDeck()
    {
        if (!deck.isEmpty())
        {
            return deck.deal();
        }
        else
        {
            System.out.println("Deck is empty!");
            return null;
        }
    }
    /**
     * check is cards on hand of play is capable with the current card
     * @param player
     * @return true if players's cards on hand can play with current card
     */
    private boolean canPlay(Player player)
    {
        for ( Card card : player.getHand().getCards() )
        {
            if ( card.isCapable(currentCard) )
            {
                return true;
            }
        } //end for-loop
        return false;
    }// end canPlay method

    /**
     * This method let the user input the index of cards to play
     *
     */
    private void chooseCard(Player player)
    {
        
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("You can input the index of card to play (enter -1 if draw from deck): ");
        int index = scanner.nextInt();
        //draw from deck if cards of player cannot be played
        if (index == -1)
        {
            Card drawnCard = deck.deal();
            player.getHand().addCard( drawnCard );
            System.out.println( "You drew from deck: " + drawnCard );
            return;
        }

        Card pickedCard = player.getHand().removeCard( index );

        if ( pickedCard.isCapable( currentCard ) ||
        		pickedCard.isWild() ||
        		pickedCard.isWildDrawFour() )
        {
        	//card is color and draw 2
            if ( pickedCard.isDrawTwo() )
            {
                currentCard = pickedCard;
                // Draw two cards for the next player
                int nextPlayerIndex;
                //check the direction
                if ( reverseDirection )
                {
                    nextPlayerIndex = ( currentPlayerIndex - 1 + players.size() ) % players.size();
                }
                else
                {
                    nextPlayerIndex = ( currentPlayerIndex + 1 ) % players.size();
                }

                Player nextPlayer = players.get(nextPlayerIndex);

                for ( int i = 0; i < 2; i++ )
                {
                    Card drawnCard = deck.deal();
                    nextPlayer.getHand().addCard( drawnCard );
                    System.out.println( "Player " + nextPlayer.getId() + " drew from deck: " + drawnCard) ;
                }
            }
            //card is Wild Draw Four
            else if ( pickedCard.isWildDrawFour() )
            {

                System.out.print("Please enter the next color (RED, YELLOW, GREEN, BLUE) that you want: ");
                Color chosenColor = Color.valueOf(scanner.next().toUpperCase());
                currentCard = new Card(chosenColor, Value.WILD_DRAW_FOUR);
                // Draw four cards for the next player
                int nextPlayerIndex;
                if (reverseDirection) 
                {
                    nextPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
                }
                else
                {
                    nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
                }
                Player nextPlayer = players.get(nextPlayerIndex);
                //player draw 4 cards
                for (int i = 0; i < 4; i++) {
                    Card drawnCard = deck.deal();
                    nextPlayer.getHand().addCard(drawnCard);
                    System.out.println("Player " + nextPlayer.getId() + " drew: " + drawnCard);
                }
            }
            // card is Wild
            else if ( pickedCard.isWild() )
            {
                // Prompt the player to choose the next color
                System.out.print("Please enter the next color (RED, YELLOW, GREEN, BLUE) that you want: ");
                Color chosenColor = Color.valueOf(scanner.next().toUpperCase());
                currentCard = new Card(chosenColor, Value.WILD);
            }
           //card is color and skip
            else if (pickedCard.isSkip())
            {
                int nextPlayerIndex;
                if (reverseDirection) {
                    nextPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
                } else {
                    nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
                }
                Player nextPlayer = players.get(nextPlayerIndex);
                System.out.println("Player " + nextPlayer.getId() + " is skipped.");
                currentPlayerIndex = nextPlayerIndex;
            }
          //card is color and reverse
            else if ( pickedCard.isReverse() )
            {
                reverseDirection = !reverseDirection;
                System.out.println("The direction of play is reversed.");
            }
            else
            {
                currentCard = pickedCard;
            }

            System.out.println("You played: " + pickedCard);
            int numCardsLeft = player.getHand().size();
            if (numCardsLeft == 1){
                System.out.println(player.getName() + " said: UNO");
            }
            // Handle special card effects like Reverse, Skip, etc.
            // This code is not included in the provided snippet.
        }
        else
        {
            System.out.println("Invalid card selection. Try again.");
            player.getHand().addCard(pickedCard);
        }

    }// end chooseCard

    /**
     * update the PlayerIndex if reverse occur
     */
    private void updatePlayerIndex()
    {
        if (!reverseDirection) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }

    /**
     * Print out the Winner Player
     */
    private void gameWinner() {
        if ( gameOver )
        {
            Player winner = players.get( currentPlayerIndex );
            System.out.println("The winner is: " + winner.getName());
        }
    } //end gameWinner
/**
 * Ask the user to enter number of players
 * @param args comment-line, ignore
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        if ( numPlayers >=2 && numPlayers <=10) {
            Uno unoGame = new Uno(numPlayers);
            unoGame.play();
        }
        else
        {
        	System.out.println("This Uno allows from 2 people to 10 people.");
        }

        scanner.close();
    }
}


