import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderPanel extends JPanel{
	
	private FTModel model;
	private TreePanel treePanel;
	
	public SliderPanel(FTModel model, TreePanel treePanel) {
		
		/*
		 *  Set model
		 *  Class should be updated so model sets ranges and initial values
		 */
		this.model = model;
		/*
		 * This reference to treePanel will be moved to 
		 * Controller with change listeners 
		 */
		this.treePanel = treePanel;
		
		
		// set grid layout
		this.setLayout(new GridLayout(2,4));
		
		// color
		this.setBackground(Color.LIGHT_GRAY);
		
		// Length slider
		JLabel lengthLabel = new JLabel("Length:");
		lengthLabel.setBorder(new EmptyBorder(0,10,0,0));
		JSlider lengthSlider = new JSlider(25, 150, model.getTrunkLength());
		
		
		// Ticks and Labels
		lengthSlider.setMajorTickSpacing(25);
		lengthSlider.setPaintTicks(true);
		Hashtable<Integer, JLabel> lengthSliderPosition = new Hashtable<Integer, JLabel>();
		lengthSliderPosition.put(25,  new JLabel("25"));
		lengthSliderPosition.put(50,  new JLabel("50"));
		lengthSliderPosition.put(75,  new JLabel("75"));
		lengthSliderPosition.put(100,  new JLabel("100"));
		lengthSliderPosition.put(125,  new JLabel("125"));
		lengthSliderPosition.put(150,  new JLabel("150 "));
		lengthSlider.setLabelTable(lengthSliderPosition);
		lengthSlider.setPaintLabels(true);

		// Add to this panel
		this.add(lengthLabel);
		this.add(lengthSlider);
		
		// Length ratio slider
		JLabel lengthRatioLabel = new JLabel("Length Ratio:");
		lengthRatioLabel.setBorder(new EmptyBorder(0,10,0,0));
		JSlider lengthRatioSlider = new JSlider(70, 95, (int) (model.getLengthRatio() * 100));
		
		// Ticks and Labels
		lengthRatioSlider.setMajorTickSpacing(25);
		lengthRatioSlider.setPaintTicks(true);
		Hashtable<Integer, JLabel> lengthRatioSliderPosition = new Hashtable<Integer, JLabel>();
		lengthRatioSliderPosition.put(70,  new JLabel("  0.70"));
		lengthRatioSliderPosition.put(75,  new JLabel("0.75"));
		lengthRatioSliderPosition.put(80,  new JLabel("0.80"));
		lengthRatioSliderPosition.put(85,  new JLabel("0.85"));
		lengthRatioSliderPosition.put(90,  new JLabel("0.90"));
		lengthRatioSliderPosition.put(95,  new JLabel("0.95  "));
		lengthRatioSlider.setLabelTable(lengthRatioSliderPosition);
		lengthRatioSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(lengthRatioLabel);
		this.add(lengthRatioSlider);
				
		// Angle slider
		JLabel angleLabel = new JLabel("Angle:");
		angleLabel.setBorder(new EmptyBorder(0,10,0,0));
		JSlider angleSlider = new JSlider(0, 90, model.getAngleDelta());
		
		// Ticks and Labels
		angleSlider.setMajorTickSpacing(20);
		angleSlider.setPaintTicks(true);
		Hashtable<Integer, JLabel> angleSliderPosition = new Hashtable<Integer, JLabel>();
		angleSliderPosition.put(0,  new JLabel("0"));
		angleSliderPosition.put(30,  new JLabel("30"));
		angleSliderPosition.put(60,  new JLabel("60"));
		angleSliderPosition.put(90,  new JLabel("90  "));
		angleSlider.setLabelTable(angleSliderPosition);
		angleSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(angleLabel);
		this.add(angleSlider);
				
		// Depth slider
		JLabel depthLabel = new JLabel("Recursion Depth:");
		depthLabel.setBorder(new EmptyBorder(0,10,0,0));
		JSlider depthSlider = new JSlider(0, 20, model.getDepth());
		
		depthSlider.setMajorTickSpacing(20);
		depthSlider.setPaintTicks(true);
		Hashtable<Integer, JLabel> depthSliderPosition = new Hashtable<Integer, JLabel>();
		depthSliderPosition.put(0,  new JLabel("0"));
		depthSliderPosition.put(5,  new JLabel("5"));
		depthSliderPosition.put(10,  new JLabel("10"));
		depthSliderPosition.put(15,  new JLabel("15"));
		depthSliderPosition.put(20,  new JLabel("20 "));
		depthSlider.setLabelTable(depthSliderPosition);
		depthSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(depthLabel);
		this.add(depthSlider);
		
		
							
		// Add change listeners to sliders
		lengthSlider.addChangeListener(new LengthSliderListener());
		lengthRatioSlider.addChangeListener(new LengthRatioSliderListener());
		angleSlider.addChangeListener(new AngleSliderListener());
		depthSlider.addChangeListener(new DepthSliderListener());
	}

	/*
	 * Change listener classes to be moved to controller
	 */
	
	/**
	 * Change listener for Trunk Length slider
	 * @author Andrew Allan
	 *
	 */
	public class LengthSliderListener implements ChangeListener {
			
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			model.setTrunkLength((int) source.getValue());
			treePanel.repaint();
		}
	}
	
	/**
	 * Change listener for Length Ratio slider
	 * @author Andrew Allan
	 *
	 */
	public class LengthRatioSliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			model.setLengthRatio(((double) source.getValue())/100);
			treePanel.repaint();
			}
	}
	
	/**
	 * Change listener for Angle slider
	 * @author Andrew Allan
	 *
	 */
	public class AngleSliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			model.setAngleDelta((int) source.getValue());
			treePanel.repaint();
			}
	}
	
	/**
	 * Change listener for Recusion Dept Slider
	 * @author Andrew Allan
	 *
	 */
	public class DepthSliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			model.setDepth((int) source.getValue());
			treePanel.repaint();
		}
	}
	
	
	
	
}


