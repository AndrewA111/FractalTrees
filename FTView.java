import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * View class for Fractal Tree project
 * @author Andrew Allan
 *
 */
public class FTView extends JFrame{
	
	// Model and controller variables
	private FTModel model;
	private FTController controller;
	
	//JFrame width and height
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 700;
	
	// JFrame position horizontal and vertical components
	private final int H_POS = 100;
	private final int V_POS = 10;
	
	// Panel to contain fractal tree
	private TreePanel treePanel;
	private SliderPanel sliderPanel;
	
	public FTView(FTModel model, FTController controller) {
		
		// Set model and controller
		this.model = model;
		this.controller = controller;
		
		// Setup JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocation(H_POS,V_POS);
		setTitle("Fractal Trees");
		
		// Add tree panel within a border panel		
		BorderedPanel borderPanel = new BorderedPanel(50,50,50,50, Color.GRAY);
		this.treePanel = new TreePanel(this.model, Color.WHITE);
		borderPanel.add(treePanel);
		this.add(borderPanel);
		
		// Sliders
		sliderPanel = new SliderPanel(this.model, this.controller);
		borderPanel.add(sliderPanel, BorderLayout.SOUTH);
			
	}
	
	// Getters
	public TreePanel getTreePanel() {
		return treePanel;
	}

	public SliderPanel getSliderPanel() {
		return sliderPanel;
	}
	
	
}
