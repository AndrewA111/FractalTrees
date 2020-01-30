
/**
 * Controller class for Fractal Tree project
 * @author Andrew Allan
 *
 */
public class FTController {
	
	private FTModel model;
	private FTView view;
	


	public FTController(FTModel model) {
		this.model = model;
	}
	
	
	public void setView(FTView view) {
		this.view = view;
	}

}
