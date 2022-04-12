package main.java;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Settings {

	public static final int screenWidth = 1920;
	public static final int screenHeigth = 1080;
	
	public static final int minArrayValue = 5;
	public static final int maxArrayValue = 495;
	public static final int arrayStartValue = (minArrayValue+maxArrayValue) /2;
	
	public static final int menubarHeigth = 100;
	
	public static final int minSpeed = 1;
	public static final int maxSpeed = 400;
	
	public static int sortingDelay = (minSpeed + maxSpeed) / 2;
	
	public static final int minHeigth = 5;
	public static final int maxHeigth = 795;
	
	public static final int allBarsPanelX = 100;
	public static final int allBarsPanelY = screenHeigth - 900;
	public static final int allBarsPanelHeigth = 800;
	public static final int allBarsPanelWidth = screenWidth - 200;
	
	public static final int menuBarComponentsY = menubarHeigth / 4;
	public static final int menuBarComponentsHeigth = menubarHeigth / 2;
	
	public static final int algoSelectX = 1500;
	public static final int algoSelectWidth = 170;
	public static final int algoSelectTextX = 1400;
	public static final int algoSelectTextWidth = 100;
	
	public static final int newArrayButtonX = 50;
	public static final int newArrayButtonWidth = 130;
	
	public static final int startButtonX = 200;
	public static final int startButtonWidth = 50;
	
	public static final int sortingOrderRadioButtonsPanelX = 270;
	public static final int sortingOrderRadioButtonsPanelWidth = 200;
	
	public static final int speedSliderX = 1000;
	public static final int speedSliderWidth = 150;
	public static final int speedSliderTextX = 850;
	public static final int speedSliderTextWidth = 150;
	
	public static final int arrayLengthSliderX = 650;
	public static final int arrayLengthSliderWidth = 150;
	public static final int arrayLengthSliderTextX = 500;
	public static final int arrayLengthSliderTextWidth = 150;
	
	public static final Color standartBackgroundColor = new Color(0xCCCCCC);	//light grey-ish
	public static final Color menubarBackgroundColor = new Color(0x0061FF);		//light blue-ish
	public static final Color standartTextColor = Color.white;
	public static final Font standartFont = new Font("Arial",Font.BOLD, 18);
	
	public static ImageIcon newArrayButtonImage;
	public static ImageIcon startButtonImage;
	
	public Settings() {
		InputStream newArrayButtonStream = new BufferedInputStream(getClass().getResourceAsStream("/main/resources/newArrayButtonIcon.png"));
		InputStream startButtonStream = new BufferedInputStream(getClass().getResourceAsStream("/main/resources/startButtonIcon.png"));
		
		try {
			newArrayButtonImage = new ImageIcon(ImageIO.read(newArrayButtonStream));
			startButtonImage = new ImageIcon(ImageIO.read(startButtonStream));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
