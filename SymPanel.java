import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * Class to hold symmetrical fractal tree drawing and associated control elements
 * @author Andrew Allan
 *
 */
public class SymPanel extends JPanel{
	
	// Model and controller variables
	private FTModel model;
	private FTController controller;
	
	// Tree-drawing and sliders sub panels
	private SymTreePanel symTreePanel;
	private SymSliderPanel symSliderPanel;
	
	public SymPanel(FTModel model, FTController controller) {
		
		//Set model and controller
		this.model = model;
		this.controller = controller;
		
		// Border layout
		this.setLayout(new BorderLayout());
		
		// Create tree panel
		this.symTreePanel = new SymTreePanel(this.model, Color.WHITE);
		
		// Create sliders panel
		this.symSliderPanel = new SymSliderPanel(this.model, this.controller);
		
		// Add tree and slider panel to this panel
		this.add(this.symTreePanel);
		this.add(this.symSliderPanel, BorderLayout.SOUTH);
	}
	
	// Getters
	public SymTreePanel getSymTreePanel() {
		return symTreePanel;
	}

	public SymSliderPanel getSymSliderPanel() {
		return symSliderPanel;
	}
	
	

}
