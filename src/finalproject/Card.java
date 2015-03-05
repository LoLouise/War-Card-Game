package finalproject;

//ISE208 HW3
//Louise Lo
//105884422
public class Card {	
int value;
char suit;
public Card(int cardvalue, char cardsuit)
{
	value = cardvalue;
	suit = cardsuit;
}
public int getValue()
{
	return value;
}
public char getSuit()
{
	return suit;
}
public String toString()
{
	return Integer.toString(value) + suit;
}
}
