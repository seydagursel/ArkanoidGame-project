package project212deneme;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.desktop.AboutEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class GameMain extends JPanel{
	
	static JRadioButton[] levelsOptions=new JRadioButton[3];
	static int[] level=new int[3];
	protected Image backgroundImage;
	private ImageIcon gameBackground;
	
	public GameMain(String fileName) throws IOException {
		
		
	     gameBackground=new ImageIcon(getClass().getResource(fileName));
			
		 backgroundImage =gameBackground.getImage(); 
   }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		    // Draw the background image.
		g.drawImage(backgroundImage, 0, 0, null);
	}
	
	public static void main(String[] args) throws IOException {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("OptionList");
	    JPanel panel=new GameMain("background.jpg");
		
		
	    
	    
	    
	    ActionListener actionListener = new ActionListener() {
	      public void actionPerformed(ActionEvent actionEvent) {
            String command= actionEvent.getActionCommand();
            
	        if(command.equals("New Game")) {
	        	
                int i=0;
	        	
		        for(;i<3;i++) {
		        	if(level[i]==1) {
		        		
		        		try {
		        			
		        			JFrame myGame=new JFrame("Game");
							JPanel gamePanel=new PlayGame("background.jpg",++i);
							
						    myGame.add(gamePanel);
						    myGame.pack();
						    myGame.setSize(450,700);
							myGame.setVisible(true);
						    myGame.setLocation(200,100);
						    myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
						} catch (IOException e) {
							
							e.printStackTrace();
						} 
		        	
		        	}
		        
	        	}
	        }else if(command.equals("Options")) {
	        	
	        	JFrame options= new JFrame("CHOOSE level");
	        	JPanel optionPanel = new JPanel( new GridBagLayout());
	        	GridBagConstraints constraints = new GridBagConstraints();
	        	optionPanel.setBackground(Color.CYAN); 
                

	            ActionListener radiobutton = new ActionListener() {
	                public void actionPerformed(ActionEvent actionEvent) {
	                	JRadioButton button = (JRadioButton) actionEvent.getSource();
	                	
	                	
	                	if(button== (JRadioButton)Array.get(levelsOptions, 0)) {
	                		level[0]=1;
	                		options.dispose();
	                	}
	                	else if(button== (JRadioButton)Array.get(levelsOptions, 1)) {
	                		level[1]=1;
	                		options.dispose();
	                	}
	                	else if(button== (JRadioButton)Array.get(levelsOptions, 2)) {
	                		level[2]=1;
	                		options.dispose();
	                	}
	                  
	                }
	              };
	              
	             
	        	int y=0;
	        	for(int i=1;i<4;i++) {
	        		constraints.gridy=y;
	        		JRadioButton level=new JRadioButton("Start With Level\t"+ i);
	        		level.setBackground(Color.CYAN);
	        		level.addActionListener(radiobutton);
	        		level.setForeground(Color.darkGray);
	        		level.setFont(new Font("Arial", Font.ITALIC, 15));
	        		optionPanel.add(level,constraints);
	        		levelsOptions[y]=level;
	        		y++;
	        	}
	        	options.add(optionPanel);
	        	options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	            options.setLocationByPlatform(true);
	            options.setVisible(true); 
	            options.pack();
	            options.setSize(300,200);
	            
                
	        	
	        }else if(command.equals("Scores")) {
	        	
	        }else if(command.equals("Help")) {
	        	
	        	JFrame help = new JFrame("Most frequently asked questions");
	        	String[] options = {
	        	 "Can i choose level ?",
	        	 "How do i move the paddle ?",
	        	 "How can I get out of the game?",
	        	 "None of these"};
                final String[] helpInfo= {"To play the game, you need to click the option button and choose the level that best suits you.",
	        			"Use the right and left keys to move or you can move with the mouse the paddle while playing the game.",
	        			"You can exit the game by using the exit option or with the Ctrl+Q keys.",
	        			"You can contact us at this e-mail address for your problem.\r\n"
	        			+ "help@arkanoidGame.com"
	        	};
	        	
                JList helpOption= new JList(options);
	        	helpOption.setBounds(100,100, 75,75); 
	        	helpOption.setSelectionBackground(Color.MAGENTA);
	            helpOption.setVisibleRowCount(4);
	            helpOption.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
	            
	            help.add(new JScrollPane(helpOption));
	            help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	            help.setLocationByPlatform(true);
	            help.setVisible(true); 
	            help.pack();
	            help.setSize(300,130);
	            
	            
	            helpOption.addListSelectionListener(
	            		new ListSelectionListener() {
	            			public void valueChanged( ListSelectionEvent e) {
	            				
	            				    int i=helpOption.getSelectedIndex();
	            					JOptionPane.showMessageDialog(help,helpInfo[i]);  
	            			
	            			}

	            		}
	            	
	            );
	            
	        	

	        	
	        	
	        }else if(command.equals("About")) {
	        	
	        	JOptionPane.showMessageDialog(frame,"Application  Devoloper:\nÞeyda Gürsel\n20180702115\nseydagursel@hotmail.com");
	        	
	        	
	        }else if(command.equals("Exit")) {
	        	frame.dispose();
	        }
	      }
	    };
	    
	    
	    for(OptionLIst opt : OptionLIst.values()) {
		    JButton button = new JButton(opt.getStr());
		    
		    button.setPreferredSize(new Dimension(250,100));
		    button.setForeground(Color.WHITE);
		    button.setFont(new Font("Arial", Font.ITALIC, 20));
		    button.setOpaque(false);
		    button.setContentAreaFilled(false); 
		    button.setActionCommand(opt.getStr());
		    button.addActionListener(actionListener);
		    panel.add(button);
		   
	    }
	    frame.add(panel);
	    frame.pack();
	    frame.setSize(450,700);
		frame.setVisible(true);
	    frame.setLocation(200,100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}

}