import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to hold fractal tree drawing and associated control elements
 * per split can be varied
 * @author Andrew Allan
 *
 */
public class SplitPanel extends JPanel {
	
	// Model
	private FTModel model;
	
	// Sub-panel containing tree
	private SplitTreePanel splitTreePanel;
	
	public SplitPanel(FTModel model) {
		
		this.model = model;
		
		// Border layout
		this.setLayout(new BorderLayout());
		
		// Add tree panel
		this.splitTreePanel = new SplitTreePanel(this.model, Color.WHITE);
		this.add(splitTreePanel);
	}
}
