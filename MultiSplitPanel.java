import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultiSplitPanel extends JPanel {
	
	public MultiSplitPanel() {
		this.setLayout(new GridBagLayout());
		this.add(new JLabel("Multi-split Tree Panel"));
	}
}
