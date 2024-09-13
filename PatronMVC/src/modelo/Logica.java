package modelo;

import javax.swing.JOptionPane;

import modelo.dao.AlumnoDao;
import modelo.vo.AlumnoVo;
import controlador.Coordinador;

public class Logica {
	
	private Coordinador miCoordinador;
	public static boolean consultaAlumno=false;
	public static boolean modificaAlumno=false;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

	public void validarRegistro(AlumnoVo miAlumno) {
		AlumnoDao miAlumnoDao;
		if (String.valueOf(miAlumno.getCodAlumno()).length() == 8) {
			miAlumnoDao = new AlumnoDao();
			miAlumnoDao.registrarAlumno(miAlumno);						
		}else {
			JOptionPane.showMessageDialog(null,"El codigo del alumno debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

	public AlumnoVo validarConsulta(String codigoAlumno) {
		AlumnoDao miAlumnoDao;
		
		try {	
			if (codigoAlumno.length() == 8) {
                                int codigo=Integer.parseInt(codigoAlumno);
				miAlumnoDao = new AlumnoDao();
				consultaAlumno=true;
				return miAlumnoDao.buscarAlumno(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El codigo del alumno debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaAlumno=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaAlumno=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaAlumno=false;
		}
					
		return null;
	}

	public void validarModificacion(AlumnoVo miAlumno) {
		AlumnoDao miAlumnoDao;
		if (miAlumno.getNombreAlumno().length()>3) {
			miAlumnoDao = new AlumnoDao();
			miAlumnoDao.modificarAlumno(miAlumno);	
			modificaAlumno=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaAlumno=false;
		}
	}

	public void validarEliminacion(String codigo) {
		AlumnoDao miAlumnoDao=new AlumnoDao();
		miAlumnoDao.eliminarAlumno(codigo);
	}



}
