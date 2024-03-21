package vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controlador.GestorCaballeros;
import modelo.Arma;
import modelo.Caballero;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GanadorGUI {

	public static JFrame frame;
	private static JTextField textField;
	private static JTextArea txtrJajaj;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GanadorGUI window = new GanadorGUI();
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
//	public GanadorGUI() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 * @param armas 
	 * @param caballeroPJ1 
	 * @wbp.parser.entryPoint
	 */
	private static void initialize(ArrayList<Arma> armas, Caballero caballeroPJ1) {
		frame = new JFrame();
		
		 
		ImageIcon icon = new ImageIcon("img/pantalla_inicio2.jpg"); 
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(981, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        SpringLayout springLayout = new SpringLayout();
        frame.getContentPane().setLayout(springLayout);
        
        JLabel background = new JLabel(scaledIcon);
        springLayout.putConstraint(SpringLayout.NORTH, background, 0, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, background, 0, SpringLayout.WEST, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, background, 432, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, background, 654, SpringLayout.WEST, frame.getContentPane());
        frame.getContentPane().add(background);
        
        JButton quitBTN = new JButton("SALIR");
        springLayout.putConstraint(SpringLayout.NORTH, quitBTN, 316, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, quitBTN, 417, SpringLayout.WEST, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, quitBTN, 361, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, quitBTN, 560, SpringLayout.WEST, frame.getContentPane());
        frame.getContentPane().add(quitBTN);
        quitBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 255));
        springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, panel, 651, SpringLayout.WEST, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, panel, 432, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, panel, 947, SpringLayout.WEST, frame.getContentPane());
        frame.getContentPane().add(panel);
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        
        JButton btnNewButton = new JButton("RECOGER RECOMPENSA");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				int id_arma = Integer.parseInt(textField.getText());
				caballeroPJ1.setId_arma(id_arma);
				GestorCaballeros.actualizarCaballero(caballeroPJ1);
				txtrJajaj.setText("Loot Recogido!");
        	}
        });
        sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -37, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -50, SpringLayout.EAST, panel);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("LOOT DEL RIVAL");
        sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 66, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 28, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 107, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, panel);
        lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 23));
        panel.add(lblNewLabel);
        
        JLabel idArma = new JLabel("Escoja el ID del Arma Deseada");
        sl_panel.putConstraint(SpringLayout.WEST, idArma, -50, SpringLayout.WEST, btnNewButton);
        sl_panel.putConstraint(SpringLayout.EAST, idArma, 0, SpringLayout.EAST, lblNewLabel);
        idArma.setFont(new Font("Palatino Linotype", Font.PLAIN, 16));
        panel.add(idArma);
        
        textField = new JTextField();
        sl_panel.putConstraint(SpringLayout.SOUTH, idArma, -6, SpringLayout.NORTH, textField);
        sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, btnNewButton);
        sl_panel.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, btnNewButton);
        sl_panel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnNewButton);
        panel.add(textField);
        textField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        sl_panel.putConstraint(SpringLayout.NORTH, idArma, 6, SpringLayout.SOUTH, scrollPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblNewLabel);
        sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblNewLabel);
        sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 187, SpringLayout.SOUTH, lblNewLabel);
        sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, lblNewLabel);
        panel.add(scrollPane);
        
        txtrJajaj = new JTextArea();
        txtrJajaj.setFont(new Font("Malgun Gothic Semilight", Font.ITALIC, 14));
        for (Arma arma : armas) {
        	txtrJajaj.append(arma + "\n \n");
		}
        scrollPane.setViewportView(txtrJajaj);
        
        
        JLabel lblHasGanado = new JLabel("HAS GANADO");
        sl_panel.putConstraint(SpringLayout.SOUTH, lblHasGanado, -14, SpringLayout.NORTH, lblNewLabel);
        sl_panel.putConstraint(SpringLayout.EAST, lblHasGanado, -30, SpringLayout.EAST, panel);
        lblHasGanado.setFont(new Font("Snap ITC", Font.BOLD, 23));
        panel.add(lblHasGanado);
		frame.setBounds(100, 100, 963, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void mostarLoot(Caballero caballeroPJ1, ArrayList<Arma> armas) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GanadorGUI window = new GanadorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize(armas,caballeroPJ1);
	}
}
