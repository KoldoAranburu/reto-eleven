package vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class GameOver {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GameOver window = new GameOver();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public GameOver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 0, 128));
		frame.getContentPane().setForeground(new Color(64, 0, 128));
		frame.getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon("C:\\Users\\plaiaundi\\Documents\\GitHub\\eh_garden\\Reto-Eleven2\\img\\pantalla_inicio3.jpg"); 
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(981, 507, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 80, 981, 352);
        frame.getContentPane().add(background);

 
        JButton quitBTN = new JButton("SALIR");
        quitBTN.setBounds(417, 316, 143, 45);
        frame.getContentPane().add(quitBTN);
        
        JLabel lblNewLabel = new JLabel("Has perdido de manera alucinante ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(111, 11, 731, 73);
        frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 963, 471);
		quitBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
