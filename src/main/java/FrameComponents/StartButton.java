package main.java.FrameComponents;

import javax.swing.JButton;
import main.java.Settings;
import main.java.SortingAlgorithm;
import main.java.SortingOrder;
import main.java.Algorithms.BubbleSort;
import main.java.Algorithms.HeapSort;
import main.java.Algorithms.InsertionSort;
import main.java.Algorithms.MergeSort;
import main.java.Algorithms.QuickSort;
import main.java.Algorithms.SelectionSort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
	
	public StartButton() {
		super(Settings.startButtonImage);
		
		this.setBounds(Settings.startButtonX, Settings.menuBarComponentsY,Settings.startButtonWidth,Settings.menuBarComponentsHeigth);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBorderPainted(false);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		SortingAlgorithm alg = null;
		
		switch(MenuBar.algorithmSelectComboBox.getSelectedAlgorithm()) {
			case "BubbleSort": alg = new BubbleSort(ViewPort.bars); break;
			case "HeapSort": alg = new HeapSort(ViewPort.bars); break;
			case "InsertionSort": alg = new InsertionSort(ViewPort.bars); break;
			case "MergeSort": alg = new MergeSort(ViewPort.bars); break;
			case "QuickSort": alg = new QuickSort(ViewPort.bars); break;
			case "SelectionSort": alg = new SelectionSort(ViewPort.bars); break;
		}
				
		if(SortingOrderRadioButtons.LtoH.isSelected()) 
			alg.sort(SortingOrder.LtoH);			
		else 
			alg.sort(SortingOrder.HtoL);
				
	}
}
