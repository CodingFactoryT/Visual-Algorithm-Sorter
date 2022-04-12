package main.java;

import javax.swing.JFrame;
import main.java.FrameComponents.MenuBar;
import main.java.FrameComponents.ViewPort;

public class MainFrame extends JFrame {
	public static ViewPort viewPort = new ViewPort();
	
	MainFrame(){
		this.setTitle("Visual Sorting Algorithms");
		this.setLayout(null);
		this.setSize(Settings.screenWidth - 100, Settings.screenHeigth - 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Settings.standartBackgroundColor);	
		this.setLocationRelativeTo(null);
		
		this.add(new MenuBar());
		this.add(viewPort);
		
		this.setVisible(true);		
	}
}