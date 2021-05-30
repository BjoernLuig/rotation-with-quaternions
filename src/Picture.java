package quaternions;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Picture
 * 
 * @author Bjoern Luig
 * @version 3.11.2016
 */
public class Picture extends Canvas {
	
	private static final long serialVersionUID = 760394220697809047L;
	
	public Point point;
	public Cube cube;
	
	/**
	 * Constructor for Objects of the class Picture
	 */
	public Picture() {
		super();
	}
	
	public void setPoint(Point pPoint) {
		point = pPoint;
		cube = null;
	}
	
	public void setCube(Cube pCube) {
		point = null;
		cube = pCube;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		if(point != null) {
			point.show(g);
		}
		else if(cube != null) {
			cube.show(g);
		}
	}
	
    /**
     * Move
     * 
     * @param x Moving in x-Direction
     * @param y Moving in y-Direction
     * @param z Moving in z-Direction
     */
	public void move(double x, double y, double z) {
		if(point != null) {
			point.move(x, y, z);
		}
		else if(cube != null) {
			cube.move(x, y, z);
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
		if(point != null) {
			point.rotate(x, y, z, alpha);
		}
		else if(cube != null) {
			cube.rotate(x, y, z, alpha);
		}
	}
	/**
	 * Removing of the Content
	 */
	public void removeContent() {
		point = null;
		cube = null;
	}
}