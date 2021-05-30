package quaternions;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * Window
 * 
 * @author Bjoern Luig
 * @version 3.11.2016
 */
public class Window {

	private JFrame frmTest;
	private JTextField textFieldXValue;
	private JTextField textFieldYValue;
	private JTextField textFieldZValue;
	private JTextField textFieldAlpha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.setTitle("Quaternions");
		frmTest.setBounds(100, 100, 845, 757);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest.getContentPane().setLayout(null);
		
		textFieldXValue = new JTextField();
		textFieldXValue.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldXValue.setText("");
		textFieldXValue.setBounds(60, 10, 50, 20);
		frmTest.getContentPane().add(textFieldXValue);
		textFieldXValue.setColumns(10);
		
		textFieldYValue = new JTextField();
		textFieldYValue.setText("");
		textFieldYValue.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldYValue.setBounds(60, 40, 50, 20);
		frmTest.getContentPane().add(textFieldYValue);
		textFieldYValue.setColumns(10);
		
		textFieldZValue = new JTextField();
		textFieldZValue.setText("");
		textFieldZValue.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldZValue.setBounds(60, 70, 50, 20);
		frmTest.getContentPane().add(textFieldZValue);
		textFieldZValue.setColumns(10);
		
		textFieldAlpha = new JTextField();
		textFieldAlpha.setText("");
		textFieldAlpha.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAlpha.setBounds(60, 100, 50, 20);
		frmTest.getContentPane().add(textFieldAlpha);
		textFieldAlpha.setColumns(10);
		
		Picture canvas = new Picture();
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(120, 10, 700, 700);
		frmTest.getContentPane().add(canvas);
		
		JButton btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double x = Double.parseDouble(textFieldXValue.getText());
				double y = Double.parseDouble(textFieldYValue.getText());
				double z = Double.parseDouble(textFieldZValue.getText());
				canvas.move(x, y, z);
				canvas.repaint();
			}
		});
		btnMove.setBackground(Color.LIGHT_GRAY);
		btnMove.setBounds(10, 130, 100, 30);
		frmTest.getContentPane().add(btnMove);
		
		JButton btnRotate = new JButton("Rotate");
		btnRotate.setBackground(Color.LIGHT_GRAY);
		btnRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Double.parseDouble(textFieldXValue.getText());
				double y = Double.parseDouble(textFieldYValue.getText());
				double z = Double.parseDouble(textFieldZValue.getText());
				double alpha = Double.parseDouble(textFieldAlpha.getText());
				canvas.rotate(x, y, z, alpha);
				canvas.repaint();
			}
		});
		btnRotate.setBounds(10, 170, 100, 30);
		frmTest.getContentPane().add(btnRotate);
		
		JButton btnCreatePoint = new JButton("create Point");
		btnCreatePoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double x = Double.parseDouble(textFieldXValue.getText());
				double y = Double.parseDouble(textFieldYValue.getText());
				double z = Double.parseDouble(textFieldZValue.getText());
				canvas.setPoint(new Point(x, y, z));
				canvas.repaint();
			}
		});
		btnCreatePoint.setBackground(Color.LIGHT_GRAY);
		btnCreatePoint.setBounds(10, 210, 100, 30);
		frmTest.getContentPane().add(btnCreatePoint);
		
		JButton btnCreateCube = new JButton("create Cube");
		btnCreateCube.setBackground(Color.LIGHT_GRAY);
		btnCreateCube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Double.parseDouble(textFieldXValue.getText());
				double y = Double.parseDouble(textFieldYValue.getText());
				double z = Double.parseDouble(textFieldZValue.getText());
				canvas.setCube(new Cube(x, y, z));
				canvas.repaint();
			}
		});
		btnCreateCube.setBounds(10, 250, 100, 30);
		frmTest.getContentPane().add(btnCreateCube);
		
		JLabel lblXvalue = new JLabel("xValue");
		lblXvalue.setBounds(10, 10, 40, 20);
		frmTest.getContentPane().add(lblXvalue);
		
		JLabel lblYvalue = new JLabel("yValue");
		lblYvalue.setBounds(10, 40, 40, 20);
		frmTest.getContentPane().add(lblYvalue);
		
		JLabel lblZvalue = new JLabel("zValue");
		lblZvalue.setBounds(10, 70, 40, 20);
		frmTest.getContentPane().add(lblZvalue);
		
		JLabel lblAlpha = new JLabel("Alpha");
		lblAlpha.setBounds(10, 100, 40, 20);
		frmTest.getContentPane().add(lblAlpha);
		
		JButton btnRemoveContent = new JButton("remove Content");
		btnRemoveContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.removeContent();
				canvas.repaint();
			}
		});
		btnRemoveContent.setBackground(Color.LIGHT_GRAY);
		btnRemoveContent.setBounds(10, 290, 100, 30);
		frmTest.getContentPane().add(btnRemoveContent);
	}
}