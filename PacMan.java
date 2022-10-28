import java.awt.event.KeyEvent;

public class PacMan {
	
	private double x, y, radius;
	private final double STEP = .02; 
	
	/**
	 * Initializes instance variables
	 */
	public PacMan() {
		this.x = .5;
		this.y = .1;
		this.radius = .02;
	} 
	
	
	public void draw() {
		StdDraw.setPenColor(250, 250, 50);
		StdDraw.filledCircle(this.x, this.y, this.radius);
	}
	
	/**
	 * Checks if pacman collides with ghosts
	 * 
	 * @param takes an a ghost
	 * @return return a boolean
	 */
	public boolean checkGhostCollision(Ghost ghost) {
    	// Calculate edges of the ghost
       double right = this.x + this.radius;
       double left = this.x - this.radius;
       double top = this.y + this.radius;
       double bottom = this.y - this.radius;
       
       // Check for collision from all sides of the ghost
    	   if (right < ghost.left()) {
        	   return false;
           }
           
           if (left > ghost.right()) {
        	   return false;
           }
           
           if (top < ghost.bottom()) {
        	   return false;
           }
           
           if (bottom > ghost.top()) {
        	   return false;
           }
           return true; 
       }
       
 
	/**
	 * Checks if pacman collides with walls
	 * 
	 * @param takes an array of walls
	 * @return return a boolean
	 */
	public boolean checkWallCollision(Wall wall) {
    	// Calculate edges of this square
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
       double bottom = this.y - this.radius;
        
    // Check for collision on all sides
       if (right < wall.left()) {
    	   return false;
       }
       
       if (left > wall.right()) {
    	   return false;
       }
       
       if (top < wall.bottom()) {
    	   return false;
       }
       
       if (bottom > wall.top()) {
    	   return false;
       }
       return true;
       
	}
	
	/**
	 * Checks if pacman eats pellets
	 * 
	 * @param takes a pellet
	 * @return return a boolean
	 */
	public boolean checkPelletCollision(Pellet pellet) {
    	// Calculate edges of this square
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
       // Check for collision on all sides
       if (right < pellet.left()) {
    	   return false;
       }
       
       if (left > pellet.right()) {
    	   return false;
       }
       
       if (top < pellet.bottom()) {
    	   return false;
       }
       
       if (bottom > pellet.top()) {
    	   return false;
       }
       
        return true;
	}
        
	
	 /**
     * Update -- move the PACMAN
     *
     * Check for left, right, down, and up arrow presses StdDraw.isKeyPressed
     * @param Array of walls
     * 
     */
    public void update(Wall wall[]) {
    	
    	double old_x = this.x;
    	double old_y = this.y;
    	
    	if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && (this.x - this.radius > 0.0)){
    		this.x -= STEP;    
    	}
   
    	if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && (this.x + this.radius < 1.0)) {
        	this.x += STEP; 
       }
       
    	if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && (this.y - this.radius > 0.0) ) {
    		this.y -= STEP;
    	}
    	
    	if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && (this.y + this.radius < 1.0) ) {
    		this.y += STEP;
    	}
    	
    	// Check for wall collision
    	for (int i = 0; i < wall.length; i ++ ) {
    		if (checkWallCollision(wall[i]) == true) {
                this.x = old_x;
                this.y = old_y;
        	}
        }
    	
    	
    }
}

