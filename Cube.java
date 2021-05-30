package quaternions;

import java.awt.Graphics;

/**
 * Cube
 * 
 * @author Bjoern Luig
 * @version 3.11.2016
 */
public class Cube{
	
	private Point[] point;
	
	/**
 	 * Constructor for Objects of the class Cube
 	 * 
 	 * @param x x-Position
 	 * @param y y-Position
 	 * @param z z-Position
 	 */
	public Cube(double x, double y, double z) {
		point = new Point[9];
		
		point[0] = new Point(x, y, z);
		
		point[1] = new Point(x + 100, y + 100, z + 100); //right, up, vorne
		point[2] = new Point(x - 100, y + 100, z + 100); //left, up, vorne
		point[3] = new Point(x + 100, y - 100, z + 100); //right, down, vorne
		point[4] = new Point(x - 100, y - 100, z + 100); //left, down, vorne
		point[5] = new Point(x + 100, y + 100, z - 100); //right, up, hinten
		point[6] = new Point(x - 100, y + 100, z - 100); //left, up, hinten
		point[7] = new Point(x + 100, y - 100, z - 100); //right, down, hinten
		point[8] = new Point(x - 100, y - 100, z - 100); //left, down, hinten

	}
	
	public void show( Graphics g) {
		for(int i = 1; i <= 8; i++) {
			point[i].show(g);
		}
		g.drawLine((int) point[1].x() + 350, (int) point[1].y() * -1 + 350, (int) point[2].x() + 350, (int) point[2].y() * -1 + 350);
		g.drawLine((int) point[1].x() + 350, (int) point[1].y() * -1 + 350, (int) point[5].x() + 350, (int) point[5].y() * -1 + 350);
		g.drawLine((int) point[1].x() + 350, (int) point[1].y() * -1 + 350, (int) point[3].x() + 350, (int) point[3].y() * -1 + 350);

		g.drawLine((int) point[4].x() + 350, (int) point[4].y() * -1 + 350, (int) point[2].x() + 350, (int) point[2].y() * -1 + 350);
		g.drawLine((int) point[4].x() + 350, (int) point[4].y() * -1 + 350, (int) point[8].x() + 350, (int) point[8].y() * -1 + 350);
		g.drawLine((int) point[4].x() + 350, (int) point[4].y() * -1 + 350, (int) point[3].x() + 350, (int) point[3].y() * -1 + 350);

		g.drawLine((int) point[6].x() + 350, (int) point[6].y() * -1 + 350, (int) point[2].x() + 350, (int) point[2].y() * -1 + 350);
		g.drawLine((int) point[6].x() + 350, (int) point[6].y() * -1 + 350, (int) point[8].x() + 350, (int) point[8].y() * -1 + 350);
		g.drawLine((int) point[6].x() + 350, (int) point[6].y() * -1 + 350, (int) point[5].x() + 350, (int) point[5].y() * -1 + 350);

		g.drawLine((int) point[7].x() + 350, (int) point[7].y() * -1 + 350, (int) point[3].x() + 350, (int) point[3].y() * -1 + 350);
		g.drawLine((int) point[7].x() + 350, (int) point[7].y() * -1 + 350, (int) point[5].x() + 350, (int) point[5].y() * -1 + 350);
		g.drawLine((int) point[7].x() + 350, (int) point[7].y() * -1 + 350, (int) point[8].x() + 350, (int) point[8].y() * -1 + 350);

	}
	
    /**
     * Move
     * 
     * @param x Moving in x-Direction
     * @param y Moving in y-Direction
     * @param z Moving in z-Direction
     */
	public void move(double x, double y, double z) {
		for(int i = 0; i <= 8; i++) {
			point[i].move(x, y, z);
		}
	}
    /**
     * Rotation
     * 
     * @param x x-Value of the Vector of the Rotation axis
     * @param y y-Value of the Vector of the Rotation axis
     * @param z z-Value of the Vector of the Rotation axis
     * @param alpha angle of Rotation
     */	
	public void rotate(double x, double y, double z, double alpha) {
		for(int i = 0; i <= 8; i++) {
			point[i].rotate(x, y, z, alpha);
		}
	}
}