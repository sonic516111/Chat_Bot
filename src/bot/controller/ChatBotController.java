package bot.controller;

import java.util.ArrayList;

import bot.model.Bot;
import bot.view.BotFrame;
import bot.view.BotView;

public class ChatBotController
{
//	private BotView appView;
	private BotFrame appFrame;
	private Bot appBot;
	/**
	 * makes a new Bot View.
	 */
	public ChatBotController()
	{
//		appView = new BotView();
		appBot = new Bot();
	}
	
	public Bot getAppBot()
	{
		return appBot;
	}

	/**
	 * Starts the app.
	 */
	public void start()
	{
//		appView.showApp();
		appFrame = new BotFrame(this);
	}
	
	public String memeValidation(String currentInput)
	{
		String memeReaction = "Why aren't you talking about the memes?";
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput + " is the coolest meme huh?";
		}
		
		return memeReaction;
	}
	
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() > 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	
	public String dominateTheConversation()
	{
		String currentConversationPiece = "";
		
		currentConversationPiece = conversationHelper(appBot.conversationPiece());
		
		return currentConversationPiece;
	}
	
	
	
	public String processUserInput(String currentInput)
	{
		String response = "";
		
		if(appBot.memeChecker(currentInput))
		{
			response = "memes!!!!";
		}
		else if (true )
		{
			
		}
		
		
		return response;
	}
}
