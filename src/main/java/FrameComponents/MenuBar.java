package main.java.FrameComponents;

import javax.swing.JPanel;
import main.java.Settings;
import main.java.FrameComponents.TextFields.AlgorithmSelectText;
import main.java.FrameComponents.TextFields.ArrayLengthSliderText;
import main.java.FrameComponents.TextFields.SpeedSliderText;

public class MenuBar extends JPanel {
	public static ArrayLengthSlider arrayLengthSlider = new ArrayLengthSlider();
	public static AlgorithmSelectComboBox algorithmSelectComboBox = new AlgorithmSelectComboBox();
	
	public MenuBar() {
		this.setLayout(null);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBounds(0,0,Settings.screenWidth, Settings.menubarHeigth);	

		this.add(new NewArrayButton());
		this.add(new StartButton());		
		this.add(new SortingOrderRadioButtons());
		this.add(new SpeedSlider());
		this.add(arrayLengthSlider);	
		this.add(algorithmSelectComboBox);
		this.add(new AlgorithmSelectText());
		this.add(new ArrayLengthSliderText());
		this.add(new SpeedSliderText());
	}

}
