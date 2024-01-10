package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	private JFrame frame = this;
	private JPanel contentPane;
	private JLabel titulo;
	private JButton boton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Reserva de trayectos");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setBounds(90, 52, 288, 82);
		contentPane.add(titulo);
		
		boton = new JButton("Acceder a la app");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio inicio = new Inicio();
				inicio.setSize(1000, 600);
				inicio.setLocation(0, 0);
				inicio.setVisible(true);
				
				boton.setVisible(false); 
				titulo.setVisible(false);
				
				contentPane.add(inicio);
				
				contentPane.paint(getGraphics());
			}
		});
		boton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton.setBounds(118, 175, 180, 34);
		contentPane.add(boton);
	}

}
