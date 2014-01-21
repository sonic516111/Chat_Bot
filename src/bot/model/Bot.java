package bot.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bot.model.Bot;
/**
 * Holds memes and videogames.
 * @author gsla6260
 *@version 1.3 10/13/13
 */
public class Bot
{
	private ArrayList<String> myMemes;
	private ArrayList<String> myVideogames;
	private ArrayList<String> myRandomList;
	private ArrayList<String> conversationList;
	/**
	 * Runs the program.
	 */
	public Bot()
	{
		myMemes = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		myVideogames = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		fillTheRandomList();
		// fillTheMemeList();
		// fillTheVideogameList();
//		conversationPiece();
	}
	
	private void fillTheRandomList()
	{
		myRandomList.add("penguins");
		myRandomList.add("I have to say something random?");
		myRandomList.add("you don't want that?");
		myRandomList.add("cat");
	}
	/**
	 * Method to retrieve a random value from the myRandomList.
	 * @return The String value randomly selected from the list.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";
		
		double myRandomNumber = Math.random();
		int myRandomListPosition = (int) (myRandomNumber * myRandomList.size());
		randomTopic = myRandomList.get(myRandomListPosition);
		
		return randomTopic;
	}
	
	
	/**
	 * holds memes.
	 */
	private void fillTheMemeList()
	{
		myMemes.add("my jammies are rustled");
		myMemes.add("cats");
		myMemes.add("What does the fox say");
		myMemes.add("philosoraptor");
		myMemes.add("iamdissappoint");
	}
	/**
	 * Checks for memes.
	 * @param currentPhrase
	 * @return
	 */
	public boolean memeChecker(String currentPhrase)
	{
		boolean isMeme = false;
		if (currentPhrase != null)
		{
			for (String currentMeme : myMemes)
			{
				if (currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}
			}
		}

		return isMeme;
	}
	
	
	public String usesContent(String current)
	{
		String processedString = "";
		if(current.contains("boo"))
		{
			processedString = "wooo scary";
		}
		else
		{
			processedString = "booooooring";
		}
		return processedString;
	}
	
	
	public String putNameInAlphabeticOrder(String first, String middle, String last)
	{
		String sortedName = "";
		
		if(first.compareTo(middle) < 0)
		{
			if(first.compareTo(last) < 0)
			{
				if(middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + "," + last;
				}
				else
				{
					sortedName = first + ", " + last + ", " + middle;
				}
			}
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if(middle.compareTo(last) < 0)
			{
				if(last.compareTo(first) < 0)
				{
					sortedName = middle + ", " + last + ", " + first;
				}
				else
				{
					sortedName = middle + ", " + first + ", " + last;
				}
			}
			else
			{
				sortedName = last + ", " + middle + ", " + first;
			}
		}
		
		return sortedName;
	}
	/**
	 * Holds videogames.
	 */
	private void fillTheVideogameList()
	{
		myVideogames.add("pokemon");
		myVideogames.add("zelda");
		myVideogames.add("legend of zelda");
		myVideogames.add("mario");
		myVideogames.add("call of duty");
		myVideogames.add("final fantasy");
		myVideogames.add("kingdom hearts");
		myVideogames.add("war craft");
		myVideogames.add("pokemon snap");
		myVideogames.add("paper mario");
		myVideogames.add("nintendogs");
	}
	/**
	 * Checks for videogames
	 * @param currentPhrase
	 * @return
	 */
	public boolean videogameChecker(String currentPhrase)
	{
		boolean isGame = false;

		if (currentPhrase != null)
		{
			for (String currentGame : myVideogames)
			{
				if (currentPhrase.equalsIgnoreCase(currentGame))
				{
					isGame = true;
				}
			}
		}
		return isGame;
	}
	
	private void fillTheConversationList()
	{
		ArrayList<String> conversationList = new ArrayList<String>();
		String pokemon = "";
		conversationList.add("What pokemon do you like?");
		conversationList.add(pokemon + " is a very cool pokemon. Who is your favorite trainer?");
		conversationList.add(pokemon + " is a very awesome trainer.");
	}
	/**
	 * Small conversation about pokemon.
	 */
	public ArrayList<String> conversationPiece()
	{

		
		return conversationList;
	}
}
