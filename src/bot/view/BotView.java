package bot.view;

import javax.swing.JOptionPane;

import bot.model.Bot;
/**
 * GUI View for the Chatbot project
 * @author gsla6260
 *@version 1.3 10/13/13
 */
public class BotView
{
	/**
	 * Chatbot used for internal chat methods.
	 */
	private Bot myBot;

	public BotView()
	{
		myBot = new Bot();
	}
	/**
	 *?
	 */
	public void showApp()
	{
		String input = "keep going";

		while (input == null || !input.equals("no"))
		{
			JOptionPane.showMessageDialog(null, myBot.getRandomTopic());
			input = getInput();
			useInput(input);
		}
		
		myBot.conversationPiece();
	}
	/**
	 * Puts in an input message and returns it.
	 * @return
	 */
	private String getInput()
	{
		String input = "";

		input = JOptionPane.showInputDialog("What do you want to talk about?");

		return input;
	}
	/**
	 * Says whether it is a meme, videogame or something else.
	 * @param userInput
	 */
	private void useInput(String userInput)
	{
		if(myBot.memeChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "I knew that " + userInput + " is a meme!!!");
		}
		JOptionPane.showMessageDialog(null, "Wow that is so interesting that you want to talk with me about " + userInput);
		
		if(myBot.videogameChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "I have played " + userInput);
		}
	}
}
