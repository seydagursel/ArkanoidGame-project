package project212deneme;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract  class Bricks extends SubstanceOfGame{
	

	
    private boolean destroyed;
	private int strenght;
	private int NumberOfbrick;

    public Bricks(int level) {

         destroyed = false;
         setStrenght(level);
        

    }

    boolean isDestroyed() {
        
        return destroyed;
    }

    void setDestroyed(boolean val) {
        
        destroyed = val;
    }
	public int getStrenght() {
		return strenght;
	}
	public void setStrenght(int level) {
		if (level==1) {
			this.strenght = 1;
		}
		if (level==2) {
			this.strenght = 2;
		}
		if (level==3) {
			this.strenght = 3;
		}
		
	}

	public int getNumberOfbrick() {
		return NumberOfbrick;
	}

	public void setNumberOfbrick(int numberOfbrick) {
		NumberOfbrick = 27;
	}


}
