import java.awt.Color;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;


public class SliderPanel extends JPanel{
	
	// Model and controller
	private FTModel model;
	private FTController controller;
	
	// JSliders
	private JSlider lengthSlider;
	private JSlider angleSlider;
	private JSlider lengthRatioSlider;
	private JSlider depthSlider;
	
	public SliderPanel(FTModel model, FTController controller) {
		
		/*
		 *  Set model
		 *  Class should be updated so model sets ranges and initial values
		 */
		this.model = model;
		this.controller = controller;
		/*
		 * This reference to treePanel will be moved to 
		 * Controller with change listeners 
		 */
		
		// set grid layout
		this.setLayout(new GridLayout(2,4));
		
		// color
		this.setBackground(Color.LIGHT_GRAY);
		
		
		/*
		 * Length Slider
		 */
		
		JLabel lengthLabel = new JLabel("Length:");
		lengthLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.lengthSlider = new JSlider(25, 150, this.model.getTrunkLength());
		
		// Ticks
		this.lengthSlider.setMajorTickSpacing(25);
		this.lengthSlider.setPaintTicks(true);
		
		// Labels
		Hashtable<Integer, JLabel> lengthSliderPosition = new Hashtable<Integer, JLabel>();
		lengthSliderPosition.put(25,  new JLabel("25"));
		lengthSliderPosition.put(50,  new JLabel("50"));
		lengthSliderPosition.put(75,  new JLabel("75"));
		lengthSliderPosition.put(100,  new JLabel("100"));
		lengthSliderPosition.put(125,  new JLabel("125"));
		lengthSliderPosition.put(150,  new JLabel("150 "));
		this.lengthSlider.setLabelTable(lengthSliderPosition);
		this.lengthSlider.setPaintLabels(true);

		// Add to this panel
		this.add(lengthLabel);
		this.add(lengthSlider);
		
		/*
		 *  Length ratio slider
		 */
		
		JLabel lengthRatioLabel = new JLabel("Length Ratio:");
		lengthRatioLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.lengthRatioSlider = new JSlider(70, 95, (int) (this.model.getLengthRatio() * 100));
		
		// Ticks
		this.lengthRatioSlider.setMajorTickSpacing(25);
		this.lengthRatioSlider.setPaintTicks(true);
		
		// Labels
		Hashtable<Integer, JLabel> lengthRatioSliderPosition = new Hashtable<Integer, JLabel>();
		lengthRatioSliderPosition.put(70,  new JLabel("  0.70"));
		lengthRatioSliderPosition.put(75,  new JLabel("0.75"));
		lengthRatioSliderPosition.put(80,  new JLabel("0.80"));
		lengthRatioSliderPosition.put(85,  new JLabel("0.85"));
		lengthRatioSliderPosition.put(90,  new JLabel("0.90"));
		lengthRatioSliderPosition.put(95,  new JLabel("0.95  "));
		this.lengthRatioSlider.setLabelTable(lengthRatioSliderPosition);
		this.lengthRatioSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(lengthRatioLabel);
		this.add(lengthRatioSlider);
				
		/*
		 *  Angle slider
		 */
		
		JLabel angleLabel = new JLabel("Angle:");
		angleLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.angleSlider = new JSlider(0, 90, this.model.getAngleDelta());
		
		// Ticks
		this.angleSlider.setMajorTickSpacing(20);
		this.angleSlider.setPaintTicks(true);
		
		//Labels
		Hashtable<Integer, JLabel> angleSliderPosition = new Hashtable<Integer, JLabel>();
		angleSliderPosition.put(0,  new JLabel("0"));
		angleSliderPosition.put(30,  new JLabel("30"));
		angleSliderPosition.put(60,  new JLabel("60"));
		angleSliderPosition.put(90,  new JLabel("90  "));
		this.angleSlider.setLabelTable(angleSliderPosition);
		this.angleSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(angleLabel);
		this.add(angleSlider);
				
		/*
		 *  Depth slider
		 */
		JLabel depthLabel = new JLabel("Recursion Depth:");
		depthLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.depthSlider = new JSlider(0, 20, this.model.getDepth());
		
		// Ticks
		this.depthSlider.setMajorTickSpacing(20);
		this.depthSlider.setPaintTicks(true);
		
		// Labels
		Hashtable<Integer, JLabel> depthSliderPosition = new Hashtable<Integer, JLabel>();
		depthSliderPosition.put(0,  new JLabel("0"));
		depthSliderPosition.put(5,  new JLabel("5"));
		depthSliderPosition.put(10,  new JLabel("10"));
		depthSliderPosition.put(15,  new JLabel("15"));
		depthSliderPosition.put(20,  new JLabel("20 "));
		this.depthSlider.setLabelTable(depthSliderPosition);
		this.depthSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(depthLabel);
		this.add(depthSlider);
		
		
							
		/*
		 *  Add controller to sliders
		 */
		this.lengthSlider.addChangeListener(this.controller);
		this.lengthRatioSlider.addChangeListener(this.controller);
		this.angleSlider.addChangeListener(this.controller);
		this.depthSlider.addChangeListener(this.controller);
	}
	
	
	/*
	 *  Getters	
	 */
	
	public JSlider getLengthSlider() {
		return lengthSlider;
	}

	public JSlider getAngleSlider() {
		return angleSlider;
	}

	public JSlider getLengthRatioSlider() {
		return lengthRatioSlider;
	}

	public JSlider getDepthSlider() {
		return depthSlider;
	}	
	
}


