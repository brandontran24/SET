// Brandon Tran
// Spring Quarter 2018
// ECE 150 - Mobile Embedded Systems

// The following code is a Java implementation of the card game SET! that can be run in terminal
// Its structure and logic primarily used for an Android implementation of SET! for ECE 150
// Rules of SET! and more info on this project can be found at
// https://sites.google.com/view/setproject

// TO RUN on terminal:
// > javac SinglePlayer.java
// > java SinglePlayer

import java.util.*;

class Card
{
	// Card variables
    private String texture;
    private String color;
    private String shape;
    private String count;

	// Getter methods
    public String getTexture() {return texture;}
    public String getColor() {return color;}
    public String getShape() {return shape;}
    public String getCount() {return count;}

	// Constructor
    public Card(String texture, String color, String shape, String count) 
    {
        this.texture = texture;
        this.color = color;
        this.shape = shape;
        this.count = count;
    }
}

class Deck
{
	// Deck has-an array of Cards
	private Card[] deck;
	
	// Getter method
	public Card[] getDeck() {return deck;}
	
	// Generates deck of 81 cards
	public void populate(Card[] deck)
	{
		// Arrays for traits
		String[] textureArray = {"clear", "striped", "solid"};
		String[] colorArray = {"red", "blue", "purple"};
		String[] shapeArray = {"squiggly", "oval", "diamond"};
		String[] countArray = {"one", "two", "three"};
		
		// Populate card array
		int index = 0;
		int i, j, k, m;
		for(i = 0; i < 3; i++)
		{
			for(j = 0; j < 3; j++)
			{
				for(k = 0; k < 3; k++)
				{
					for(m = 0; m < 3; m++)
					{
						deck[index] = new Card(textureArray[i], colorArray[j], shapeArray[k], countArray[m]);
						index++;
					}
				}
			}
		}
    }
    
    // Shuffles deck
	public void shuffle(Card[] deck) 
	{
		// Swaps every card with a random card in the deck
        Random rand = new Random();
        for (int i = 80; i > 0; i--) 
        {
            int j = rand.nextInt(80);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
	}

	// Prints deck
	public void print()
	{
		for(int i = 0; i < 81; i++)
		{
			System.out.println(this.deck[i].getCount() + " " + 
								this.deck[i].getTexture() + " " + 
								this.deck[i].getColor() + " " + 
								this.deck[i].getShape());
		}
	}
	
	// Constructor creates deck, populates, and shuffles
	public Deck() 
    {
        this.deck = new Card[81];
        populate(this.deck);
		shuffle(this.deck);
    }
	
}

public class SinglePlayer
{	
	// Checks the logic (a == b == c) and (a != b != c != a)
	static boolean validateHelper(String a, String b, String c)
	{
		boolean res = false;
		
		if(a.equals(b) && b.equals(c))
		{
			res = true;
		}
		
		if(!(a.equals(b)) && !(b.equals(c)) && !(a.equals(c)))
		{
			res = true;
		}
		
		return res;
	}

	// A valid SET! is three cards where, for each trait, all three cards
	// share the same trait or are all exclusively different	
	static boolean validateSet(Card a, Card b, Card c)
	{
		String x;
		String y;
		String z;
		
		// Texture Check
		x = a.getTexture();
		y = b.getTexture();
		z = c.getTexture();
		boolean textureCheck = validateHelper(x, y, z);
		
		// Color Check
		x = a.getColor();
		y = b.getColor();
		z = c.getColor();
		boolean colorCheck = validateHelper(x, y, z);
		
		// Shape Check
		x = a.getShape();
		y = b.getShape();
		z = c.getShape();
		boolean shapeCheck = validateHelper(x, y, z);
		
		// Count Check
		x = a.getCount();
		y = b.getCount();
		z = c.getCount();
		boolean countCheck = validateHelper(x, y, z);
		
		return (textureCheck && colorCheck && shapeCheck && countCheck);
	}
		
	static boolean isSet(Deck deck, int a, int b, int c)
	{
		return validateSet(deck.getDeck()[a], 
							deck.getDeck()[b], 
							deck.getDeck()[c]);
	}

	public static void main(String args[])
	{
		Deck deck = new Deck();
		
		Scanner scanner = new Scanner(System.in);
		int mode = 9;
		while(mode != 0)
		{
			System.out.println("Enter 1 to validate a set");
			System.out.println("Enter 2 to print the deck");
			System.out.println("Enter 3 to reshuffle the deck");
			System.out.println("Enter 0 to quit");
			
			mode = scanner.nextInt();
			switch(mode)
			{
				case 1:
					System.out.println("Enter three numbers 0-80 (the index of the cards)");
					int a;
					int count = 0;
					int[] guess = {0, 0, 0};
					while(count < 3)
					{
						guess[count] = scanner.nextInt();
						count++;
					}
					boolean setCheck = isSet(deck, guess[0], guess[1], guess[2]);
					if(setCheck)
					{
						System.out.println("Valid SET! \n");
					}
					else
					{
						System.out.println("Invalid SET! \n");
					}
					break;
					
				case 2:
					deck.print();
					System.out.print("\n");
					break;
				
				case 3:
					deck.shuffle(deck.getDeck());
					System.out.print("\n");					
					break;
					
				default:
					break;
			}
		}
	}
}