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
public class Paint implements Observer{

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
	private CounterShape cpt = new CounterShape();

	
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
		
		
		counterLabel = new JLabel("Compteur de shape = 0 | Compteur group = 0", JLabel.CENTER);
		counterLabelCircle = new JLabel("Circle", JLabel.LEFT);
		counterLabelRectangle = new JLabel("Rectangle", JLabel.RIGHT);
		counterFldCircle = new JTextField("0");
		counterFldCircle.setPreferredSize(new Dimension(100, 20));
		counterFldRectangle = new JTextField("0");
		counterFldRectangle.setPreferredSize(new Dimension(100, 20));
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
		clearButton.addActionListener(new ClearButtonListener(drawing, cpt));
		circleButton.addActionListener(new CircleButtonListener(drawing, cpt));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing, cpt));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(640, 480);
		cpt.addObserver(this);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}


	@Override
	public void update(int value, int value2, int total) {
		counterFldCircle.setText(Integer.toString(value));
		counterFldRectangle.setText(Integer.toString(value2)); 
		counterLabel.setText("Compteur de shape = "+ total + " | Compteur group = 0");
	}

}
