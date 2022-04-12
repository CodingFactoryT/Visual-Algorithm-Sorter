package main.java.FrameComponents;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main.java.MainFrame;
import main.java.Settings;
import main.java.FrameComponents.TextFields.ArrayLengthSliderText;

public class ArrayLengthSlider extends JSlider implements ChangeListener {
	
	public ArrayLengthSlider() {
		super(Settings.minArrayValue, Settings.maxArrayValue, ViewPort.bars.length);
		
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBounds(Settings.arrayLengthSliderX, Settings.menuBarComponentsY,Settings.arrayLengthSliderWidth,Settings.menuBarComponentsHeigth);
		this.addChangeListener(this);
		
		this.add(new ArrayLengthSliderText());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		MainFrame.viewPort.displayNewArray();
	}
}
