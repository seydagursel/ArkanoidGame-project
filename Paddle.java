package project212deneme;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Paddle extends SubstanceOfGame{
	
    private int Xdirection;
    private Icon actor;
    private JLabel paddleLabel;
	
	public Paddle() {
		
		resetState();
		
	}

	public void createGUI() throws IOException{
		

	  actor=new ImageIcon(getClass().getResource("paddle.jpg"));
	  paddleLabel = new JLabel(actor);  
	  paddleLabel.setBounds(Xdirection, 600, 70,10);   
	  
	}
	public void move() {
		x += Xdirection;
		
		if (x <= 0) {
			x = 0;
			
		}
		
	    if (x >= 450 - 70) {
		    x = 450 - 70;
		    
		
	    }
        paddleLabel.setBounds(Xdirection, 600, 70,10);
		
	}
	
	void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			Xdirection = -1;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			Xdirection = 1;
		}
		
		
	}
	
	
	void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			Xdirection = 0;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			Xdirection = 0;
		}
		
	
		
	}
	void mouseClicked( MouseEvent event) {
		if(event.getButton()==MouseEvent.BUTTON1) {
			Xdirection = -1;
			
		}
		else if(event.getButton()==MouseEvent.BUTTON2) {
			Xdirection=0;
		}
		else if(event.getButton()==MouseEvent.BUTTON3) {
			
			Xdirection=1;
		}
		
	}
	
	
	private void resetState() {
		
		x = 0;
		y = 600;
	}
	JLabel paddleGet() {
		
		return paddleLabel;
		
	}

}
