package drawing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextButtonListener implements ActionListener {
	
	Drawing drawing;
	JFrame frame;
	JPanel panel;
	private JPanel buttonPanel;
	private JTextField textField;
	private JPanel textPanel;
	private JButton textButton;
	private JButton cancelButton;
	
	public TextButtonListener(Drawing drawing){
		this.drawing = drawing;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(drawing.lengthList()!=0){
			frame = new JFrame();
			frame.setTitle("Texte à inscrire sur les formes");
			frame.setSize(400, 100);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			textButton = new JButton("Text !");
			cancelButton = new JButton("Annuler");
			textField = new JTextField();
			 
			buttonPanel = new JPanel();
			buttonPanel.add(textButton);
			buttonPanel.add(cancelButton);
			
			textButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 drawing.textShape(textField.getText());
		        	 frame.dispose();
		         }
			});
			
			cancelButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 frame.dispose();
		         }
			});
			
			textPanel = new JPanel();
			textPanel.setLayout(new BorderLayout());
			textPanel.add(textField,BorderLayout.CENTER);
			
			panel.add(buttonPanel, BorderLayout.SOUTH);
			panel.add(textPanel, BorderLayout.CENTER);
			
			frame.setContentPane(panel);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}