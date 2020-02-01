import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

public class SplitSliderPanel extends JPanel {
	
	// Model and controller
	private FTModel model;
	private FTController controller;
	
	// JSliders
	private JSlider lengthSlider;
	private JSlider arcSlider;
	private JSlider lengthRatioSlider;
	private JSlider noBranchSlider;
	private JSlider depthSlider;
	
	// Panels and labels acting as buttons
	private JPanel randOption;
	private JPanel symOption;
	
	private JLabel randTitle;
	private JLabel symTitle; 
	
	public SplitSliderPanel(FTModel model, FTController controller) {
		
		/*
		 *  Set model
		 */
		this.model = model;
		this.controller = controller;
		
		// Set grid layout
		this.setLayout(new GridLayout(11,1));
		
		// Colour
		this.setBackground(Color.LIGHT_GRAY);
		
		/*
		 * Random/Symmetrical Panels (to act as buttons)
		 */
		
		// Holding box
		JPanel RSBox = new JPanel(new GridLayout(1,2));
		
		// Panel buttons
		this.randOption = new JPanel(new GridBagLayout());
		this.randTitle = new JLabel("Random");
		this.randOption.setBackground(null);
		this.randOption.add(this.randTitle);
		
		this.symOption = new JPanel(new GridBagLayout());
		this.symTitle = new JLabel("Symmetrical"); 
		this.symOption.setBackground(Color.DARK_GRAY);
		symTitle.setForeground(Color.WHITE);
		this.symOption.add(this.symTitle);
		
		// Add to holding box
		RSBox.add(randOption);
		RSBox.add(symOption);
		
		// Add to this panel
		this.add(RSBox);
		
		
		/*
		 * Length Slider
		 */
		
		JLabel lengthLabel = new JLabel("Length:");
		lengthLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.lengthSlider = new JSlider(25, 150, this.model.getSplitModel().getTrunkLength());
		
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
		this.lengthRatioSlider = new JSlider(70, 95, (int) (this.model.getSplitModel().getLengthRatio() * 100));
		
		// Ticks
		this.lengthRatioSlider.setMajorTickSpacing(5);
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
		 *  Arc slider
		 */
		
		JLabel angleLabel = new JLabel("Arc:");
		angleLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.arcSlider = new JSlider(0, 180, this.model.getSplitModel().getArc());
		
		// Ticks
		this.arcSlider.setMajorTickSpacing(30);
		this.arcSlider.setPaintTicks(true);
		
		//Labels
		Hashtable<Integer, JLabel> angleSliderPosition = new Hashtable<Integer, JLabel>();
		angleSliderPosition.put(0,  new JLabel("0"));
		angleSliderPosition.put(60,  new JLabel("60"));
		angleSliderPosition.put(120,  new JLabel("120"));
		angleSliderPosition.put(180,  new JLabel("180  "));
		this.arcSlider.setLabelTable(angleSliderPosition);
		this.arcSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(angleLabel);
		this.add(arcSlider);
				
		/*
		 *  NUmber of branches slider
		 */
		JLabel noBranchLabel = new JLabel("No. Branches:");
		noBranchLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.noBranchSlider = new JSlider(1, 4, this.model.getSplitModel().getNoBranches());
		
		// Ticks
		this.noBranchSlider.setMajorTickSpacing(1);
		this.noBranchSlider.setPaintTicks(true);
		
		// Labels
		Hashtable<Integer, JLabel> noBranchSliderPosition = new Hashtable<Integer, JLabel>();
		noBranchSliderPosition.put(1,  new JLabel("1"));
		noBranchSliderPosition.put(2,  new JLabel("2"));
		noBranchSliderPosition.put(3,  new JLabel("3"));
		noBranchSliderPosition.put(4,  new JLabel("4"));
		this.noBranchSlider.setLabelTable(noBranchSliderPosition);
		this.noBranchSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(noBranchLabel);
		this.add(noBranchSlider);
		
		/*
		 *  Depth slider
		 */
		JLabel depthLabel = new JLabel("Recursion Depth:");
		depthLabel.setBorder(new EmptyBorder(0,10,0,0));
		this.depthSlider = new JSlider(0, 10, this.model.getSplitModel().getDepth());
		
		// Ticks
		this.depthSlider.setMajorTickSpacing(5);
		this.depthSlider.setPaintTicks(true);
		
		// Labels
		Hashtable<Integer, JLabel> depthSliderPosition = new Hashtable<Integer, JLabel>();
		depthSliderPosition.put(0,  new JLabel("0"));
		depthSliderPosition.put(5,  new JLabel("5"));
		depthSliderPosition.put(10,  new JLabel("10"));
		this.depthSlider.setLabelTable(depthSliderPosition);
		this.depthSlider.setPaintLabels(true);
		
		// Add to this panel
		this.add(depthLabel);
		this.add(depthSlider);
		
		
							
		/*
		 *  Add controller to sliders
		 */
		System.out.println("Change listeners being added");
		this.lengthSlider.addChangeListener(this.controller);
		this.lengthRatioSlider.addChangeListener(this.controller);
		this.arcSlider.addChangeListener(this.controller);
		this.noBranchSlider.addChangeListener(this.controller);
		this.depthSlider.addChangeListener(this.controller);
		
		/*
		 *  Add controller to panel buttons
		 */
		this.randOption.addMouseListener(this.controller);
		this.symOption.addMouseListener(this.controller);;
		
	}
	
	// Getters
	
	public JSlider getLengthSlider() {
		return lengthSlider;
	}

	public JSlider getLengthRatioSlider() {
		return lengthRatioSlider;
	}
	
	public JSlider getArcSlider() {
		return arcSlider;
	}

	public JSlider getNoBranchSlider() {
		return noBranchSlider;
	}

	public JSlider getDepthSlider() {
		return depthSlider;
	}

	public JPanel getSymOption() {
		return symOption;
	}

	public JLabel getSymTitle() {
		return symTitle;
	}

	public JPanel getRandOption() {
		return randOption;
	}

	public JLabel getRandTitle() {
		return randTitle;
	}	
	
	

}
