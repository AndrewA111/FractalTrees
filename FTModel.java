
/**
 * Model class for fractal tree project
 * @author Andrew Allan
 *
 */
public class FTModel {
	
	// Length of the 'trunk' of the tree
	private int trunkLength;
	
	// Reduction ratio for each recursive call
	private double lengthRatio;
	
	// 'Trunk' initial angle
	private int initialAngle;
	
	// Change in branch angle for each recursive call
	private int angleDelta;
	
	// Recursion Depth
	private int depth;
	
	
	public FTModel() {
		// initialise values
		this.trunkLength = 100;
		this.lengthRatio = 0.8;
		this.initialAngle = 90;
		this.angleDelta = 25;
		this.depth = 3;
	}

	/*
	 * Getters and setters
	 */
	public int getTrunkLength() {
		return trunkLength;
	}


	public void setTrunkLength(int trunkLength) {
		this.trunkLength = trunkLength;
	}


	public double getLengthRatio() {
		return lengthRatio;
	}


	public void setLengthRatio(double lengthRatio) {
		this.lengthRatio = lengthRatio;
	}


	public int getInitialAngle() {
		return initialAngle;
	}


	public void setInitialAngle(int initialAngle) {
		this.initialAngle = initialAngle;
	}


	public int getAngleDelta() {
		return angleDelta;
	}


	public void setAngleDelta(int angleDelta) {
		this.angleDelta = angleDelta;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
}
