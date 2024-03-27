package project212deneme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayGame extends JPanel{
	
	
	private JLabel scoreInfo,levelInfo,livesInfo;
	protected Image backgroundImage;
	private ImageIcon gameBackground;
	private int level;
	private Ball ball;
	private Paddle paddle;
	private boolean outSide=true;
	private Timer timer;
	private int lives=3;
	private int score;
	static int width=35;
	static int height=15;
	
	

	public PlayGame(String fileName,int level) throws IOException {
		
		 this.level=level;
		 System.out.print("Start with level: "+level);
		
		
		 this.scoreInfo=new JLabel("Score:"+1);
		 scoreInfo.setForeground(Color.WHITE);
		 add(scoreInfo,BorderLayout.WEST);
		 this.levelInfo=new JLabel("Level:"+getLevel());
		 levelInfo.setForeground(Color.WHITE);
		 //levelInfo.setBounds(0, 100,20, 20);
		 add(levelInfo,BorderLayout.CENTER);
		 
		 this.livesInfo=new JLabel("Lives:"+getLives());
		 livesInfo.setForeground(Color.WHITE);
		 //livesInfo.setLocation(400,720);
		 add(livesInfo,BorderLayout.EAST);
		 


		
	     gameBackground=new ImageIcon(getClass().getResource(fileName));
			
		 backgroundImage =gameBackground.getImage(); 
		 
		 
		 
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		if(level==1) {
			int y=0;
			for(int j=7;j>0;j--){
				g.setColor(Color.magenta);
				g.fillRect(50+y,30, width, height);
				y+=50;
			}
			int t=0;
			for(int i=7;i>0;i--) {
				g.setColor(Color.magenta);
				g.fillRect(50+t,60,width, height);
				t+=50;
			}
			int x=0;
			for(int k=7;k>0;k--) {
				g.setColor(Color.magenta);
				g.fillRect(50+x, 90, width, height);
				x+=50;	
			}

		}

		else if(level==2) {
			int y=0;
			for(int j=7;j>0;j--){
				g.setColor(Color.magenta);
				g.fillRect(50+y,30, width, height);
				y+=50;
			}
			int t=0;
			for(int i=7;i>0;i--) {
				g.setColor(Color.PINK);
				g.fillRect(50+t,60,width, height);
				t+=50;
			}
			int x=0;
			for(int k=7;k>0;k--) {
				g.setColor(Color.magenta);
				g.fillRect(50+x, 90, width, height);
				x+=50;	
			}
			
		}
		else if(level==3) {
			int y=0;
			for(int j=7;j>0;j--){
				g.setColor(Color.cyan);
				g.fillRect(50+y,30, width, height);
				y+=50;
			}
			int t=0;
			for(int i=7;i>0;i--) {
				g.setColor(Color.PINK);
				g.fillRect(50+t,60,width, height);
				t+=50;
			}
			int x=0;
			for(int k=7;k>0;k--) {
				g.setColor(Color.magenta);
				g.fillRect(50+x, 90, width, height);
				x+=50;	
			}
			
				
		}
       
		g.setColor(Color.CYAN);
		g.fillRect(250,600,70, 10);

		g.setColor(Color.GRAY);
		g.fillOval(250, 550, 20, 20);
		

	}

	public void createGame() {
		
		try {
			paddle.createGUI();
		} catch (IOException e) {

			e.printStackTrace();
		}
	    

		
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		if(outSide)
		     lives--;
	    this.lives = lives;
	}
	public int getScore() {
		
		return score;
	}

	public void setScore(int score) {

		this.score = score;
	}
	public void breaking() {
		
	}
	public void nextLevel() {
		
		setLevel(level++);
		if(level==2)
		   ball.setSpeed(6);
		if(level==3)
			ball.setSpeed(8);
		levelInfo.setText("Level: " + level);
	}

}
