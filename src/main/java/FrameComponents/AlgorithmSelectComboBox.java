package main.java.FrameComponents;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import main.java.Settings;
import java.awt.event.ActionListener;

public class AlgorithmSelectComboBox extends JComboBox implements ActionListener {	
	public AlgorithmSelectComboBox() {
		super(new String[]{"BubbleSort", "HeapSort", "InsertionSort", "MergeSort", "QuickSort", "SelectionSort"});
		
		this.setBounds(Settings.algoSelectX,Settings.menuBarComponentsY, Settings.algoSelectWidth, Settings.menuBarComponentsHeigth);
		this.setForeground(Settings.standartTextColor);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setFont(Settings.standartFont);
		this.addActionListener(this);	
	}
	
	public String getSelectedAlgorithm() {
		return this.getSelectedItem().toString();
	}

}
