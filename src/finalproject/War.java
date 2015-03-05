//ISE208 Final Project War Game
// Louise Lo
// 105884422
package finalproject;

import java.io.*;
import java.util.ArrayList;

public class War {

Deck gamedeck;
ArrayList<Card> playingfield = new ArrayList<Card>();
ArrayList<Card> player1;
ArrayList<Card> player2;
Card p1cardinplay;
Card p2cardinplay;
Card p1warcardinplay;
Card p2warcardinplay;
int p1wars;
int p2wars;
boolean waroccuring = false;
String player1name;
String player2name;
int round;
FileOutputStream out;
PrintStream p;

public War()
{
    //Used for printing to output file containing record of actions and scores
    try{      
        out = new FileOutputStream("WarGameLog.txt", true);
        p = new PrintStream( out );
        p.println("New Game");
    }
    catch(IOException e)
    {
        System.out.print("Error writing to File");
    }
        player1name = "Player 1";
        player2name = "Player 2";
	gamedeck = new Deck();
	gamedeck.shuffle2();
	gamedeck.shuffle2();
	gamedeck.shuffle2();
	player1 = new ArrayList<Card>();
	player2 = new ArrayList<Card>();
	handoutcards();
	p1wars = 0;
	p2wars = 0;
        round = 0;
}
//Used by the constructor to distribute cards to each player.
public void handoutcards()
{
	int x;
	for (x=0;x<52;x=x+2)
	{
		player1.add(gamedeck.getCard(x));
		player2.add(gamedeck.getCard(x+1));
	}

}
//Prints the number of cards each player has.
public void display()
{
	System.out.println(player1name + ": " +player1.size() + " Cards");
        p.println(player1name + ": " +player1.size() + " Cards");
    
	System.out.println(player2name + ": " +player2.size()+ " Cards");
        p.println(player2name + ": " +player2.size()+ " Cards");
}
//Takes arguments an arraylist of cards and player number
//Sets the players card in play or war cards in play
//Moves the cards played from the player's hand to the playing field
public void playCard(ArrayList<Card> player, int playernumber)
{
	if (playernumber ==1)
	{
                if(waroccuring ==true)
                {
                    p1warcardinplay=player.get(0);
                }
                else
                {
                    p1cardinplay=player.get(0);
                }
	}
	if (playernumber ==2)
	{
            if (waroccuring == true)
            {
                 p2warcardinplay=player.get(0);
            }
            else
            {
		p2cardinplay=player.get(0);
            }


	}
	playingfield.add(player.get(0));
	player.remove(0);

}

//Checks if the game win/lost condition are met
//Player wins by winning 3 wars or if the other player runs out of cards
//If both players run out of cards, there is a draw
public boolean gameover()
{
	if (p1wars == 3 || player2.size()==0)
	{
		System.out.println(player1name + " Wins");
                p.println(player1name + " Wins");
		return true;
	}
	if (p2wars == 3 || player1.size()==0)
	{
		System.out.println(player2name + " Wins");
                p.println(player2name + " Wins");
		return true;
	}
	if (player1.size()==0 && player2.size()==0)
	{
		System.out.println("Draw");
                p.println("Draw");
		return true;
	}
	return false;
}

//Administers each round of the game
public void round()
{   
	if (gameover()==false)
	{
        round ++;
        System.out.println("Round " + round);
        p.println("Round " + round);
        display();
        p1warcardinplay = null;
        p2warcardinplay = null;
        waroccuring = false;
	playCard(player1, 1);
	System.out.println(player1name + ": " + p1cardinplay.toString());
        p.println(player1name + ": " + p1cardinplay.toString());
	playCard(player2, 2);
	System.out.println(player2name + ": " + p2cardinplay.toString());
        p.println(player2name + ": " + p2cardinplay.toString());
	if (p1cardinplay.getValue()==p2cardinplay.getValue())
	{
		war();
	}
	else if (isgreater(p1cardinplay,p2cardinplay))
	{
		player1.addAll(playingfield);
		playingfield.clear();
                System.out.println(player1name + " wins round " + round);
                p.println(player1name + " wins round " + round);
	}
	else
	{
		player2.addAll(playingfield);
		playingfield.clear();
                System.out.println(player2name + " wins round " + round);
                p.println(player2name + " wins round " + round);
	}
	}
	else
	{
            System.out.println("Game Over");
            p.println("Game Over");
            gameover();
	}
        
	display();
}

//Administers a war
public void war()
{
        try{
        waroccuring = true;
	System.out.println("WAR");
        p.println("WAR");
	playCard(player1, 1);
	System.out.println(player1name + ": XX" );
        p.println(player1name + ": XX" );
	playCard(player1, 1);
	System.out.println(player1name + ": " + p1warcardinplay.toString());
        p.println(player1name + ": " + p1warcardinplay.toString());
	playCard(player2, 2);
	System.out.println(player2name + ": XX" );
        p.println(player2name + ": XX" );
	playCard(player2, 2);
	System.out.println(player2name + ": " + p2warcardinplay.toString());
        p.println(player2name + ": " + p2warcardinplay.toString());
        
	if (p1warcardinplay.getValue()==p2warcardinplay.getValue())
	{
		war();
	}
	else if (isgreater(p1warcardinplay,p2warcardinplay))
	{
		player1.addAll(playingfield);
		playingfield.clear();
		p1wars ++;
                System.out.println(player1name + " wins the war");
                p.println(player1name + " wins the war");
                System.out.println(player1name + " wins round " + round);
                p.println(player1name + " wins round " + round);
	}
	else
	{
		player2.addAll(playingfield);
		playingfield.clear();
		p2wars ++;
                System.out.println(player2name + " wins the war");
                System.out.println(player2name + " wins round " + round);
                p.println(player2name + " wins the war");
                p.println(player2name + " wins round " + round);
	}}
        catch(IndexOutOfBoundsException e){
		System.out.println("A Player has run out of cards");
                p.println("A Player has run out of cards");
	}
}
//Takes two card arguments
//Returns true if the first card has a greater value than the second
//Ace is the largest card
//Is used by the round and war methods
public boolean isgreater(Card card1, Card card2)
{
	if (card1.getValue()== card2.getValue())
	{
		return false;
	}
	else
	{
		if (card1.getValue()!=1 && card1.getValue() < card2.getValue())
		{
			return false;
		}

	}
	return true;
}

public static void main (String [] args) 
{
War test = new War();
	test.round();
	test.round();
}
}