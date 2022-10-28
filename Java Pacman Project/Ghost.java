
public class Ghost {
	
	private double x, y, radius, dx;
	//private double x1, y1, radius1, dx1;
	
	/**
	 * Initializes instance variables
	 * @param newX
	 * @param newY
	 */
	public Ghost(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		this.radius = .02;
		this.dx = .015;
	}
	
	
	/**
     * Update -- position of ghosts
     *
     */
    public void update() {
    	this.x += this.dx;
    	
    	if (this.x + this.radius >= 1.0 || this.x - this.radius <= 0.0 ) {
            this.dx = -this.dx;
        }
    }
   
    
    /**
     * Add new methods to calculate and return the right, left, top, and bottom 
     * of this Ghosts
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
    	
    

	/**
	 * Draws ghosts
	 */
	public void draw() {
		StdDraw.setPenColor(200, 25, 25);
		StdDraw.filledSquare(this.x, this.y, this.radius);
	}
	
	

}