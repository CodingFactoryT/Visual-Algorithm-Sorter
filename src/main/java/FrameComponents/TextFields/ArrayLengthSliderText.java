package main.java.FrameComponents.TextFields;

import javax.swing.JTextField;
import main.java.Settings;

public class ArrayLengthSliderText extends JTextField {
	
	public ArrayLengthSliderText() {
		super("Array Length: ");
		
		this.setBounds(Settings.arrayLengthSliderTextX, Settings.menuBarComponentsY,Settings.arrayLengthSliderTextWidth,Settings.menuBarComponentsHeigth);
		this.setEditable(false);
		this.setFont(Settings.standartFont);
		this.setForeground(Settings.standartTextColor);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBorder(null);
	}
}
