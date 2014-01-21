package bot.view;

import javax.swing.JFrame;

import bot.controller.ChatBotController;

public class BotFrame extends JFrame
{
	private ChatBotController baseController;
	private BotPanel basePanel;
	
	public BotFrame(ChatBotController baseController)
	{
		this.baseController = baseController;
		basePanel = new BotPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}
