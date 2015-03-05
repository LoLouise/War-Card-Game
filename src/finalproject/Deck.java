package finalproject;

//ISE208 HW3
//Louise Lo
//105884422

import java.util.*;
public class Deck {

ArrayList<Card> deck;
Random generator = new Random();

//Constructor - creates a deck
public Deck()
{
deck = new ArrayList<Card>(52);
deckfiller();
}

//Note D = Diamond, C = Clubs, H = Hearts, S = Spades, 1 = Ace, 11 = Jack, 12 = Queen, 13 = King
//Fills the deck of cards in accending value with 
//Ace of Diamonds as the lowest and King of Spades as the highest
public void deckfiller()
{
	int i;
	for (i=1; i<=13; i++)
	{
		Card tempD = new Card (i, 'D');
		deck.add(tempD);
		Card tempC = new Card (i, 'C');
		deck.add(tempC);
		Card tempH = new Card (i, 'H');
		deck.add(tempH);
		Card tempS = new Card (i, 'S');
		deck.add(tempS);
	}
}
public void addCard (Card cardtoadd)
{
	deck.add(cardtoadd);
}
public Card getCard(int position)
{
	return deck.get(position);
}
public void removeCard(int position)
{
	deck.remove(position);
}
public void addCards(ArrayList<Card> cards)
{
	int i;
	for (i=0; i<cards.size();i++)
	{
		deck.add(cards.get(i));
	}
}
//I chose to write a print method instead of a toString method since
//I already wrote a toString method for the Card Class
//This better facilitates printing each Card on a different line
public void print()
{
	int a;
	for (a=0;a<deck.size(); a++)
	{
		System.out.println(a + ": " + deck.get(a).toString());
	}
}


//Shuffle method that removes a random card and places it at the end of the deck
//Repeats 25 times
public void shuffle()
{
	//System.out.print("Shuffling numbers: ");
	int x;
	//Change max of x to shuffle a different number of times
	for (x=0;x<25;x++)
	{
	int randomIndex = generator.nextInt(52);
	//System.out.print(randomIndex+ ",");
	Card temptomove = deck.get(randomIndex);
	deck.remove(randomIndex);
	deck.add(temptomove);
	}
	System.out.println();
}

//Extra Credit Shuffle Method: swaps two random cards
//Repeats 25 times
public void shuffle2()
{
	//System.out.print("Shuffling numbers pairs: ");
	int y;
	//Change max of y to shuffle a different number of times
	for (y=0;y<25;y++)
	{
	int randomIndex1 = generator.nextInt(52);
	int randomIndex2 = generator.nextInt(52);
	//System.out.print("(" + randomIndex1+ "," + randomIndex2 + ") ");
	Card temptoswap1 = deck.get(randomIndex1);
	Card temptoswap2 = deck.get(randomIndex2);
	deck.set(randomIndex1, temptoswap2);
	deck.set(randomIndex2, temptoswap1);
	}
	System.out.println();
}

public static void main (String [] args)
{
	//Creates a new test deck
	Deck test = new Deck();
	//Prints the new ordered deck before shuffling
	System.out.println("New Ordered Deck");
	test.print();
	
	//Shuffles by removing and adding to end (25 times)
	System.out.println();
	System.out.println("Deck after using move to end shuffling");
	test.shuffle();
	test.print();
	
	//Creates a second test deck
	Deck test2 = new Deck();
	//Shuffles by swapping two cards (25 times)
	System.out.println();
	System.out.println("Deck after using swap shuffling");
	test2.shuffle2();
	test2.print();
	
	System.out.print("Card at position 5: " + test2.getCard(5).toString());
	
	//Example of creating a new card and calling the card methods
	Card myCard = new Card (12, 'H');
	System.out.println();
	System.out.println("Value of my Card: " + myCard.getValue());
	System.out.println("Suit of my Card: " + myCard.getSuit());
	System.out.println("My Card: " + myCard.toString());
	
}
}
