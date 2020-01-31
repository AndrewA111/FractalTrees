import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Controller class for Fractal Tree project
 * @author Andrew Allan
 *
 */
public class FTController implements ChangeListener, MouseListener {
	
	// Model and view
	private FTModel model;
	private FTView view;
	
	// Variable to track which panel is active
	private JPanel activePanel;
	

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
		if (e.getSource() == this.view.getSymTreePanel().getSliderPanel().getLengthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setTrunkLength((int) source.getValue());
			this.view.getSymTreePanel().getTreePanel().repaint();
		}
		
		// If Length Ratio slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSliderPanel().getLengthRatioSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setLengthRatio(((double) source.getValue())/100);
			this.view.getSymTreePanel().getTreePanel().repaint();
		}
		
		// If Angle slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSliderPanel().getAngleSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setAngleDelta((int) source.getValue());
			this.view.getSymTreePanel().getTreePanel().repaint();
		}
		
		// If Recursion Depth slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSliderPanel().getDepthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setDepth((int) source.getValue());
			this.view.getSymTreePanel().getTreePanel().repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		 * When panel is clicked, set to activePanel
		 * Active panel is highlighted and others default colour
		 */
		if (e.getSource() == this.view.getNavBarPanel().getModeOne()
				|| e.getSource() == this.view.getNavBarPanel().getModeTwo()
				|| e.getSource() == this.view.getNavBarPanel().getModeThree()) {
			
			// Set all panels to default colour
			this.view.getNavBarPanel().getModeOne().setBackground(null);
			this.view.getNavBarPanel().getModeTwo().setBackground(null);
			this.view.getNavBarPanel().getModeThree().setBackground(null);
			
			// set active panel and highlight
			activePanel = (JPanel) e.getSource();
			((JPanel) e.getSource()).setBackground(Color.LIGHT_GRAY);
			
			/*
			 *  Check which nav button is active, and switch to associated view
			 */
			
			// Symmetrical tree
			if(activePanel == this.view.getNavBarPanel().getModeOne()) {
				CardLayout c = (CardLayout) (this.view.getCardPanel().getLayout());
				c.show(this.view.getCardPanel(), "Tree");
			}
			
			// Random tree
			if(activePanel == this.view.getNavBarPanel().getModeTwo()) {
				CardLayout c = (CardLayout) (this.view.getCardPanel().getLayout());
				c.show(this.view.getCardPanel(), "Random");				
			}
			
			// Multi split tree
			if(activePanel == this.view.getNavBarPanel().getModeThree()) {
				CardLayout c = (CardLayout) (this.view.getCardPanel().getLayout());
				c.show(this.view.getCardPanel(), "Multi");				
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		 * If mouse is in a panel, highlight panel
		 */
		if ((e.getSource() == this.view.getNavBarPanel().getModeOne()
				|| e.getSource() == this.view.getNavBarPanel().getModeTwo()
				|| e.getSource() == this.view.getNavBarPanel().getModeThree()
				) && e.getSource() != activePanel) {
			((JPanel) e.getSource()).setBackground(Color.LIGHT_GRAY);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		/*
		 * When mouse leaves a panel, set colour back to default,
		 * unless panel is activePanel
		 */
		if ((e.getSource() == this.view.getNavBarPanel().getModeOne()
				|| e.getSource() == this.view.getNavBarPanel().getModeTwo()
				|| e.getSource() == this.view.getNavBarPanel().getModeThree()
				) && e.getSource() != activePanel){
			((JPanel) e.getSource()).setBackground(null);
		}
	}

	
	

}
