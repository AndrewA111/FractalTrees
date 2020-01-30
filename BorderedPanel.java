import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * Bordered panel helper class to frame tree panel
 * @author Andrew
 *
 */
public class BorderedPanel extends JPanel{
	
	public BorderedPanel(int north, int west, int south, int east, Color c) {
		// set border layout
		this.setLayout(new BorderLayout());
		
		// set colour
		this.setBackground(c);
		
		// create and empty border, using passed parameters
		Border emptyBorder = BorderFactory.createEmptyBorder(north, west, south, east);
		
		// set 'this' panel to have the defined empty border
		this.setBorder(emptyBorder);
			
	}

}
