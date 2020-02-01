
/**
 * Model class for fractal tree project
 * @author Andrew Allan
 *
 */
public class FTModel {
	
	private SymModel symModel;
	private RandomModel randomModel;
	private SplitModel splitModel;
	
	public FTModel() {
		
		/*
		 *  Model for the symmetrical fractal tree
		 */
		this.symModel = new SymModel();
		
		/*
		 * Model for the random fractal tree
		 */
		this.randomModel = new RandomModel();
		
		/*
		 * Model for the multi-split fractal tree
		 */
		this.splitModel = new SplitModel();
	}
	
	// Getters
	public SymModel getSymModel() {
		return symModel;
	}

	public RandomModel getRandomModel() {
		return randomModel;
	}

	public SplitModel getSplitModel() {
		return splitModel;
	}

}
