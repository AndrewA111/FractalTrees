import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Class to create a symmetrical fractal tree
 * @author Andrew Allan
 *
 */
public class TreePanel extends JPanel {
	
	FTModel model;
	
	public TreePanel(FTModel model, Color c) {
		
		// Set model
		this.model = model;
		
		// set colour
		this.setBackground(c);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawTree(g, this.getWidth()/2, this.getHeight(), model.trunkLength, 
				model.lengthRatio, model.initialAngle, model.angleDelta, model.depth);
	}
	
	public void drawTree(Graphics g, int x1, int y1, int L, double lRatio, int angle, int aDelta, int depth) {
		
		// finishing condition for recursive loop
		if (depth == 0) return;
		
		// line end points
		int x2 = x1 + (int) (L * Math.cos(Math.toRadians(angle)));
		int y2 = y1 - (int) (L * Math.sin(Math.toRadians(angle)));
		
		// draw line from (x1, y1) to (x2, y2)
		g.drawLine(x1, y1, x2, y2);
		
		/*
		 *  recursively call drawTree
		 *  length reduces by factor of 'lRatio'
		 *  angle varies +/- 'delatAngle' degrees
		 */
		drawTree(g, x2, y2, (int) (L * lRatio), lRatio, angle - aDelta, aDelta, depth -1);
		drawTree(g, x2, y2, (int) (L * lRatio), lRatio, angle + aDelta, aDelta, depth -1);
	}

}
