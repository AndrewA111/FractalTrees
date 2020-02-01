import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * Class to hold symmetrical fractal tree drawing and associated control elements
 * @author Andrew Allan
 *
 */
public class SymTreePanel extends JPanel{
	
	// Model and controller variables
	private FTModel model;
	private FTController controller;
	
	// Tree-drawing and sliders sub panels
	private TreePanel treePanel;
	private SliderPanel sliderPanel;
	
	public SymTreePanel(FTModel model, FTController controller) {
		
		//Set model and controller
		this.model = model;
		this.controller = controller;
		
		// Border layout
		this.setLayout(new BorderLayout());
		
		// Create tree panel
		this.treePanel = new TreePanel(this.model, Color.WHITE);
		
		// Create sliders panel
		this.sliderPanel = new SliderPanel(this.model, this.controller);
		
		// Add tree and slider panel to this panel
		this.add(this.treePanel);
		this.add(this.sliderPanel, BorderLayout.SOUTH);
	}
	
	// Getters
	public TreePanel getTreePanel() {
		return treePanel;
	}

	public SliderPanel getSliderPanel() {
		return sliderPanel;
	}
	
	

}
