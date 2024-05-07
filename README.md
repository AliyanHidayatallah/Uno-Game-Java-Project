# Uno Game Java Project

Welcome to the Uno Game Java project! This project aims to provide a simple yet comprehensive implementation of the popular Uno card game in Java. The game follows standard Uno rules with a few modifications for simplicity and clarity.

## Rules

- The objective of the Uno Game is to be the first player to have no more cards in their hand.
- Customizable cards are omitted to use the basic Uno set.
- A defined color card is drawn from the deck at the beginning to start the game.
- The player with only one card left must say "Uno".
- The player with no cards left is declared the winner.

## Uno Class

The `Uno` class manages the entire game, accommodating 2 to 10 players. Key design decisions include:

- Dealing an initial set of cards from the deck to each player (7 cards each).
- Validating whether a player's card can be played based on the current card.
- Allowing players to choose cards to play or draw another one.
- Tracking skipped turns, drawn cards, and direction reversals.
- Determining the winner of the game.

## Card Class

The `Card` class models a single card in an Uno game. Design decisions include:

- Defining enums for color and value.
- Implementing the `Comparable<Card>` interface for comparison based on color and value.
- Providing methods to check specific card attributes.
- Including a main method for testing card functionalities.

## Pile Class

The `Pile` class represents a pile of cards in the Uno game. It includes:

- A data field `cards` which is a list of `Card` objects.
- Methods for adding/removing cards, checking card presence, and getting the size of the pile.
- A `toString()` method to return a string representation of the pile.
- A main method for testing pile functionalities.

## Deck Class

The `Deck` class inherits from the `Pile` class and represents the Uno game deck. It includes:

- A method to build the deck with 108 cards.
- A `shuffle()` method to shuffle all cards in the deck.
- Utilization of the discard pile to refill the deck.

## Hand Class

The `Hand` class extends the `Pile` class and represents a player's hand in the Uno game. It includes:

- Inheritance of functionalities from the `Pile` class.
- A `removeCard(int index)` method to remove a card from the hand at a specific index.
- A `getCards()` method to return a list of cards in the hand.
- A main method for testing class functionalities.

## Player Class

The `Player` class represents a player in the Uno game. Key design decisions include:

- Data fields to track player information and the next player.
- A `hand` field and `getHand()` method to interact with cards in the player's hand.

## Rank & Suit Class

These classes represent the attributes of the cards for the game, including color attributes for each card.
