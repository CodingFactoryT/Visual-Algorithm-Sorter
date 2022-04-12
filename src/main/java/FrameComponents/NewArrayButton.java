package main.java.FrameComponents;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import main.java.MainFrame;
import main.java.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NewArrayButton extends JButton implements ActionListener {
	
	public NewArrayButton() {
		super("New Array", Settings.newArrayButtonImage);
		
		this.setBounds(Settings.newArrayButtonX, Settings.menuBarComponentsY,Settings.newArrayButtonWidth,Settings.menuBarComponentsHeigth);
		this.setBackground(Settings.menubarBackgroundColor);
		this.setBorderPainted(false);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(Settings.standartTextColor);
		this.setFont(Settings.standartFont);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.viewPort.displayNewArray();
	}
}
