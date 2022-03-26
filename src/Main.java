import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.FlowLayout;

import java.util.Random;


public class Main {
	
	public static Bar[] bars = initBarArray(Settings.arrayStartValue);
	public static int arraySliderValue = Settings.arrayStartValue;
	
	public static void main(String[] args){		
		
		@SuppressWarnings("unused")
		MyFrame frame = new MyFrame();
		
	}
	
	public static Bar[] initBarArray(int arLength) {
		Random random = new Random();
		Bar[] currentBars = new Bar[arLength];
		
		for(int i = 0; i<arLength; i++) {
			int heigth = random.nextInt(Settings.maxHeigth) + Settings.minHeigth;
			JPanel panel = new JPanel();	
			panel.setBounds(0,Settings.allBarsPanelHeigth-heigth,1000,heigth);
			panel.setBackground(Color.blue);
			panel.setOpaque(true);
			
			Bar bar = new Bar(panel,heigth);			
			currentBars[i] = bar;
		}
		return currentBars;
	}
	
} 

class MyFrame extends JFrame implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	JComboBox algoSelect;
	JPanel menubar = new JPanel();
	JButton newArrayButton = null;
	JButton startButton = null;
	JRadioButton LtoH = new JRadioButton("LtoH");
	JRadioButton HtoL = new JRadioButton("HtoL");
	JPanel sortingOrderRadioButtons = new JPanel();
	static JSlider speedSlider = new JSlider(Settings.minSpeed,Settings.maxSpeed,(Settings.minSpeed + Settings.maxSpeed) / 2);
	JSlider arrayLengthSlider = new JSlider(Settings.minArrayValue, Settings.maxArrayValue, Main.bars.length);
	JPanel allBarsPanel = new JPanel();
	Font standartFont = new Font("Arial",Font.BOLD, 18);
	Color standartColor = new Color(0xCCCCCC);	//light grey-ish
	
	MyFrame(){
		InputStream newArrayButtonStream = new BufferedInputStream(getClass().getResourceAsStream("/resources/newArrayButtonIcon.png"));
		InputStream startButtonStream = new BufferedInputStream(getClass().getResourceAsStream("/resources/startButtonIcon.png"));
		
		try {
		ImageIcon newArrayButtonImage = new ImageIcon(ImageIO.read(newArrayButtonStream));
		ImageIcon startButtonImage = new ImageIcon(ImageIO.read(startButtonStream));
		
		newArrayButton = new JButton("New Array", newArrayButtonImage);
		startButton = new JButton(startButtonImage);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		initFrame();
			
		initMenuBar();
		this.add(menubar);
		
		initNewArrayButton();
		menubar.add(newArrayButton);
		
		initStartButton();
		menubar.add(startButton);	
		
		initSortingOrderRadioButtons();
		menubar.add(sortingOrderRadioButtons);
		
		initSpeedSlider();
		menubar.add(speedSlider);
		
		initArrayLengthSlider();
		menubar.add(arrayLengthSlider);
		
		algoSelect = initAlgoSelect();
		menubar.add(algoSelect);
		algoSelect.addActionListener(this);	
		
		
		allBarsPanel.setBounds(Settings.allBarsPanelX,Settings.allBarsPanelY,Settings.allBarsPanelWidth,Settings.allBarsPanelHeigth);
		allBarsPanel.setBackground(standartColor);
		drawBars(Main.bars);
		this.add(allBarsPanel);
		
		this.setVisible(true);
	}
	
	
	private void initFrame() {
		this.setTitle("Visual Sorting Algorithms");
		this.setLayout(null);
		this.setSize(Settings.screenWidth - 100, Settings.screenHeigth - 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(standartColor);	
		this.setLocationRelativeTo(null);
	}
	
	private void initMenuBar() {
		menubar.setLayout(null);
		menubar.setBackground(new Color(0x0061FF));	//light blue-ish
		menubar.setBounds(0,0,Settings.screenWidth, Settings.menubarHeigth);	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox initAlgoSelect() {
		String[] algoSelections = {"BubbleSort", "HeapSort", "InsertionSort", "MergeSort", "QuickSort", "SelectionSort"};
		algoSelect = new JComboBox(algoSelections);
		algoSelect.setBounds(Settings.algoSelectX,Settings.menuBarComponentsY, Settings.algoSelectWidth, Settings.menuBarComponentsHeigth);
		algoSelect.setBackground(menubar.getBackground());
		algoSelect.setForeground(Color.white);
		algoSelect.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		algoSelect.setFont(standartFont);
		JTextField algoSelectText = new JTextField("Algorithm: ");
		algoSelectText.setEditable(false);
		algoSelectText.setFont(standartFont);
		algoSelectText.setForeground(Color.white);
		algoSelectText.setBackground(menubar.getBackground());
		algoSelectText.setBorder(null);
		algoSelectText.setBounds(Settings.algoSelectTextX, Settings.menuBarComponentsY,Settings.algoSelectTextWidth,Settings.menuBarComponentsHeigth);	
		menubar.add(algoSelectText);
		return algoSelect;
	}
	
	private void initNewArrayButton() {
		newArrayButton.setBackground(menubar.getBackground());
		newArrayButton.setBorderPainted(false);
		newArrayButton.setHorizontalTextPosition(SwingConstants.CENTER);
		newArrayButton.setForeground(Color.white);
		newArrayButton.setFont(standartFont);
		newArrayButton.addActionListener(this);
		newArrayButton.setBounds(Settings.newArrayButtonX, Settings.menuBarComponentsY,Settings.newArrayButtonWidth,Settings.menuBarComponentsHeigth);
	}
	
	private void initStartButton() {
		startButton.setBackground(menubar.getBackground());
		startButton.setBorderPainted(false);
		startButton.addActionListener(this);
		startButton.setBounds(Settings.startButtonX, Settings.menuBarComponentsY,Settings.startButtonWidth,Settings.menuBarComponentsHeigth);
	}
	
	private void initSortingOrderRadioButtons() {
		sortingOrderRadioButtons.setBackground(menubar.getBackground());
		sortingOrderRadioButtons.setLayout(new FlowLayout());
		sortingOrderRadioButtons.setBounds(Settings.sortingOrderRadioButtonsPanelX, Settings.menuBarComponentsY, Settings.sortingOrderRadioButtonsPanelWidth, Settings.menuBarComponentsHeigth);
		
		LtoH.setFont(standartFont);
		LtoH.setForeground(Color.white);
		LtoH.setBackground(menubar.getBackground());
		LtoH.setSelected(true);	
		
		HtoL.setFont(standartFont);
		HtoL.setForeground(Color.white);
		HtoL.setBackground(menubar.getBackground());
		
		ButtonGroup sortingOrderRadiosGroup = new ButtonGroup();
		sortingOrderRadiosGroup.add(LtoH);
		sortingOrderRadiosGroup.add(HtoL);
		
		sortingOrderRadioButtons.add(LtoH);
		sortingOrderRadioButtons.add(HtoL);
	}
	
	private void initSpeedSlider() {
		speedSlider.setBackground(menubar.getBackground());
		speedSlider.setBounds(Settings.speedSliderX, Settings.menuBarComponentsY,Settings.speedSliderWidth,Settings.menuBarComponentsHeigth);
		speedSlider.addChangeListener(this);

		JTextField speedSliderText = new JTextField("Sorting Speed: ");
		speedSliderText.setEditable(false);
		speedSliderText.setFont(standartFont);
		speedSliderText.setForeground(Color.white);
		speedSliderText.setBackground(menubar.getBackground());
		speedSliderText.setBorder(null);
		speedSliderText.setBounds(Settings.speedSliderTextX, Settings.menuBarComponentsY,Settings.speedSliderTextWidth,Settings.menuBarComponentsHeigth);
		menubar.add(speedSliderText);
	}
	
	private void initArrayLengthSlider() {
		arrayLengthSlider.setBackground(menubar.getBackground());
		arrayLengthSlider.setBounds(Settings.arrayLengthSliderX, Settings.menuBarComponentsY,Settings.arrayLengthSliderWidth,Settings.menuBarComponentsHeigth);
		arrayLengthSlider.addChangeListener(this);
		
		JTextField arrayLengthSliderText = new JTextField("Array Length: ");
		arrayLengthSliderText.setEditable(false);
		arrayLengthSliderText.setFont(standartFont);
		arrayLengthSliderText.setForeground(Color.white);
		arrayLengthSliderText.setBackground(menubar.getBackground());
		arrayLengthSliderText.setBorder(null);
		arrayLengthSliderText.setBounds(Settings.arrayLengthSliderTextX, Settings.menuBarComponentsY,Settings.arrayLengthSliderTextWidth,Settings.menuBarComponentsHeigth);
		menubar.add(arrayLengthSliderText);
	}
	
	private void drawBars(Bar[] bars) {
		allBarsPanel.setLayout(new GridLayout(1,bars.length));
		
		for(int i = 0; i<bars.length; i++) {
			JLayeredPane barPane = new JLayeredPane();
			barPane.setLayout(null);
			
			barPane.add(Main.bars[i].panel);
			allBarsPanel.add(barPane);
			
		}
	}
	
	public String getSelectedAlgorythm() {
		return algoSelect.getSelectedItem().toString();
	}
	
	public static int getSortingSpeed() {
		return speedSlider.getValue();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newArrayButton) {
			allBarsPanel.removeAll();
			Main.arraySliderValue = arrayLengthSlider.getValue();
			Main.bars = Main.initBarArray(Main.arraySliderValue);
			drawBars(Main.bars);
			allBarsPanel.invalidate();
			allBarsPanel.validate();
			allBarsPanel.repaint();
		}
		
		if(e.getSource() == startButton) {
			SortingAlgorithm alg = null;
			
			switch(getSelectedAlgorythm()) {
			case "BubbleSort": alg = new BubbleSort(Main.bars); break;
			case "HeapSort": alg = new HeapSort(Main.bars); break;
			case "InsertionSort": alg = new InsertionSort(Main.bars); break;
			case "MergeSort": alg = new MergeSort(Main.bars); break;
			case "QuickSort": alg = new QuickSort(Main.bars); break;
			case "SelectionSort": alg = new SelectionSort(Main.bars); break;
			}
					
			if(LtoH.isSelected()) {
				alg.sort(SortingOrder.LtoH);			
			} else if(HtoL.isSelected()){
				alg.sort(SortingOrder.HtoL);
			} 	
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == arrayLengthSlider) {
			allBarsPanel.removeAll();
			Main.arraySliderValue = arrayLengthSlider.getValue();
			Main.bars = Main.initBarArray(Main.arraySliderValue);
			drawBars(Main.bars);
			allBarsPanel.invalidate();
			allBarsPanel.validate();
			allBarsPanel.repaint();
		}
		
		if(e.getSource() == speedSlider) {
			Settings.sortingDelay = Settings.maxSpeed - speedSlider.getValue() +1;
			System.out.println(Settings.sortingDelay);
		}
		
	}
}
