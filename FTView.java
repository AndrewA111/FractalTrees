import java.awt.Color;

import javax.swing.JFrame;

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
	private final int FRAME_WIDTH = 800;
	private final int FRAME_HEIGHT = 600;
	
	// JFrame position horizontal and vertical components
	private final int H_POS = 100;
	private final int V_POS = 100;
	
	public FTView(FTModel model, FTController controller) {
		
		this.model = model;
		this.controller = controller;
		
		// Setup JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocation(H_POS,V_POS);
		setTitle("Fractal Trees");
		
		// Add tree panel within a border panel		
		BorderedPanel borderPanel = new BorderedPanel(50,50,50,50, Color.GRAY);
		TreePanel treePanel = new TreePanel(model, Color.WHITE);
		borderPanel.add(treePanel);
		this.add(borderPanel);
	}
	

}
