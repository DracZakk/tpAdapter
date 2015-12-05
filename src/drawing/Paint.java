package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint implements Observer{

	private JFrame frame;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JButton duplicateButton;
	private JButton textButton;
	private JPanel buttonPanel;
	
	private JMenuBar menuBar = new JMenuBar();
	
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
		frame = new JFrame("Paint by TRABELSI Nadir - Master ISIDIS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		mainPanel = new JPanel(new BorderLayout());
		statusPanel = new JPanel(new BorderLayout());
		statusText = new JPanel(new BorderLayout());
		
		
		JMenu fichier = new JMenu("Fichier");
		JMenuItem close = new JMenuItem("Fermer");
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {   	
			    int option = JOptionPane.showConfirmDialog(null, 
			        "Etes-vous sûr de vouloir quitter ?", 
			        "Quitter l'application Paint", 
			        JOptionPane.YES_NO_OPTION, 
			        JOptionPane.QUESTION_MESSAGE);

			    if(option == JOptionPane.OK_OPTION){
			    	System.exit(0);
			    }
				
		    }        
		});
		JMenu options = new JMenu("Options");
		JMenuItem clear = new JMenuItem("Clear");
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				drawing.clear();
			}
		});
		JMenuItem duplicate = new JMenuItem("Duplicate");
		duplicate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				drawing.duplication();
			}
		});
		JMenuItem undo = new JMenuItem("Undo");
		JMenuItem redo = new JMenuItem("Redo");
		JMenuItem text = new JMenuItem("Text");
		text.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				drawing.textShape("Cliquer sur text pour changer le message");
			}
		});
		
		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		duplicateButton = new JButton("Duplicate");
		textButton = new JButton("Text");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(duplicateButton);
		buttonPanel.add(textButton);
		
		
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
		
		fichier.add(close);
		options.add(clear);
		options.add(duplicate);
		options.add(undo);
		options.add(redo);
		options.add(text);
		fichier.setMnemonic('f');
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		options.setMnemonic('o');
		clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		duplicate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
		text.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));
		menuBar.add(fichier);
		menuBar.add(options);
		
		mainPanel.add(menuBar, BorderLayout.NORTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		mainPanel.add(statusPanel, BorderLayout.SOUTH);
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing, cpt));
		circleButton.addActionListener(new CircleButtonListener(drawing, cpt));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing, cpt));
		duplicateButton.addActionListener(new DuplicateButtonListener(drawing, cpt));
		textButton.addActionListener(new TextButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing, cpt);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(1024, 768);
		frame.setLocationRelativeTo(null);
		cpt.addObserver(this);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}


	@Override
	public void update(int value, int value2, int total, int listGroup) {
		counterFldCircle.setText(Integer.toString(value));
		counterFldRectangle.setText(Integer.toString(value2)); 
		counterLabel.setText("Compteur de shape = "+ total + " | Compteur group = "+ listGroup);
	}

}
