package pl.edu.pw.fizyka.sk;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void initGUI(Container gui) {

    gui.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	
	c.weightx = 0.5;
	c.gridx = 0;
	c.gridy = 0;
	
	//List of clients, their files 
	JPanel listClients = new JPanel();
	listClients.setLayout(null);
	listClients.setPreferredSize(new Dimension(420, 450));
	listClients.setBackground(Color.BLUE);
	gui.add(listClients, c);

	c.gridx = 1;
	/* List of own files */
	JPanel listFiles = new JPanel();
	listFiles.setLayout(null);
	listFiles.setPreferredSize(new Dimension(420, 450));
	//controls.setSize(new Dimension(387, 273));
	listFiles.setBackground(Color.GRAY);
	gui.add(listFiles, c);

	c.gridx = 0;
	c.gridy = 1;
	c.gridwidth = 2;
	/* List of own files */
	JPanel listConnections = new JPanel();
	listConnections.setLayout(null);
	listConnections.setPreferredSize(new Dimension(840, 150));
	//controls.setSize(new Dimension(387, 273));
	listConnections.setBackground(Color.DARK_GRAY);
	gui.add(listConnections, c);

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        initGUI(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}