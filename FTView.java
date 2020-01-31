import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View class for Fractal Tree project
 * @author Andrew Allan
 *
 */
public class FTView extends JFrame{
	
	// Model and controller variables
	private FTModel model;
	private FTController controller;
	
	//JFrame width and height
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 700;
	
	// JFrame position horizontal and vertical components
	private final int H_POS = 100;
	private final int V_POS = 10;
	
	// Border width
	private final int BORDER_WIDTH = 35;
	
	// Border panel
	private BorderedPanel borderPanel;
	
	// Panel to contain symmetrical fractal tree
	private TreePanel treePanel;
	
	// Panel to contain random fractal tree
	private RandomTreePanel randomTreePanel;
	
	// Panel to contain multi-split fractal tree
	private MultiSplitPanel multiSplitPanel;
	
	// Panel to contain sliders
	private SliderPanel sliderPanel;
	
	// Panel to contain NavBar
	private NavBarPanel navBarPanel;
	
	// Card panel to switch between tree types
	private JPanel cardPanel;
	
	public FTView(FTModel model, FTController controller) {
		
		// Set model and controller
		this.model = model;
		this.controller = controller;
		
		// Setup JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocation(H_POS,V_POS);
		setTitle("Fractal Trees");
		
		// Add border panel		
		this.borderPanel = new BorderedPanel(BORDER_WIDTH,BORDER_WIDTH,BORDER_WIDTH,BORDER_WIDTH, Color.GRAY);
		this.add(this.borderPanel);
		
		// Create tree panel
		this.treePanel = new TreePanel(this.model, Color.WHITE);
		
		// Create random tree panel
		this.randomTreePanel = new RandomTreePanel();
		
		// Create multi-split tree panel
		this.multiSplitPanel = new MultiSplitPanel();

		// Create card panel and card layout
		cardPanel = new JPanel(new CardLayout());
		
		// Add tree and random tree panels to card panel
		cardPanel.add(this.treePanel, "Tree");
		cardPanel.add(this.randomTreePanel, "Random");
		cardPanel.add(this.multiSplitPanel, "Multi");
		
		// Add card panel to border panel
		this.borderPanel.add(cardPanel);
		
		// Sliders
		this.sliderPanel = new SliderPanel(this.model, this.controller);
		this.borderPanel.add(this.sliderPanel, BorderLayout.SOUTH);
		
		// NavBar panel
		this.navBarPanel = new NavBarPanel(this.controller);
		this.borderPanel.add(this.navBarPanel, BorderLayout.NORTH);
		
	}
	
	// Getters
	public BorderedPanel getBorderPanel() {
		return borderPanel;
	}
	
	public TreePanel getTreePanel() {
		return treePanel;
	}
	
	public RandomTreePanel getRandomTreePanel() {
		return randomTreePanel;
	}

	public SliderPanel getSliderPanel() {
		return sliderPanel;
	}

	public NavBarPanel getNavBarPanel() {
		return navBarPanel;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

}
