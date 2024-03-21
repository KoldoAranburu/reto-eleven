package vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import controlador.GestorCaballeros;
import controlador.GestorUsuario;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;

public class IniciarJuegoGUI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IniciarJuegoGUI window = new IniciarJuegoGUI();
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
	public IniciarJuegoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static int i = 0;
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon("img/pantalla_inicio.jpg"); // Reemplaza "ruta/de/la/imagen/fondo.jpg" por la ruta de tu imagen
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(981, 507, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 981, 432);
        frame.getContentPane().add(background);
        
        JButton startBTN = new JButton("START");
        startBTN.setBounds(417, 286, 143, 32);
        frame.getContentPane().add(startBTN);
        startBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						JFrame frame;
						try {
							ElegirCabalero window = new ElegirCabalero();
							IniciarJuegoGUI.this.frame.setVisible(false);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
        JButton quitBTN = new JButton("SALIR");
        quitBTN.setBounds(417, 316, 143, 45);
        frame.getContentPane().add(quitBTN);
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
