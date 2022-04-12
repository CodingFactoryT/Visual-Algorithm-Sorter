package main.java.FrameComponents.TextFields;

import javax.swing.JTextField;
import main.java.Settings;

public class SpeedSliderText extends JTextField {
	
	public SpeedSliderText() {
		super("Sorting Speed: ");
		
		this.setBounds(Settings.speedSliderTextX, Settings.menuBarComponentsY,Settings.speedSliderTextWidth,Settings.menuBarComponentsHeigth);
		this.setEditable(false);
		this.setFont(Settings.standartFont);
		this.setForeground(Settings.standartTextColor);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBorder(null);
	}

}
