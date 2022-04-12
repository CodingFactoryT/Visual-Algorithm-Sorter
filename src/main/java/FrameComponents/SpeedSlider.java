package main.java.FrameComponents;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.java.Settings;
import main.java.FrameComponents.TextFields.SpeedSliderText;

public class SpeedSlider extends JSlider implements ChangeListener {
	
	public SpeedSlider() {
		super(Settings.minSpeed,Settings.maxSpeed,(Settings.minSpeed + Settings.maxSpeed) / 2);
		
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBounds(Settings.speedSliderX, Settings.menuBarComponentsY,Settings.speedSliderWidth,Settings.menuBarComponentsHeigth);
		this.addChangeListener(this);
	
		this.add(new SpeedSliderText());
	}
		
	public int getSortingSpeed() {
		return this.getValue();
	}

	@Override
	public void stateChanged(ChangeEvent e) {	
		Settings.sortingDelay = Settings.maxSpeed - this.getValue() + 1;
	}
}
