
public class Pellet {
	
	private double x, y, radius;
	
	
	/** initializes instance varibales
	 * 
	 * @param newX
	 * @param newY
	 */
	public Pellet(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		this.radius = .0075;
	}
	
	/**
	 * Draws Pellets
	 */
	public void draw() {
		StdDraw.setPenColor(250, 250, 250);
		StdDraw.filledCircle(this.x, this.y, this.radius);
		
		
	}
	/**
     * Add new methods to calculate and return the right, left, top, and bottom 
     * of this Brick
     */
    public double right() {
        return this.x + this.radius;
    }
    
    public double left() {
        return this.x - this.radius;
    }
	
    public double top() {
        return this.y + this.radius;
    }
    
    public double bottom() {
        return this.y - this.radius;
    }
	
}
