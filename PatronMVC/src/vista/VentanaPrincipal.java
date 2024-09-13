package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private Coordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonRegistrar,botonBuscar;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.getContentPane().setBackground(new Color(224, 247, 250)); // Azul hielo

		botonRegistrar = new JButton();
		botonRegistrar.setBounds(100, 280, 120, 25);
		botonRegistrar.setText("Registrar");
                botonRegistrar.setBackground(new Color(0, 123, 255)); // Azul oscuro
                botonRegistrar.setForeground(Color.WHITE); // Texto blanco
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(240, 280, 120, 25);
		botonBuscar.setText("Buscar");
                botonBuscar.setBackground(new Color(0, 123, 255)); // Azul oscuro
                botonBuscar.setForeground(Color.WHITE); // Texto blanco

		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));
                labelTitulo.setForeground(new Color(33, 37, 41)); // Gris oscuro

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(75, 240, 250, 25);
                labelSeleccion.setForeground(new Color(33, 37, 41)); // Gris oscuro

		textoIntroduccion = "Esta aplicación es una version de un ejemplo práctico del patron "
				+ "MVC obtenido de internet.\n\n"
				+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Alumnos." +
				"tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(50, 90, 380, 140);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonRegistrar.addActionListener(this);
		botonBuscar.addActionListener(this);
		add(botonBuscar);
		add(botonRegistrar);
		add(labelSeleccion);
		add(labelTitulo);
		add(areaIntroduccion);
	
		setSize(480, 350);
		setTitle("Sistema MVC para Administrar Alumnos");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			miCoordinador.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			miCoordinador.mostrarVentanaConsulta();			
		}
	}
}
