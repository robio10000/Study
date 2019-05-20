package xD;

import java.awt.event.*;
import javax.swing.*;

public class Controller implements ActionListener{

	private Gui window;//Hier soll später Gui rein
	private JLabel showFile;
	
	private JFileChooser choose;
	private String selection;
	
	public Controller(Gui tmp) {
		window = tmp;	//Gui in window rein tun. siehe oben
		showFile = window.getShowFile();//Wir holen uns aus der Gui das Label
		
		choose = new JFileChooser();
		selection = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Klick mich!")){	//Achte darauf, dass das der selbe String wie im Button ist
			
			int returnVal = choose.showOpenDialog(window);//der u. parameter soll sagen wo der chooser sich beim öffnen orientirert wegen der Position
			if(returnVal == JFileChooser.APPROVE_OPTION){	//wenn datei gewählt wurde
				selection = choose.getSelectedFile().getAbsolutePath();
				showFile.setText("Datei: " + selection);//setzt den Text vom Label
				showFile.setVisible(true);//Zeigt Label wieder an
			}else
				JOptionPane.showMessageDialog(window, "Abbruch wurde bestätigt!", "Abbruch", JOptionPane.CANCEL_OPTION);
				//	wo soll es sich mittig öffnen,	Nachicht vom Fenster,		selbsterklärend, dieses logo links vom Text
			
		}	
	}

}
