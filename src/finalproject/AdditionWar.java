package finalproject;

import java.util.ArrayList;


public class AdditionWar extends War {


Card p1cardinplay2;
Card p2cardinplay2;
Card p1warcardinplay2;
Card p2warcardinplay2;

public AdditionWar(
		)
{
	super();
        p.println("Addition War");
}

    @Override
public boolean gameover()
{
	if (p1wars == 3 || player2.size()==0 ||player2.size()==1)
	{
		System.out.println(player1name + " Wins");
                p.println(player1name + " Wins");
		return true;
	}
	if (p2wars == 3 || player1.size()==0 || player1.size()==1)
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
public void displayplayfield()
    {
        int a;
        System.out.print("PlayingField: ");
        p.print("PlayingField: ");
	for (a=0;a<playingfield.size(); a++)
	{
            
            System.out.print("(" + a + ": " + playingfield.get(a).toString()+") ");
            p.print("(" + a + ": " + playingfield.get(a).toString()+") ");
	}
        System.out.println();
        p.println();
    }

@Override
public void playCard(ArrayList<Card> player, int playernumber)
{
	if (playernumber ==1)
	{
            if (waroccuring == false)
            {
		p1cardinplay=player.get(0);
		p1cardinplay2=player.get(1);
            }
            else
            {
                p1warcardinplay=player.get(0);
		p1warcardinplay2=player.get(1);
            }
	}
	if (playernumber ==2)
	{
            if (waroccuring == false)
            {
		p2cardinplay=player.get(0);
		p2cardinplay2=player.get(1);
            }
            else
            {
                p2warcardinplay=player.get(0);
		p2warcardinplay2=player.get(1);
            }
	}
	playingfield.add(player.get(0));
	playingfield.add(player.get(1));
	player.remove(0);
        player.remove(0);
		
}

    @Override
public void round()
{
	if (gameover()==false)
	{
        round ++;
        System.out.println("Round " + round);
        display();
        p1warcardinplay = null;
        p2warcardinplay = null;
        p1warcardinplay2 = null;
        p2warcardinplay2 = null;
        waroccuring = false;
	playCard(player1, 1);
	System.out.println(player1name + ": "  + p1cardinplay.toString());
	System.out.println(player1name + ": "  + p1cardinplay2.toString());
        p.println(player1name + ": "  + p1cardinplay.toString());
	p.println(player1name + ": "  + p1cardinplay2.toString());
   //     displayplayfield();
    //    display();
	playCard(player2, 2);
	System.out.println(player2name + ": " + p2cardinplay.toString());
	System.out.println(player2name + ": " + p2cardinplay2.toString());
        p.println(player2name + ": " + p2cardinplay.toString());
	p.println(player2name + ": " + p2cardinplay2.toString());
       // displayplayfield();
     //   display();
	if ((p1cardinplay.getValue()+p1cardinplay2.getValue())==(p2cardinplay.getValue()+p2cardinplay2.getValue()))
	{
		war();
                return;
	}
	else if (isgreater(p1cardinplay,p1cardinplay2,p2cardinplay, p2cardinplay2))
	{
		player1.addAll(playingfield);
		playingfield.clear();
         //       displayplayfield();
                System.out.println(player1name + " wins round " + round);
                p.println(player1name + " wins round " + round);
           //     display();
	}
	else
	{
		player2.addAll(playingfield);
		playingfield.clear();
         //       displayplayfield();
                System.out.println(player2name + " wins round " + round);
                p.println(player2name + " wins round " + round);
             //   display();
	}
	}
        else
        {
            gameover();
        }
	display();
}
    @Override
public void war()
{
        waroccuring = true;
	System.out.println("WAR");
        p.println("WAR");
        try{
	super.playCard(player1, 1);
	System.out.println(player1name + ": XX");
        p.println(player1name + ": XX");
 
	super.playCard(player1, 1);
	System.out.println(player1name + ": XX");
        p.println(player1name + ": XX");
   
	super.playCard(player1, 1);
	System.out.println(player1name + ": XX");
        p.println(player1name + ": XX");
  
	playCard(player1, 1);
	System.out.println(player1name + ": " + p1warcardinplay.toString());
	System.out.println(player1name + ": " + p1warcardinplay2.toString());
        p.println(player1name + ": " + p1warcardinplay.toString());
	p.println(player1name + ": " + p1warcardinplay2.toString());
    
	super.playCard(player2, 2);
	System.out.println(player2name + ": XX");
        p.println(player2name + ": XX");

	super.playCard(player2, 2);
	System.out.println(player2name + ": XX");
        p.println(player2name + ": XX");

	super.playCard(player2, 2);
	p.println(player2name + ": XX");
        
	playCard(player2, 2);
	System.out.println(player2name + ": " + p2warcardinplay.toString());
	System.out.println(player2name + ": " + p2warcardinplay2.toString());
        p.println(player2name + ": " + p2warcardinplay.toString());
	p.println(player2name + ": " + p2warcardinplay2.toString());

	if ((p1warcardinplay.getValue()+p1warcardinplay2.getValue())==(p2warcardinplay.getValue()+p2warcardinplay2.getValue()))
	{
		war();
	}
	else if (isgreater(p1warcardinplay,p1warcardinplay2,p2warcardinplay, p2warcardinplay2))
	{
		player1.addAll(playingfield);
		playingfield.clear();
                System.out.println(player1name + " wins the war");
                System.out.println(player1name + " wins round " + round);
                p.println(player1name + " wins the war");
                p.println(player1name + " wins round " + round);
   
		p1wars ++;
	}
	else
	{
		player2.addAll(playingfield);
		playingfield.clear();
                System.out.println(player2name + " wins the war");
                System.out.println(player2name + " wins round " + round);
                p.println(player2name + " wins the war");
                p.println(player2name + " wins round " + round);
          
		p2wars ++;
	}
        }
        catch(IndexOutOfBoundsException e){
		System.out.println("A Player has run out of cards");
                p.println("A Player has run out of cards");
	}
}
public boolean isgreater(Card card11, Card card12, Card card21, Card card22)
{
	if ((card11.getValue()+ card12.getValue())== (card21.getValue()+card22.getValue()))
	{
		return false;
	}
	else
	{
		if ((card11.getValue()+ card12.getValue())!=1 && (card11.getValue()+ card12.getValue()) < (card21.getValue()+card22.getValue()))
		{
			return false;
		}
		
	}
	return true;
}
public static void main (String [] args)
{
	AdditionWar test = new AdditionWar();

	test.round();

	test.round();

	test.round();

}
}
