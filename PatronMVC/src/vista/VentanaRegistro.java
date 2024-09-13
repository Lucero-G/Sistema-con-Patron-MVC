package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.vo.AlumnoVo;

import controlador.Coordinador;


public class VentanaRegistro extends JFrame implements ActionListener{

	private Coordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textEdad,textTelefono,textProfesion;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

                this.getContentPane().setBackground(new Color(224, 247, 250)); // Azul hielo

                botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
                botonGuardar.setBackground(new Color(0, 123, 255)); // Azul oscuro
                botonGuardar.setForeground(Color.WHITE); // Texto blanco
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");
                botonCancelar.setBackground(new Color(0, 123, 255)); // Azul oscuro
                botonCancelar.setForeground(Color.WHITE); // Texto blanco

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ALUMNOS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
                labelTitulo.setForeground(new Color(33, 37, 41)); // Gris oscuro

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
                cod.setForeground(new Color(33, 37, 41)); // Gris oscuro
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
                nombre.setForeground(new Color(33, 37, 41)); // Gris oscuro
		add(nombre);

		telefono=new JLabel();
		telefono.setText("Telefono");
		telefono.setBounds(290, 160, 80, 25);
                telefono.setForeground(new Color(33, 37, 41)); // Gris oscuro
		add(telefono);
		
		edad=new JLabel();
		edad.setText("Edad");
		edad.setBounds(290, 120, 80, 25);
                edad.setForeground(new Color(33, 37, 41)); // Gris oscuro
		add(edad);
		
		profesion=new JLabel();
		profesion.setText("Escuela");
		profesion.setBounds(20, 160, 80, 25);
                profesion.setForeground(new Color(33, 37, 41)); // Gris oscuro
		add(profesion);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);

		textTelefono=new JTextField();
		textTelefono.setBounds(340, 160, 80, 25);
		add(textTelefono);
		
		textEdad=new JTextField();
		textEdad.setBounds(340, 120, 80, 25);
		add(textEdad);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 160, 190, 25);
		add(textProfesion);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		add(botonCancelar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Sistema MVC para Administrar Alumnos");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	private void limpiar() 
	{
		textCod.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				AlumnoVo miPersona=new AlumnoVo();
				miPersona.setCodAlumno(Integer.parseInt(textCod.getText()));
				miPersona.setNombreAlumno(textNombre.getText());
				miPersona.setTelefonoAlumno(Integer.parseInt(textTelefono.getText()));
				miPersona.setEdadAlumno(Integer.parseInt(textEdad.getText()));
				miPersona.setEscuelaAlumno(textProfesion.getText());
				
				miCoordinador.registrarPersona(miPersona);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
