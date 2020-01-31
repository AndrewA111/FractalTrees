
/**
 * Model class for fractal tree project
 * @author Andrew Allan
 *
 */
public class FTModel {
	
	private SymModel symModel;
	private RandomModel randomModel;
	private MultiModel multiModel;
	
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
		this.multiModel = new MultiModel();
	}
	
	// Getters
	public SymModel getSymModel() {
		return symModel;
	}

	public RandomModel getRandomModel() {
		return randomModel;
	}

	public MultiModel getMultiModel() {
		return multiModel;
	}	
	
}
