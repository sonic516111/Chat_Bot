package bot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import bot.controller.ChatBotController;
import bot.model.Bot;

/**
 * 
 * @author Grayson Slaughter
 *@version 1.1 10/23/13 Added setupPanel, setupLayout helper methods
 */
public class BotPanel extends JPanel
{
	private ChatBotController baseController;
	private Bot appBot;
	private SpringLayout baseLayout;
	private SpringLayout baseLayout_1;
	private JButton submitChatButton;
	private JTextField userTextField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private int clickCount;
	
	public BotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getAppBot();
		
		userTextField = new JTextField(30);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		chatPane = new JScrollPane(chatArea);
		baseLayout_1 = new SpringLayout();
		
		clickCount = 0;
		
		setupPanel();
		setupLayout();
		
		setupChat();
		setupListeners();
	}
	
	private void setupChat()
	{
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout_1);
		this.setBackground(Color.BLUE);
		
		this.add(userTextField);
		submitChatButton = new JButton("Click here to chat!");

		this.add(submitChatButton);
		this.add(chatPane);
		
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		
		
	}
	
	private void setupListeners()
	{
		submitChatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();

				
				if(clickCount % 7 == 0)
				{
					
					String currentPhrase = baseController.dominateTheConversation();
					if(currentPhrase.length() != 0)
					{
						chatArea.append(currentPhrase);
						clickCount--;
					}

				}
				else if( clickCount % 5 == 0)
				{
					chatArea.append(baseController.memeValidation(userInput));
				}
				else
				{
					
					chatArea.append("\n" + userInput);
					String processedInput = baseController.processUserInput(userInput);
					chatArea.append(processedInput);
					userTextField.setText("Type to the chatbot here :D");
					chatArea.append("\n" + appBot.getRandomTopic());
					
					//This should be a method in the controller that would be returned as a string to place in the chatArea.
					String me, you, other;
					me = "Grayson";
					you = "Eric";
					other = "Slaughter";
					chatArea.append(appBot.putNameInAlphabeticOrder(me, you, other));
				}

				
			}
		});
	}
	
	private void setupLayout()
	{
		baseLayout_1.putConstraint(SpringLayout.SOUTH, submitChatButton, -57, SpringLayout.SOUTH, this);
		baseLayout_1.putConstraint(SpringLayout.NORTH, userTextField, 17, SpringLayout.SOUTH, submitChatButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, submitChatButton, 165, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatPane, 17, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatPane, 102, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, userTextField, 102, SpringLayout.WEST, this);
	}
}
