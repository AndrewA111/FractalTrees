import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomTreePanel extends JPanel{
	
	public RandomTreePanel() {
		this.setLayout(new GridBagLayout());
		this.add(new JLabel("Random Tree Panel"));
	}
}
