package vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controlador.GestorCaballeros;
import controlador.GestorEscuderos;
import controlador.GestorUsuario;
import modelo.Arma;
import modelo.Caballero;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ElegirCabalero {

	JFrame frame;
	private ArrayList<Caballero> caballeros;
	private JTextArea NOMBRE;
	private JTextArea FUERZA;
	private JTextArea experienciaTXT;
	private JLabel imagen_caballero;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ElegirCabalero window = new ElegirCabalero();
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
	public ElegirCabalero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static int i = 0;
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 255));
		frame.getContentPane().setFont(new Font("Yu Gothic Light", Font.BOLD, 34));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 947, 76);
		panel.setBackground(new Color(128, 0, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\Documents\\GitHub\\eh_garden\\Reto-Eleven2\\img\\chose.jpg"));
		lblNewLabel_1.setBounds(10, 11, 927, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("ELEGIR PERSONAJE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(302, 39, 210, 26);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(698, 47, 89, 23);
		panel.add(btnNewButton_3);
		
		JPanel panel_personaje = new JPanel();
		panel_personaje.setBackground(new Color(128, 0, 255));
		panel_personaje.setBounds(0, 75, 795, 332);
		frame.getContentPane().add(panel_personaje);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarAlAnterior();
			}

		});
		SpringLayout sl_panel_personaje = new SpringLayout();
		sl_panel_personaje.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, panel_personaje);
		panel_personaje.setLayout(sl_panel_personaje);
		panel_personaje.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarAlSiguiente();
			}
		});
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_panel_personaje.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, panel_personaje);
		sl_panel_personaje.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, panel_personaje);
		panel_personaje.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("IR AL CAMPO DE BATALLA");
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel_personaje.putConstraint(SpringLayout.WEST, btnNewButton_2, 293, SpringLayout.EAST, btnNewButton);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(i);
				ArrayList<Arma> armas = GestorUsuario.batallarGUI(caballeros.get(i),caballeros);
				GestorEscuderos.evolucionarEscudero(caballeros.get(i));
			}
		});
		panel_personaje.add(btnNewButton_2);
		
		imagen_caballero = new JLabel("Caballeros");
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, imagen_caballero, 0, SpringLayout.NORTH, panel_personaje);
		sl_panel_personaje.putConstraint(SpringLayout.SOUTH, imagen_caballero, -6, SpringLayout.NORTH, btnNewButton_2);
		sl_panel_personaje.putConstraint(SpringLayout.EAST, imagen_caballero, -48, SpringLayout.EAST, panel_personaje);
		
		panel_personaje.add(imagen_caballero);
		
		JLabel lblNewLabel_2 = new JLabel("ATRIBUTOS");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, panel_personaje);
		sl_panel_personaje.putConstraint(SpringLayout.WEST, imagen_caballero, 85, SpringLayout.EAST, lblNewLabel_2);
		sl_panel_personaje.putConstraint(SpringLayout.WEST, lblNewLabel_2, 27, SpringLayout.WEST, panel_personaje);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.BOLD, 24));
		panel_personaje.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 25, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_personaje.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 27, SpringLayout.WEST, panel_personaje);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		panel_personaje.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("EXPERIENCIA:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		sl_panel_personaje.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 27, SpringLayout.WEST, panel_personaje);
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		panel_personaje.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("FUERZA:");
		lblNewLabel_2_1_2.setForeground(new Color(255, 255, 255));
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 43, SpringLayout.SOUTH, lblNewLabel_2_1_2);
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2, 42, SpringLayout.SOUTH, lblNewLabel_2_1);
		sl_panel_personaje.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_2, 0, SpringLayout.EAST, lblNewLabel_2_1);
		lblNewLabel_2_1_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		panel_personaje.add(lblNewLabel_2_1_2);
		
		//crear un ArrayList
		caballeros = GestorCaballeros.getCaballeros();
		
		//crear la variable i max value arr.size


		//on click wue imprima el caballñero i y lo muestre enn pantalla
		
		
		//aqui renderiza los vakores
		NOMBRE = new JTextArea();
		sl_panel_personaje.putConstraint(SpringLayout.WEST, NOMBRE, -7, SpringLayout.EAST, lblNewLabel_2_1_1);
		sl_panel_personaje.putConstraint(SpringLayout.SOUTH, NOMBRE, 0, SpringLayout.SOUTH, lblNewLabel_2_1);
		sl_panel_personaje.putConstraint(SpringLayout.EAST, NOMBRE, -8, SpringLayout.WEST, imagen_caballero);
		NOMBRE.setBackground(new Color(128, 0, 255));
		NOMBRE.setForeground(new Color(255, 255, 255));
		NOMBRE.setFont(new Font("Old English Text MT", Font.PLAIN, 34));
		
		panel_personaje.add(NOMBRE);
		
		FUERZA = new JTextArea();
		sl_panel_personaje.putConstraint(SpringLayout.NORTH, FUERZA, -17, SpringLayout.NORTH, lblNewLabel_2_1_2);
		sl_panel_personaje.putConstraint(SpringLayout.WEST, FUERZA, 6, SpringLayout.EAST, lblNewLabel_2_1_2);
		FUERZA.setFont(new Font("Monospaced", Font.PLAIN, 30));
		FUERZA.setForeground(new Color(255, 255, 255));
		FUERZA.setBackground(new Color(128, 0, 255));
		
		panel_personaje.add(FUERZA);
		
		 experienciaTXT = new JTextArea();
		 sl_panel_personaje.putConstraint(SpringLayout.NORTH, experienciaTXT, -17, SpringLayout.NORTH, lblNewLabel_2_1_1);
		 sl_panel_personaje.putConstraint(SpringLayout.WEST, experienciaTXT, 13, SpringLayout.EAST, lblNewLabel_2_1_1);
		 experienciaTXT.setFont(new Font("Monospaced", Font.PLAIN, 30));
		 experienciaTXT.setForeground(new Color(255, 255, 255));
		 experienciaTXT.setBackground(new Color(128, 0, 255));
		
		panel_personaje.add(experienciaTXT);
		
		frame.setBounds(100, 100, 821, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void pasarAlSiguiente() {
		if (i>=caballeros.size()-1) {
			i=0;
		}else {
			i++;
		}
		imagen_caballero.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\Documents\\GitHub\\eh_garden\\Reto-Eleven2\\img\\" + i +".png"));
		NOMBRE.setText(caballeros.get(i).getNombre());
		FUERZA.setText(String.valueOf(caballeros.get(i).getFuerza()));
		experienciaTXT.setText(String.valueOf(caballeros.get(i).getExperiencia()));
		System.out.println(i);
	}
	private void pasarAlAnterior() {
		if (i<=0) {
			i=0;
		}else {
			i--;
		}
		imagen_caballero.setIcon(new ImageIcon("C:\\Users\\plaiaundi\\Documents\\GitHub\\eh_garden\\Reto-Eleven2\\img\\" + i +".png"));
		NOMBRE.setText(caballeros.get(i).getNombre());
		FUERZA.setText(String.valueOf(caballeros.get(i).getFuerza()));
		experienciaTXT.setText(String.valueOf(caballeros.get(i).getExperiencia()));
		System.out.println(i);
		
	}
}
