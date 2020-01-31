import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Controller class for Fractal Tree project
 * @author Andrew Allan
 *
 */
public class FTController implements ChangeListener {
	
	// Model and view
	private FTModel model;
	private FTView view;
	

	/*
	 * Add model in constructor
	 */
	public FTController(FTModel model) {
		this.model = model;
	}
	
	/*
	 * Controller created before view, 
	 * so set view after view has been created
	 */
	public void setView(FTView view) {
		this.view = view;
	}
	
	public void stateChanged(ChangeEvent e) {
		
		// If Length slider changes, update model and view
		if (e.getSource() == this.view.getSliderPanel().getLengthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.setTrunkLength((int) source.getValue());
			this.view.getTreePanel().repaint();
		}
		
		// If Length Ratio slider changes, update model and view
		if (e.getSource() == this.view.getSliderPanel().getLengthRatioSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.setLengthRatio(((double) source.getValue())/100);
			this.view.getTreePanel().repaint();
		}
		
		// If Angle slider changes, update model and view
		if (e.getSource() == this.view.getSliderPanel().getAngleSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.setAngleDelta((int) source.getValue());
			this.view.getTreePanel().repaint();
		}
		
		// If Recursion Depth slider changes, update model and view
		if (e.getSource() == this.view.getSliderPanel().getDepthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.setDepth((int) source.getValue());
			this.view.getTreePanel().repaint();
		}
		
	}
	

}
