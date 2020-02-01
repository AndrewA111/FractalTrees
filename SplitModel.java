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
		this.trunkLength = 110;
		this.lengthRatio = 0.85;
		this.initialAngle = 90;
		this.arc = 45;
		this.angleRange = 45;
		this.noBranches = 3;
		this.depth = 8;
		this.randTree = false;
	}
	
	// Getters and Setters
	
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

	public int getArc() {
		return arc;
	}

	public void setArc(int arc) {
		this.arc = arc;
	}

	public int getAngleRange() {
		return angleRange;
	}

	public void setAngleRange(int angleRange) {
		this.angleRange = angleRange;
	}

	public int getNoBranches() {
		return noBranches;
	}

	public void setNoBranches(int noBranches) {
		this.noBranches = noBranches;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isRandTree() {
		return randTree;
	}

	public void setRandTree(boolean randTree) {
		this.randTree = randTree;
	}

	public int getInitialAngle() {
		return initialAngle;
	}	

	
	
	

}
