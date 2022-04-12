package main.java.FrameComponents;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import main.java.Bar;
import main.java.MainFrame;
import main.java.Settings;

public class ViewPort extends JPanel {
	public static Bar[] bars = initBarArray(Settings.arrayStartValue);

	public ViewPort() {	
		this.setBounds(Settings.allBarsPanelX,Settings.allBarsPanelY,Settings.allBarsPanelWidth,Settings.allBarsPanelHeigth);
		this.setBackground(Settings.standartBackgroundColor);
		drawBars(bars);
	}
	
	public void drawBars(Bar[] bars) {
		this.setLayout(new GridLayout(1,bars.length));
		
		for(int i = 0; i<bars.length; i++) {
			JLayeredPane barPane = new JLayeredPane();
			barPane.setLayout(null);
			
			barPane.add(ViewPort.bars[i].panel);
			this.add(barPane);
			
		}
	}
	
	public static Bar[] initBarArray(int arLength) {
		Random random = new Random();
		Bar[] newBarArray = new Bar[arLength];
		
		for(int i = 0; i<arLength; i++) {
			int heigth = random.nextInt(Settings.maxHeigth) + Settings.minHeigth;
			JPanel panel = new JPanel();	
			panel.setBounds(0,Settings.allBarsPanelHeigth-heigth,1000,heigth);
			panel.setBackground(Color.blue);
			panel.setOpaque(true);
			
			Bar bar = new Bar(panel,heigth);			
			newBarArray[i] = bar;
		}
		
		return newBarArray;
	}
	
	public void displayNewArray() {
		MainFrame.viewPort.removeAll();
		bars = initBarArray(MenuBar.arrayLengthSlider.getValue());
		MainFrame.viewPort.drawBars(bars);
		MainFrame.viewPort.invalidate();
		MainFrame.viewPort.validate();
		MainFrame.viewPort.repaint();
	}
}
