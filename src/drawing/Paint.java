package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint {

	private JFrame frame;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JPanel buttonPanel;
	
	private JPanel mainPanel;
	private JPanel statusPanel;
	private JPanel statusText;
	
	private JLabel counterLabel;
	private JLabel counterLabelCircle;
	private JLabel counterLabelRectangle;
	private JTextField counterFldCircle;
	private JTextField counterFldRectangle;
	private Drawing drawing;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		statusPanel = new JPanel(new BorderLayout());
		statusText = new JPanel(new BorderLayout());
		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		
		int total = 0;
		counterLabel = new JLabel("Compteur de shape = "+total, JLabel.CENTER);
		counterLabelCircle = new JLabel("Circle", JLabel.LEFT);
		counterLabelRectangle = new JLabel("Rectangle", JLabel.RIGHT);
		counterFldCircle = new JTextField();
		counterFldCircle.setPreferredSize(new Dimension(200, 20));
		counterFldRectangle = new JTextField();
		counterFldRectangle.setPreferredSize(new Dimension(200, 20));
		statusPanel.add(buttonPanel, BorderLayout.NORTH);
		statusText.add(counterFldCircle, BorderLayout.WEST);
		statusText.add(counterFldRectangle, BorderLayout.EAST);
		statusPanel.add(counterLabel, BorderLayout.CENTER);
		statusPanel.add(counterLabelCircle, BorderLayout.WEST);
		statusPanel.add(counterLabelRectangle, BorderLayout.EAST);
		statusPanel.add(statusText, BorderLayout.SOUTH);
		
		
		
		
		mainPanel.add(drawing, BorderLayout.CENTER);
		mainPanel.add(statusPanel, BorderLayout.SOUTH);
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(960, 680);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}
}
