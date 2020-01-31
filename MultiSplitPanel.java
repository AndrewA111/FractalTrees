import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to draw fractal tree, where number of branches 
 * per split can be varied
 * @author Andrew Allan
 *
 */
public class MultiSplitPanel extends JPanel {
	
	public MultiSplitPanel() {
		this.setLayout(new GridBagLayout());
		this.add(new JLabel("Multi-split Tree Panel"));
	}
}
