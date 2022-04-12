package main.java.FrameComponents.TextFields;

import javax.swing.JTextField;
import main.java.Settings;

public class AlgorithmSelectText extends JTextField {
	
	public AlgorithmSelectText() {
		super("Algorithm: ");
		
		this.setBounds(Settings.algoSelectTextX, Settings.menuBarComponentsY,Settings.algoSelectTextWidth,Settings.menuBarComponentsHeigth);	
		this.setEditable(false);
		this.setFont(Settings.standartFont);
		this.setForeground(Settings.standartTextColor);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBorder(null);
	}
}
