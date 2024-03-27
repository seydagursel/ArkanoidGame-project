package project212deneme;

import javax.swing.ImageIcon;

public abstract class Ball extends SubstanceOfGame{
	
    private int xdir;
    private int ydir;
    private int speed;


    public Ball(int level) {
    	
    	
        xdir = 1;
        ydir = -1;

        resetState();
        setSpeed(level);
        
    }


    @Override
    public void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {

            setXDir(1);
        }

        if (x == 450 - 20) {

            setXDir(-1);
        }

        if (y == 0) {

            setYDir(1);
        }
    }

    private void resetState() {

        x = 450;
        y = 700;
    }

    void setXDir(int x) {

        xdir = x;
    }

    void setYDir(int y) {

        ydir = y;
    }

    int getYDir() {

        return ydir;
    }

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int level) {
		if(level==1)
			this.speed = 3;	
		if(level==2)
			this.speed = 6;
		if(level==3)
			this.speed = 9;
		
	}
}


