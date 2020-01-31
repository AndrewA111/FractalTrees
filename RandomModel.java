/**
 * Model class for fractal tree where branch 
 * angles are generated at random
 * @author Andrew Allan
 *
 */
public class RandomModel {
	// Length of the 'trunk' of the tree
	private int trunkLength;
	
	// Reduction ratio for each recursive call
	private double lengthRatio;
	
	// 'Trunk' initial angle
	private int initialAngle;
	
	// Change in branch angle for each recursive call
	private int angleRange;
	
	// Recursion Depth
	private int depth;
	
	public RandomModel() {
		// initialise values
		this.trunkLength = 100;
		this.lengthRatio = 0.85;
		this.initialAngle = 90;
		this.angleRange = 30;
		this.depth = 10;
	}

	public int getTrunkLength() {
		return trunkLength;
	}

	public double getLengthRatio() {
		return lengthRatio;
	}

	public int getInitialAngle() {
		return initialAngle;
	}

	public int getAngleRange() {
		return angleRange;
	}

	public int getDepth() {
		return depth;
	}
	
	
}
