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
	
	// Panel to contain symmetrical tree and sliders
	private SymPanel symTreePanel;
	
	// Panel to contain random fractal tree
	private RandomTreePanel randomTreePanel;
	
	// Panel to contain multi-split fractal tree
	private SplitPanel splitPanel;
	
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
		
		/*
		 * Create tree views
		 * Each view contains tree drawing plus any control components (e.g. sliders)
		 */
		
		// Create tree panel
		this.symTreePanel = new SymPanel(this.model, this.controller);
		
		// Create random tree panel
		this.randomTreePanel = new RandomTreePanel(this.model, Color.WHITE);
		
		// Create multi-split tree panel
		this.splitPanel = new SplitPanel(this.model, this.controller);

		/*
		 * Add different tree views to a card layout
		 */
		
		// Create card panel and card layout
		cardPanel = new JPanel(new CardLayout());
		
		// Add tree and random tree panels to card panel
		cardPanel.add(this.symTreePanel, "Tree");
		cardPanel.add(this.randomTreePanel, "Random");
		cardPanel.add(this.splitPanel, "Multi");
		
		// Add card panel to border panel
		this.borderPanel.add(cardPanel);
		
		/*
		 *  NavBar panel
		 *  NavBar allows switching between views held in card layout
		 */
		
		this.navBarPanel = new NavBarPanel(this.controller);
		this.borderPanel.add(this.navBarPanel, BorderLayout.NORTH);
		
		
	}
	
	// Getters
	public BorderedPanel getBorderPanel() {
		return borderPanel;
	}
	
	public SymPanel getSymTreePanel() {
		return symTreePanel;
	}

	public RandomTreePanel getRandomTreePanel() {
		return randomTreePanel;
	}
	
	public SplitPanel getSplitPanel() {
		return splitPanel;
	}

	public NavBarPanel getNavBarPanel() {
		return navBarPanel;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

}
