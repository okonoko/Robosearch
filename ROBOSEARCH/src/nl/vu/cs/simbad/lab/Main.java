package nl.vu.cs.simbad.lab;

import simbad.gui.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
    
        System.setProperty("j3d.implicitAntialiasing", "true");
        Environment environment = Environment.getInstance();
        UserInterface.getInstance().addBoxes(environment);
        
        CentralStation cs = CentralStation.getInstance();
        cs.addRobot();
        cs.setState(0);
        
        
        JButton button = new JButton("Abort mission");
        JPanel panel = new JPanel();
        panel.add(button);
     
        Simbad frame = new Simbad(environment, false); 
        frame.setVisible(true);	
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        button.addActionListener(new ActionListener() { 
        	@Override
        	public void actionPerformed(ActionEvent e) {  
        		cs.setState(6);
        	} 
        });
        frame.setFocusable(true);
        frame.update(frame.getGraphics());
         
    }

} 