import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * NavBar class to hold buttons to switch between tabs
 * @author Andrew Allan
 *
 */
public class NavBarPanel extends JPanel{
	
	// Three sub-panels to act as three buttons
	private JPanel modeOne;
	private JPanel modeTwo;
	private JPanel modeThree;
	
	// Controller
	FTController controller;
	
	public NavBarPanel(FTController controller) {
		
		// Set controller
		this.controller = controller;
		
		// Set layout
		this.setLayout(new GridLayout(1,3));
		
		/*
		 *  Add centred labels
		 */
		this.modeOne = new JPanel(new GridBagLayout());
		this.modeTwo = new JPanel(new GridBagLayout());;
		this.modeThree = new JPanel(new GridBagLayout());
		
		JLabel labelOne = new JLabel("Symmetrical");
		JLabel labelTwo = new JLabel("Random");
		JLabel labelThree = new JLabel("Split");
		
		// Padding
		labelOne.setBorder(new EmptyBorder(10,0,10,0));
		labelTwo.setBorder(new EmptyBorder(10,0,10,0));
		labelThree.setBorder(new EmptyBorder(10,0,10,0));
		
		this.modeOne.add(labelOne);
		this.modeTwo.add(labelTwo);
		this.modeThree.add(labelThree);
		
		/*
		 * Add to grid
		 */
		this.add(modeOne);
		this.add(modeTwo);
		this.add(modeThree);
		
		/*
		 * Add action listeners
		 */
		this.modeOne.addMouseListener(this.controller);
		this.modeTwo.addMouseListener(this.controller);
		this.modeThree.addMouseListener(this.controller);
	}

	// Getters
	public JPanel getModeOne() {
		return modeOne;
	}

	public JPanel getModeTwo() {
		return modeTwo;
	}

	public JPanel getModeThree() {
		return modeThree;
	}
	
	
}
