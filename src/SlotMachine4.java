import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * Slot Machine Class that runs GUI which displays 3 slots that user can spin and stop
 * @author Candace Chen
 *
 */
public class SlotMachine4 extends JFrame {

	/**
	 * ---------------------
	 * Instance Variables
	 * ---------------------
	 */
	
	//Frame
	protected JPanel contentPane;
	
	//Title
	protected JLabel titleLabel;
	
	//Buttons
	protected JButton spinButton;
	protected JButton stopButton;
	
	//ImageIcons
	protected ImageIcon image1;
	protected ImageIcon image2;
	protected ImageIcon image3;
	protected ImageIcon image4;
	protected ImageIcon image5;
	
	//Labels for Slots
	protected JLabel label1;
	protected JLabel label2;
	protected JLabel label3;
	
	//Thread for running
	SlotMachineRunnable r1 = new SlotMachineRunnable();
	Thread t1 = new Thread(r1);
	
	/**----------------------------
	 * Images
	 * ----------------------------
	 */
	
	/**
	 * Receives ImageIcon and scales it to fit the label size (85 X 85), then returns the scaled ImageIcon
	 * @param image  the ImageIcon to scale
	 * @return  scaledImage  the scaled ImageIcon
	 */
	public static ImageIcon scaleImage(ImageIcon image) {
		Image scalingImage = image.getImage();
		Image newImage = scalingImage.getScaledInstance(85, 85, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaledImage = new ImageIcon(newImage);
		return scaledImage;
	}
	
	/**-----------------------
	 * Getters & Setters
	 * -----------------------
	 */
	
	/**
	 * @return the titleLabel
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}



	/**
	 * @param titleLabel the titleLabel to set
	 */
	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}



	/**
	 * @return the spinButton
	 */
	public JButton getSpinButton() {
		return spinButton;
	}



	/**
	 * @param spinButton the spinButton to set
	 */
	public void setSpinButton(JButton spinButton) {
		this.spinButton = spinButton;
	}



	/**
	 * @return the stopButton
	 */
	public JButton getStopButton() {
		return stopButton;
	}



