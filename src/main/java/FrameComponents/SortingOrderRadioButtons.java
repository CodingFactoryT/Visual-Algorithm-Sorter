package main.java.FrameComponents;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import main.java.Settings;

public class SortingOrderRadioButtons extends JPanel {
	public static JRadioButton LtoH = new JRadioButton("LtoH");
	public static JRadioButton HtoL = new JRadioButton("HtoL");
	
	public SortingOrderRadioButtons() {
		this.setBounds(Settings.sortingOrderRadioButtonsPanelX, Settings.menuBarComponentsY, Settings.sortingOrderRadioButtonsPanelWidth, Settings.menuBarComponentsHeigth);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setLayout(new FlowLayout());
		
		LtoH.setFont(Settings.standartFont);
		LtoH.setForeground(Settings.standartTextColor);
		LtoH.setBackground(this.getBackground());
		LtoH.setFocusPainted(false);
		LtoH.setSelected(true);	
		
		HtoL.setFont(Settings.standartFont);
		HtoL.setForeground(Settings.standartTextColor);
		HtoL.setFocusPainted(false);
		HtoL.setBackground(this.getBackground());
		
		ButtonGroup sortingOrderRadioGroup = new ButtonGroup();
		sortingOrderRadioGroup.add(LtoH);
		sortingOrderRadioGroup.add(HtoL);

		this.add(LtoH);
		this.add(HtoL);
	}
}
