// The main method for the Pac-Man project
// CMS 170, Spring 2019

public class Game {
	
	public static void main(String[] args) {
		
		// Initialize objects
		PacMan pacman = new PacMan();
		Ghost[] blinky = new Ghost[4];
		
		blinky[0] = new Ghost(.90, .90);
		blinky[1] = new Ghost(.20, .20);
		blinky[2] = new Ghost(.7, .5);
		blinky[3] = new Ghost(.3, .65);
		
		Wall[] walls = new Wall[13];
		walls[0] = new Wall(.2, .4, .1, .02);
		walls[1] = new Wall(.2, .6, .1, .02);
		walls[2] = new Wall(.8, .4, .1, .02);
		walls[3] = new Wall(.8, .6, .1, .02);
		walls[4] = new Wall(.15, .15, .02, .10);
		walls[5] = new Wall(.1, .5, .02, .10);
		walls[6] = new Wall(.9, .5, .02, .10);
		walls[7] = new Wall(.5, .5, .02, .10);
		walls[8] = new Wall(.5, .75, .2, .02);
		walls[9] = new Wall(.5, .25, .2, .02);
		walls[10] = new Wall(.85, .15, .02, .10);
		walls[11] = new Wall(.85, .85, .02, .10);
		walls[12] = new Wall(.15, .85, .02, .10);
		
		Pellet[] pellets = new Pellet[21];
		pellets[0] = new Pellet(.95, .2);
		pellets[1] = new Pellet(.95, .4);
		pellets[2] = new Pellet(.95, .6);
		pellets[3] = new Pellet(.95, .8);
		pellets[4] = new Pellet(.95, .95);
		pellets[5] = new Pellet(.05, .2);
		pellets[6] = new Pellet(.05, .4);
		pellets[7] = new Pellet(.05, .6);
		pellets[8] = new Pellet(.05, .8);
		pellets[9] = new Pellet(.05, .95);
		pellets[10] = new Pellet(.4, .2);
		pellets[11] = new Pellet(.4, .4);
		pellets[12] = new Pellet(.4, .7);
		pellets[13] = new Pellet(.4, .9);
		pellets[14] = new Pellet(.6, .2);
		pellets[15] = new Pellet(.6, .4);
		pellets[16] = new Pellet(.6, .7);
		pellets[17] = new Pellet(.6, .9);
		pellets[18] = new Pellet(.05, .8);
		pellets[19] = new Pellet(.05, .05);
		pellets[20] = new Pellet(.95, .05);
		
		// Keep track of number of pellets
		int numPellets = pellets.length;
		
		boolean playing = true;
		while (playing) {
			
			//*** Check for collisions ***//
			
			// Check if pacman collides with ghosts
			if (pacman.checkGhostCollision(blinky[0]) == true) {
				System.out.println("You Lose!!");
				break;
			}
			
			if (pacman.checkGhostCollision(blinky[1]) == true) {
				System.out.println("You Lose!!");
				break;
			}
			
			if (pacman.checkGhostCollision(blinky[2]) == true) {
				System.out.println("You Lose!!");
				break;
			}
			
			if (pacman.checkGhostCollision(blinky[3]) == true) {
				System.out.println("You Lose!!");
				break;
			}
			
			
			// Check for collision with Pellets
			for (int i = 0; i < pellets.length; i ++ ) {
                if (pellets[i] == null) {
                    continue;
                }

                if (pacman.checkPelletCollision(pellets[i]) == true) {
                    pellets[i]= null;
                    numPellets --;
                }

            }
			
			
			//*** Update positions ***//
			pacman.update(walls);
			
			for (int i = 0; i < blinky.length; i ++ ) {
				blinky[i].update();
            }
			//*** Animate all elements ***//
			
			StdDraw.clear();
			
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledRectangle(.5, .5, .5, .5);
			
			pacman.draw();
			
			// Draws all the ghosts
			
			for (int i = 0; i < blinky.length; i ++ ) {
				blinky[i].draw();
            }
			
			// Draws all the pellets
			for (Pellet p : pellets) {
				if (p != null) {
					p.draw();
				}
			}
			
			// Draws all the walls
			for (Wall w : walls) {
				w.draw();
			}
			
			StdDraw.show(20);
			
			// Winning condition
			if(numPellets == 0) {
			System.out.println("You Win!!!!!!!");
				break;
			}
		}
		
	}

}