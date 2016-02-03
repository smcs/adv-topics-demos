package smcs.battis.tankwars.app;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.*;
import smcs.battis.tankwars.network.*;

public class TankWars {

    public static final int TANK_COUNT = 3;

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TankWars window = new TankWars();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public TankWars() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("Tank Wars");
	frame.setBounds(100, 100, 600, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	/* choose between client and server mode (and thus workflows) */
	String options[] = { "Client", "Server" };
	if (JOptionPane.showOptionDialog(frame, "Are you the client or server?", "Game Mode", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
	    EnterServerAddressPanel address = new EnterServerAddressPanel(frame);
	    address.setBounds(6, 6, 466, 466);
	    frame.getContentPane().add(address);
	} else {
	    /* TODO we should probably fine tune this a bit... */
	    System.out.println("I'm a server!");
	}

	JButton start = new JButton("Start Game");
	start.setEnabled(false);
	start.setBounds(477, 6, 117, 29);
	frame.getContentPane().add(start);
    }
}
