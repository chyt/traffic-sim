package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import distance.CalculateDistance;

public class Traffic {
	public static CalculateDistance calculateDistance = new CalculateDistance();
	
	public static void main(String[] args) {
		//double distance50 = calculateDistance.calculateStoppingDistance(50, 0.8);
		
		Runnable r = new Runnable() {
			public void run() {
				LineComponent lineComponent = new LineComponent();
				JButton startButton = new JButton("Start");
				lineComponent.add(startButton,BorderLayout.WEST);
				startButton.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
				    	startSim(lineComponent);
				    	
				    } 
				});
				JOptionPane.showMessageDialog(null, lineComponent);
			}
		};
		SwingUtilities.invokeLater(r);
	}
	
	public static void startSim(LineComponent lineComponent) {
		System.out.println("start sim is called" + lineComponent);
		Graphics g = lineComponent.getGraphics();
		g.setColor(Color.black);
	    //g.drawLine(0, 50,  20, 50);
		//.fillRect(x, y, width, height);
	}
}

class LineComponent extends JPanel {
	private static final long serialVersionUID = 1L;

	LineComponent() {
        super();
        setPreferredSize(new Dimension(800, 800));
        //lines = new ArrayList<Line2D.Double>();
        //random = new Random();
    }
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.black);
		g.fillRect(350, 0, 10, 800);
		g.fillRect(450, 0, 10, 800);
		g.fillRect(0, 350, 800, 10);
		g.fillRect(0, 450, 800, 10);
		g.setColor(Color.white);
		g.fillRect(360, 0, 90, 800);
		g.fillRect(0, 360, 800, 90);
		g.setColor(Color.black);
		drawDashedLine(g, 378, 0, 378, 800);
		g.fillRect(400, 0, 5, 800);
		drawDashedLine(g, 428, 0, 428, 800);
		drawDashedLine(g, 0, 378, 800, 378);
		g.fillRect(0, 400, 800, 5);
		drawDashedLine(g, 0, 428, 800, 428);
		g.setColor(Color.white);
		g.fillRect(360, 360, 90, 90);		
	}
	
	public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2){
        Graphics2D g2d = (Graphics2D) g.create();

        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x1, y1, x2, y2);

        //gets rid of the copy
        g2d.dispose();
}
}