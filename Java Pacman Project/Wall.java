
public class Wall {
	
	private double x, y, halfWidth, halfHeight;

	/**
	 * Initializes instance variables
	 * 
	 * @param newX
	 * @param newY
	 * @param newWidth
	 * @param newHeight
	 */
	public Wall(double newX, double newY, double newWidth, double newHeight) {
		this.x = newX;
		this.y = newY;
		this.halfWidth = newWidth;
		this.halfHeight = newHeight;
	}
	
	/**
	 * Draws walls
	 */
	public void draw() {
		StdDraw.setPenColor(20, 100, 225);
		StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
	}
	
	/**
     * Add methods to calculate and return the right, left, top, and bottom sides
     * of the walls
     */
    public double right() {
        return this.x + this.halfWidth;
    }
    
    public double left() {
        return this.x - this.halfWidth;
    }
	
    public double top() {
        return this.y + this.halfHeight;
    }
    
    public double bottom() {
        return this.y - this.halfHeight;
    }

}