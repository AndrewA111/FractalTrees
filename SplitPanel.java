import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * Class to hold fractal tree drawing and associated control elements
 * per split can be varied
 * @author Andrew Allan
 *
 */
public class SplitPanel extends JPanel {
	
	// Model and controller variables
	private FTModel model;
	private FTController controller;
	
	// Tree-drawing and sliders sub panels
	private SplitTreePanel splitTreePanel;
	private SplitSliderPanel splitSliderPanel;
	
	public SplitPanel(FTModel model, FTController controller) {
		
		this.model = model;
		this.controller = controller;
		
		// Border layout
		this.setLayout(new BorderLayout());
		
		// Add tree panel
		this.splitTreePanel = new SplitTreePanel(this.model, Color.WHITE);
		this.add(splitTreePanel);
		
		// Add slider panel
		this.splitSliderPanel = new SplitSliderPanel(this.model, this.controller);
		this.add(splitSliderPanel, BorderLayout.EAST);
		
		
	}
	
	// Getters
	public SplitSliderPanel getSplitSliderPanel() {
		return splitSliderPanel;
	}

	public SplitTreePanel getSplitTreePanel() {
		return splitTreePanel;
	}
	
	
	
}
