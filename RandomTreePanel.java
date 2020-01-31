import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Class to draw fractal tree, where branch angles vary randomly
 * @author Andrew Allan
 *
 */
public class RandomTreePanel extends JPanel{
	
	private FTModel model;
	
	// Random object for generating random angles
	Random random = new Random();
	
	public RandomTreePanel(FTModel model,Color c) {
		
		// set model
		this.model = model;
		
		// set colour
		this.setBackground(c);
	}
	
	/*
	 *  Draw tree to panel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawTree(g, this.getWidth()/2, this.getHeight(), 
				this.model.getRandomModel().getTrunkLength(), 
				this.model.getRandomModel().getLengthRatio(), 
				this.model.getRandomModel().getInitialAngle(), 
				this.model.getRandomModel().getAngleRange(), 
				this.model.getRandomModel().getDepth());
	}
	
	/*
	 *  Recursive method to draw fractal tree
	 */
	public void drawTree(Graphics g, int x1, int y1, int L, double lRatio, int angle, int aRange, int depth) {
		
		// finishing condition for recursive loop
		if (depth == 0) return;
		
		// line end points
		int x2 = x1 + (int) (L * Math.cos(Math.toRadians(angle)));
		int y2 = y1 - (int) (L * Math.sin(Math.toRadians(angle)));
		
		// draw line from (x1, y1) to (x2, y2)
		g.drawLine(x1, y1, x2, y2);
		
		// angle to vary angle by
		int aDelta;
		
		/*
		 *  recursively call drawTree
		 *  length reduces by factor of 'lRatio'
		 *  angle varies +/- 'delatAngle' degrees
		 */
		
		// randomise angleDelta before recursive call
		aDelta = this.random.nextInt(aRange);
		drawTree(g, x2, y2, (int) (L * lRatio), lRatio, angle - aDelta, aRange, depth -1);
		
		// randomise angleDelta before recursive call
		aDelta = this.random.nextInt(aRange);
		drawTree(g, x2, y2, (int) (L * lRatio), lRatio, angle + aDelta, aRange, depth -1);
	}
}
