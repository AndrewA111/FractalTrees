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
		
		/*
		 * Symmetrical tree panel
		 */
		
		// If Length slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSymSliderPanel().getLengthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setTrunkLength((int) source.getValue());
			this.view.getSymTreePanel().getSymTreePanel().repaint();
		}
		
		// If Length Ratio slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSymSliderPanel().getLengthRatioSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setLengthRatio(((double) source.getValue())/100);
			this.view.getSymTreePanel().getSymTreePanel().repaint();
		}
		
		// If Angle slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSymSliderPanel().getAngleSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setAngleDelta((int) source.getValue());
			this.view.getSymTreePanel().getSymTreePanel().repaint();
		}
		
		// If Recursion Depth slider changes, update model and view
		if (e.getSource() == this.view.getSymTreePanel().getSymSliderPanel().getDepthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSymModel().setDepth((int) source.getValue());
			this.view.getSymTreePanel().getSymTreePanel().repaint();
		}
		
		/*
		 *  Split tree panel
		 */
		
		// If Length slider changes, update model and view
		if (e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getLengthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSplitModel().setTrunkLength((int) source.getValue());
			this.view.getSplitPanel().getSplitTreePanel().repaint();
		}
		
		// If Length Ratio slider changes, update model and view
		if (e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getLengthRatioSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSplitModel().setLengthRatio(((double) source.getValue())/100);
			this.view.getSplitPanel().getSplitTreePanel().repaint();
		}
		
		// If Arc slider changes, update model and view
		if (e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getArcSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSplitModel().setArc((int) source.getValue());
			this.view.getSplitPanel().getSplitTreePanel().repaint();
		}
		
		// If Arc slider changes, update model and view
		if (e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getNoBranchSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSplitModel().setNoBranches((int) source.getValue());
			this.view.getSplitPanel().getSplitTreePanel().repaint();
		}
		
		// If Recursion Depth slider changes, update model and view
		if (e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getDepthSlider()) {
			JSlider source = (JSlider) e.getSource();
			this.model.getSplitModel().setDepth((int) source.getValue());
			this.view.getSplitPanel().getSplitTreePanel().repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		 * When navbar panel is clicked, set to activePanel
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
		
		/**
		 *  Split tree panel - random/symmetrical selection
		 */
		
		// If symmetrical selected
		if(e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getSymOption()) {
			
			this.model.getSplitModel().setRandTree(false);
			
			this.view.getSplitPanel().getSplitSliderPanel().getSymOption().setBackground(Color.DARK_GRAY);
			this.view.getSplitPanel().getSplitSliderPanel().getSymTitle().setForeground(Color.WHITE);
			
			this.view.getSplitPanel().getSplitSliderPanel().getRandOption().setBackground(null);
			this.view.getSplitPanel().getSplitSliderPanel().getRandTitle().setForeground(Color.black);
			
			this.view.getSplitPanel().getSplitTreePanel().repaint();
			
			
		}
		
		// If random selected
		if(e.getSource() == this.view.getSplitPanel().getSplitSliderPanel().getRandOption()) {
			
			this.model.getSplitModel().setRandTree(true);
			
			this.view.getSplitPanel().getSplitSliderPanel().getRandOption().setBackground(Color.DARK_GRAY);
			this.view.getSplitPanel().getSplitSliderPanel().getRandTitle().setForeground(Color.WHITE);
			
			this.view.getSplitPanel().getSplitSliderPanel().getSymOption().setBackground(null);
			this.view.getSplitPanel().getSplitSliderPanel().getSymTitle().setForeground(Color.BLACK);
			
			this.view.getSplitPanel().getSplitTreePanel().repaint();
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

	
	public JPanel getActivePanel() {
		return activePanel;
	}

	public void setActivePanel(JPanel activePanel) {
		this.activePanel = activePanel;
	}

	
	

}
