package project212deneme;



abstract class SubstanceOfGame implements CommonForSubstance {
	protected int x;
	protected int y;

	
	protected void setX(int x) {
		this.x = x;
	}
	
	int getX() {
		return x;
	}
	
	protected void setY(int y) {
		this.y = y;
	}
	
	int getY() {
		return y;
	}
	
}