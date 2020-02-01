import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Class to create a fractal tree where number of 
 * branches per split can be varied
 * @author Andrew Allan
 *
 */
public class SplitTreePanel extends JPanel {
	
	// Model
	private FTModel model;
	
	// Random object for generating random angles
	Random random = new Random();
	
	
	public SplitTreePanel(FTModel model, Color c) {
			
		this.model = model;
		
		// Set background
		this.setBackground(c);

	}
	
	// Paint components
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// If random mode selected
		if(this.model.getSplitModel().isRandTree()) {
		drawTreeRand(g, this.getWidth()/2, this.getHeight(), 
				this.model.getSplitModel().getTrunkLength(),
				this.model.getSplitModel().getLengthRatio(),
				this.model.getSplitModel().getInitialAngle(),
				this.model.getSplitModel().getArc(),
				this.model.getSplitModel().getAngleRange(),
				this.model.getSplitModel().getNoBranches(),
				this.model.getSplitModel().getDepth());

		}
		
		// Otherwise, symmetrical mode
		else {
		drawTree(g, this.getWidth()/2, this.getHeight(), 
				this.model.getSplitModel().getTrunkLength(),
				this.model.getSplitModel().getLengthRatio(),
				this.model.getSplitModel().getInitialAngle(),
				this.model.getSplitModel().getArc(),
				this.model.getSplitModel().getNoBranches(),
				this.model.getSplitModel().getDepth());
		}
	}
	
	/*
	 *  Recursive method to draw fractal tree
	 */
	public void drawTreeRand(Graphics g, int x1, int y1, int L, double lRatio, 
							int angle, int arc, int aRange, int n, int depth) {
		
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
		
		for(int i = 0 ; i < n; i++) {
			// random offset +/- aRange/2
			int randOffset = random.nextInt(aRange) - (aRange / 2);
			
			if(n > 1) {
				// angle to loop evenly through arc
				int varAngle = (angle - (arc / 2) + (i * arc / (n-1)));
				
				drawTreeRand(g, x2, y2, (int) (L * lRatio), lRatio, 
						varAngle + randOffset, arc, aRange, n, depth -1);
			}
			else {
				drawTreeRand(g, x2, y2, (int) (L * lRatio), lRatio, 
						(arc / 2) + randOffset, arc, aRange, n, depth -1);;
			}
			
		}
	}
	
	/*
	 *  Random tree
	 */
	public void drawTree(Graphics g, int x1, int y1, int L, double lRatio, 
								int angle, int arc, int n, int depth) {
		
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
		
		for(int i = 0 ; i < n; i++) {
			
			
			if(n > 1) {
				// angle to loop evenly through arc
				int varAngle = (angle - (arc / 2) + (i * arc / (n-1)));
				
				drawTree(g, x2, y2, (int) (L * lRatio), lRatio, 
						varAngle , 
						arc, n, depth -1);
			}
			else {
				drawTree(g, x2, y2, (int) (L * lRatio), lRatio, 
						angle - arc/2, 
						arc, n, depth -1);;
			}
			
			
		}
	}
}
