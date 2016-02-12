package animapractice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CheapAnimation extends JFrame implements ActionListener{

	final int numberOfButtons = 3;
	final  int numberOfImages = 6;
	private static final long serialVersionUID = 1L;
	private JButton buttonArray[] = new JButton[numberOfButtons];
	private Icon iconArray[] = new Icon[numberOfImages];
	private JLabel myJLabel = new JLabel();
	private boolean isRunning = false;
	private boolean isStopped = false;
	
	public CheapAnimation()   {
		setSize(350, 380);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setBackground(new Color(28, 3, 3));
				
		buttonArray[0] = new JButton("Start");			
		buttonArray[1] = new JButton("Pause");			
		buttonArray[2] = new JButton("Close");			

		for (int i=0; i < numberOfButtons; i++) {
			add(buttonArray[i]);  // add button to JFrame
			buttonArray[i].addActionListener(this);
		}

		iconArray[0] = new ImageIcon("jump.png");
		iconArray[1] = new ImageIcon("jump1.png");
		iconArray[2] = new ImageIcon("jump3.png");
		iconArray[3] = new ImageIcon("jump2.png");
		iconArray[4] = new ImageIcon("jump5.png");
		iconArray[5] = new ImageIcon("jump6.png");
		
		//iconArray[0].getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		myJLabel = new JLabel(iconArray[0]);
				
		add(myJLabel);
		setVisible(true);
		for(int j=0; j < 500 && !isStopped; j++){ //run 500 times
		for(int i=0; i < numberOfImages; i++) {
			try {
				myJLabel.setIcon(iconArray[i]);
				Thread.sleep(150);
				while (!isRunning){
					Thread.sleep(150);
				}
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	    	}	
		}
		
		}
	}	
	
	public void actionPerformed(ActionEvent event) {
			//JOptionPane.showMessageDialog(CheapAnimation.this, "You pressed "+ event.getActionCommand());
			if (event.getSource() == buttonArray[0]) {
				isRunning = true;
			} else if (event.getSource() == buttonArray[1]) {
				isRunning = false;
				buttonArray[0].setText("Resume");
			} else if (event.getSource() == buttonArray[2]) {
				isStopped = true;
				buttonArray[0].setText("Close");
				System.exit(0);
			}
					

	}
	
	
	
    public static void main( String args[]) throws InterruptedException{
		CheapAnimation myCheapAnimation = new CheapAnimation();
    }
}

