
/**
 * Model class for fractal tree project
 * @author Andrew Allan
 *
 */
public class FTModel {
	
	// Length of the 'trunk' of the tree
	int trunkLength;
	
	// Reduction ratio for each recursive call
	double lengthRatio;
	
	// 'Trunk' initial angle
	int initialAngle;
	
	// Change in branch angle for each recursive call
	int angleDelta;
	
	// Recursion Depth
	int depth;
	
	
	public FTModel() {
		// initialise values
		this.trunkLength = 100;
		this.lengthRatio = 0.8;
		this.initialAngle = 90;
		this.angleDelta = 25;
		this.depth = 10;
	}
}
