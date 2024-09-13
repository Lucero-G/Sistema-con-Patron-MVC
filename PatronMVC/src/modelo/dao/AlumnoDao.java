package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Coordinador;

import modelo.conexion.Conexion;
import modelo.vo.AlumnoVo;




/**
 * Clase que permite el acceso a la base de datos
 * @author chenao
 *
 */
public class AlumnoDao
{

	public void registrarAlumno(AlumnoVo miAlumno)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO alumno VALUES ('"+miAlumno.getCodAlumno()+"', '"
					+miAlumno.getNombreAlumno()+"', '"+miAlumno.getEdadAlumno()+"', '"
					+miAlumno.getEscuelaAlumno()+"', '"+miAlumno.getTelefonoAlumno()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public AlumnoVo buscarAlumno(int codigo) 
	{
		Conexion conex= new Conexion();
		AlumnoVo persona= new AlumnoVo();
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM alumno where codigo = ? ");
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				persona.setCodAlumno(Integer.parseInt(res.getString("codigo")));
				persona.setNombreAlumno(res.getString("nombre"));
				persona.setEdadAlumno(Integer.parseInt(res.getString("edad")));
				persona.setEscuelaAlumno(res.getString("escuela"));
				persona.setTelefonoAlumno(Integer.parseInt(res.getString("telefono")));
			 }
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return persona;
			}
			else return null;				
	}

	public void modificarAlumno(AlumnoVo miAlumno) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE alumno SET codigo= ? ,nombre = ? , edad=? , escuela=? , telefono= ? WHERE codigo= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miAlumno.getCodAlumno());
            estatuto.setString(2, miAlumno.getNombreAlumno());
            estatuto.setInt(3, miAlumno.getEdadAlumno());
            estatuto.setString(4, miAlumno.getEscuelaAlumno());
            estatuto.setInt(5,miAlumno.getTelefonoAlumno());
            estatuto.setInt(6, miAlumno.getCodAlumno());
            estatuto.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarAlumno(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM alumno WHERE codigo='"+codigo+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
