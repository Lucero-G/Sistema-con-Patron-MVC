package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Logica;
import modelo.vo.AlumnoVo;

import controlador.Coordinador;

public class VentanaBuscar  extends JFrame implements ActionListener {

	private Coordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textEdad,textTelefono,textProfesion;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
        public VentanaBuscar() {

        // Color background de la ventana
        this.getContentPane().setBackground(new Color(224, 247, 250)); // Azul hielo

        // Botón Guardar con color azul oscuro y texto blanco
        botonGuardar = new JButton();
        botonGuardar.setBounds(50, 220, 120, 25);
        botonGuardar.setText("Guardar");
        botonGuardar.setBackground(new Color(0, 123, 255)); // Azul oscuro
        botonGuardar.setForeground(Color.WHITE); // Texto blanco

        // Botón Cancelar
        botonCancelar = new JButton();
        botonCancelar.setBounds(190, 250, 120, 25);
        botonCancelar.setText("Cancelar");
        botonCancelar.setBackground(new Color(0, 123, 255)); // Azul oscuro
        botonCancelar.setForeground(Color.WHITE); // Texto blanco

        // Botón Buscar
        botonBuscar = new JButton();
        botonBuscar.setBounds(170, 80, 50, 25);
        botonBuscar.setText("Ok");
        botonBuscar.setBackground(new Color(0, 123, 255)); // Azul oscuro
        botonBuscar.setForeground(Color.WHITE); // Texto blanco

        // Botón Eliminar
        botonEliminar = new JButton();
        botonEliminar.setBounds(330, 220, 120, 25);
        botonEliminar.setText("Eliminar");
        botonEliminar.setBackground(new Color(220, 53, 69)); // Rojo oscuro para eliminar
        botonEliminar.setForeground(Color.WHITE); // Texto blanco

        // Botón Modificar
        botonModificar = new JButton();
        botonModificar.setBounds(190, 220, 120, 25);
        botonModificar.setText("Modificar");
        botonModificar.setBackground(new Color(0, 123, 255)); // Azul oscuro
        botonModificar.setForeground(Color.WHITE); // Texto blanco

        // Título con fuente y color
        labelTitulo = new JLabel();
        labelTitulo.setText("ADMINISTRAR ALUMNOS");
        labelTitulo.setBounds(120, 20, 380, 30);
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
        labelTitulo.setForeground(new Color(33, 37, 41)); // Gris oscuro

        // Etiquetas (Labels)
        cod = new JLabel();
        cod.setText("Codigo");
        cod.setBounds(20, 80, 80, 25);
        cod.setForeground(new Color(33, 37, 41)); // Gris oscuro
        add(cod);

        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(20, 120, 80, 25);
        nombre.setForeground(new Color(33, 37, 41)); // Gris oscuro
        add(nombre);

        telefono = new JLabel();
        telefono.setText("Telefono");
        telefono.setBounds(290, 160, 80, 25);
        telefono.setForeground(new Color(33, 37, 41)); // Gris oscuro
        add(telefono);

        profesion = new JLabel();
        profesion.setText("Escuela");
        profesion.setBounds(20, 160, 80, 25);
        profesion.setForeground(new Color(33, 37, 41)); // Gris oscuro
        add(profesion);

        edad = new JLabel();
        edad.setText("Edad");
        edad.setBounds(290, 120, 80, 25);
        edad.setForeground(new Color(33, 37, 41)); // Gris oscuro
        add(edad);

        // Campos de texto
        textCod = new JTextField();
        textCod.setBounds(80, 80, 80, 25);
        add(textCod);

        textNombre = new JTextField();
        textNombre.setBounds(80, 120, 190, 25);
        add(textNombre);

        textTelefono = new JTextField();
        textTelefono.setBounds(340, 160, 80, 25);
        add(textTelefono);

        textProfesion = new JTextField();
        textProfesion.setBounds(80, 160, 190, 25);
        add(textProfesion);

        textEdad = new JTextField();
        textEdad.setBounds(340, 120, 80, 25);
        add(textEdad);

        // Agregar listeners a los botones
        botonModificar.addActionListener(this);
        botonEliminar.addActionListener(this);
        botonBuscar.addActionListener(this);
        botonGuardar.addActionListener(this);
        botonCancelar.addActionListener(this);

        add(botonCancelar);
        add(botonBuscar);
        add(botonModificar);
        add(botonEliminar);
        add(botonGuardar);
        add(labelTitulo);
        limpiar();

        setSize(480, 320);
        setTitle("Sistema MVC para Administrar Alumnos");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
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

				miCoordinador.modificarPersona(miPersona);
				
				if (Logica.modificaAlumno==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			AlumnoVo miPersona=miCoordinador.buscarPersona(textCod.getText());
			if (miPersona!=null)
			{
				muestraPersona(miPersona);
			}
			else if(Logica.consultaAlumno==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCod.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"�Esta seguro de eliminar la Persona?", "Confirmaci�n",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					miCoordinador.eliminarPersona(textCod.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Informaci�n",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraPersona(AlumnoVo miPersona) {
		textNombre.setText(miPersona.getNombreAlumno());
		textEdad.setText(miPersona.getEdadAlumno()+"");
		textTelefono.setText(miPersona.getTelefonoAlumno()+"");
		textProfesion.setText(miPersona.getEscuelaAlumno());
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param edad
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean edad, boolean tel, boolean profesion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textEdad.setEditable(edad);
		textTelefono.setEditable(tel);
		textProfesion.setEditable(profesion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
