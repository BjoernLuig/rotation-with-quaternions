package quaternions;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Point
 * 
 * @author Bjoern Luig
 * @version 3.11.2016
 */
public class Point{
	
    private Quaternion quaternion;
	
	/**
	 * Constructor for Objects of the class Point 
	 * 
	 * @param x x-Position
	 * @param y y-Position
	 * @param z z-Position
	 */
    public Point(double x, double y, double z){
        quaternion = new Quaternion(0, x, y, z);
    }
    
    public double x(){
        return quaternion.b();
    }
    
    public double y(){
        return quaternion.c();
    }
    
    public double z(){
        return quaternion.d();
    }
    
    public void show(Graphics g) {
    	int xPosition = (int) (x() * 1.0) + 350;
    	int yPosition = (int) (y() * -1.0) + 350;
    	g.setColor(Color.GREEN);
    	g.fillOval(xPosition - 3, yPosition - 3, 6, 6);
    }

    /**
     * Move
     * 
     * @param x Moving in x-Direction
     * @param y Moving in y-Direction
     * @param z Moving in z-Direction
     */
    public void move(double x, double y, double z){
        quaternion = quaternion.sum(quaternion, new Quaternion(0, x, y, z));
    }

    /**
     * Rotation
     * 
     * @param x x-Value of the Vector of the Rotation axis
     * @param y y-Value of the Vector of the Rotation axis
     * @param z z-Value of the Vector of the Rotation axis
     * @param alpha angle of Rotation
     */
    public void rotate(double x, double y, double z, double alpha){
    	double n = Math.sqrt(x * x + y * y + z * z);
    	x = x / n;
    	y = y / n;
    	z = z / n;
    	alpha = Math.toRadians(alpha);
        Quaternion q = new Quaternion(Math.cos(alpha / 2), Math.sin(alpha / 2) * x, Math.sin(alpha / 2) * y, Math.sin(alpha / 2) * z);
        
        quaternion = quaternion.product(q, quaternion);
        quaternion = quaternion.product(quaternion, quaternion.conjugate(q));
    }
}