	/**
	 * @param stopButton the stopButton to set
	 */
	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}



	/**
	 * @return the image1
	 */
	public ImageIcon getImage1() {
		return image1;
	}



	/**
	 * @param image1 the image1 to set
	 */
	public void setImage1(ImageIcon image1) {
		this.image1 = image1;
	}



	/**
	 * @return the image2
	 */
	public ImageIcon getImage2() {
		return image2;
	}



	/**
	 * @param image2 the image2 to set
	 */
	public void setImage2(ImageIcon image2) {
		this.image2 = image2;
	}



	/**
	 * @return the image3
	 */
	public ImageIcon getImage3() {
		return image3;
	}



	/**
	 * @param image3 the image4 to set
	 */
	public void setImage3(ImageIcon image3) {
		this.image3 = image3;
	}
	
	
	
	/**
	 * @return the image4
	 */
	public ImageIcon getImage4() {
		return image4;
	}



	/**
	 * @param image3 the image4 to set
	 */
	public void setImage4(ImageIcon image4) {
		this.image4 = image4;
	}
	
	
	
	/**
	 * @return the image5
	 */
	public ImageIcon getImage5() {
		return image5;
	}



	/**
	 * @param image3 the image5 to set
	 */
	public void setImage5(ImageIcon image5) {
		this.image5 = image5;
	}



	/**
	 * @return the label1
	 */
	public JLabel getLabel1() {
		return label1;
	}



	/**
	 * @param label1 the label1 to set
	 */
	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}



	/**
	 * @return the label2
	 */
	public JLabel getLabel2() {
		return label2;
	}



	/**
	 * @param label2 the label2 to set
	 */
	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}



	/**
	 * @return the label3
	 */
	public JLabel getLabel3() {
		return label3;
	}

	

	/**
	 * @param label3 the label3 to set
	 */
	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}
	

	/**------------------
	 * Action Listeners
	 * ------------------
	 */
	
	/**
	 * Spin Button Listener
	 */
	protected class spinButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// if thread is already running - press spin button 2 times without pressing stop
			// stops thread and regenerates it
			if(t1.isAlive()) {
				t1.interrupt();
				t1 = new Thread(r1);
			}
			else {
			r1.setRunning(true);
			t1.start();
			}

		}
	}
		
	/**
	 * Stop Button Listener
	 */
	protected class stopButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			r1.setRunning(false);
			t1 = new Thread(r1);
			
		}
				
	}
	
	/**----------------------------
	 * Main Method
	 * ----------------------------
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//instantiate ImageIcons to use in SlotMachine instantiation
		ImageIcon apple = scaleImage(new ImageIcon("images/apple.png"));
		ImageIcon orange = scaleImage(new ImageIcon("images/orange.png"));
		ImageIcon seven= scaleImage(new ImageIcon("images/seven.png"));
		ImageIcon cherry = scaleImage(new ImageIcon("images/cherry.png"));
		ImageIcon diamond = scaleImage(new ImageIcon("images/diamond.png"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotMachine4 frame = new SlotMachine4(apple,orange,seven,cherry,diamond);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**-----------------------------------------
	 * Slot Machine constructor + creating GUI
	 * -----------------------------------------
	 */

	/**
	 * Create the frame.
	 */
	public SlotMachine4(ImageIcon image1, ImageIcon image2, ImageIcon image3, ImageIcon image4, ImageIcon image5) {
		
		// Set images
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		
		//GUI Details
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 450, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set to no layout
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/**----------------------------
		 * Title
		 * ----------------------------
		 */
		
		//Title
		titleLabel = new JLabel("Slot Machine");
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Kohinoor Devanagari", Font.BOLD, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(115, 6, 206, 39);
		contentPane.add(titleLabel);
		
		/**----------------------------
		 * Slots area
		 * Displays first, second, and third image given in SlotMachine parameter in each label respectively
		 * ----------------------------
		 */
		
		// label 1
		Border blackline = BorderFactory.createLineBorder(Color.black);
		label1 = new JLabel("");
		label1.setBorder(blackline);
		label1.setBounds(60, 88, 85, 85);
		//setting icon
		label1.setIcon(this.image1);
		contentPane.add(label1);
		
		//label 2
		label2 = new JLabel("");
		label2.setBounds(171, 88, 85, 85);
		label2.setBorder(blackline);
		//setting icon
		label2.setIcon(this.image2);
		contentPane.add(label2);
		
		//label 3
		label3 = new JLabel("");
		label3.setBounds(280, 88, 85, 85);
		label3.setBorder(blackline);
		//setting icon
		label3.setIcon(this.image3);
		contentPane.add(label3);
		
		/**----------------------------
		 * Buttons
		 * ----------------------------
		 */
		
		/**
		 * Spin Button
		 * Sets icons in label to random ImageIcon each 100 milliseconds
		 */
		ActionListener spinButtonListener = new spinButtonListener();
		JButton spinButton = new JButton("Spin");
		spinButton.setForeground(Color.BLUE);
		spinButton.setBounds(115, 204, 85, 30);
		//adding ActionListener
		spinButton.addActionListener(spinButtonListener);
		contentPane.add(spinButton);
		
		/**
		 * Stop Button
		 * Stop pinning/changing of ImageIcons
		 */
		ActionListener stopButtonListener = new stopButtonListener();
		JButton stopButton = new JButton("Stop");
		stopButton.setForeground(Color.BLUE);
		stopButton.setBounds(236, 204, 85, 30);
		//adding ActionListener
		stopButton.addActionListener(stopButtonListener);
		contentPane.add(stopButton);
			
	}
	
	/**--------------------------------------
	 * Slot Machine Runnable Class
	 * assigns random icons to each label
	 * --------------------------------------
	 */
	
 class SlotMachineRunnable implements Runnable{
	
	 // tells whether thread is running
	 private volatile boolean running;
	 
	 /* get running instance variable
	  * @return running  if thread is running
	  */
	 public boolean getRunning() {
		 return running;
	 }
	 
	 /* set the running instance variable
	  * @param running
	  */
	 public void setRunning(Boolean running) {
		 this.running = running;
	 }
		
		@Override
		public void run() {
			
			// create ArrayList to hold ImageIcons in
			ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
			images.add(getImage1());
			images.add(getImage2());
			images.add(getImage3());
			images.add(getImage4());
			images.add(getImage5());
			
			
			// runs while running = true
				while(running) {
					try {
						Thread.sleep(75); // 100 millisecond pause 
					}
					catch(InterruptedException e) {
						setRunning(false);
					}
					// generate random number between 0 and 2
					int random1 = (int)(Math.random()*images.size());
					int random2 = (int)(Math.random()*images.size());
					int random3 = (int)(Math.random()*images.size());
					//set icon for each label to random image in ArrayList
					getLabel1().setIcon(images.get(random1));
					getLabel2().setIcon(images.get(random2));
					getLabel3().setIcon(images.get(random3));
				}

		}
		}
	}
		
