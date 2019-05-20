package xD;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Gui extends JFrame{

	private JButton btn1;
	private JLabel showFile;	//Zeigt am ende den Pfad an -> braucht get methode für Controller
	
	public Gui() {
		btn1 = new JButton("Klick mich!");	//Initialisierung im Konstruktor!
		showFile = new JLabel("");
		
		createGui();		//Gui erstellen also Layout / listener etc.
		setVisible(true);//Gui anzeigen
	}

	private void createGui() {
		setTitle("JFileChooser");
		setBounds(200, 200, 400, 100);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(btn1);
		btn1.addActionListener(new Controller(this));	//btn1 einem Listener hinzufügen... 
														//unser Listener ist Controller
														//der will Gui haben also this(wir geben uns selber mit weil wir das Object sind)
		add(showFile);
		showFile.setVisible(false);//Blendet Text aus	
	}

	public JLabel getShowFile() {
		return showFile;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	//Ändert design
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Gui();
	}

}
