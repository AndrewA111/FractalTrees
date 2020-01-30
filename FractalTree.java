
/**
 * Main class for Fractal Tree project
 * @author Andrew Allan
 *
 */
public class FractalTree {
	public static void main(String[] args) {

		// Initialise MVC
		FTModel model = new FTModel();
		FTController controller = new FTController(model);
		FTView view = new FTView(model, controller);
		controller.setView(view);
		
		view.setVisible(true);
	}
}
