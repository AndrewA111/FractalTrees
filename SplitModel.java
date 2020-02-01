/**
 * Model class for fractal tree where number of branches 
 * per split can be varied
 * @author Andrew Allan
 *
 */
public class SplitModel {
	// Length of the 'trunk' of the tree
	private int trunkLength;
	
	// Reduction ratio for each recursive call
	private double lengthRatio;
	
	// 'Trunk' initial angle
	private int initialAngle;
	
	// Arc over which branches are split
	private int arc;
	
	// Range of change in branch angle for each recursive call
	private int angleRange;
	
	// Number of branches per split
	private int noBranches;
	
	// Recursion Depth
	private int depth;
	
	// Boolean to switch between symmetrical and random trees
	private boolean randTree;
	
	public SplitModel() {
		// initialise values
		this.trunkLength = 100;
		this.lengthRatio = 0.85;
		this.initialAngle = 90;
		this.arc = 60;
		this.angleRange = 45;
		this.noBranches = 4;
		this.depth = 7;
		this.randTree = false;
	}	
	
	// Getters
	public int getTrunkLength() {
		return trunkLength;
	}

	public double getLengthRatio() {
		return lengthRatio;
	}

	public int getInitialAngle() {
		return initialAngle;
	}

	public int getArc() {
		return arc;
	}

	public int getAngleRange() {
		return angleRange;
	}

	public int getNoBranches() {
		return noBranches;
	}

	public int getDepth() {
		return depth;
	}

	public boolean isRandTree() {
		return randTree;
	}
	
	

}
