package frgp.utn.edu.ar.utiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String Q_CLIENTE_BY_DNI="from ECliente where dni=?";
	public static String Q_BIBLIOTECA_ARRAY = "from EBiblioteca AS BLIO inner join BLIO.libro where estado = 'En biblioteca' ";
	public static String Q_BIBLIOTECA_BY_IDLIBRO = "FROM EBiblioteca WHERE id_libro =? AND estado = 'En biblioteca'";
	
	public static Date convertStringToDate(String fecha) throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.parse(fecha);
	}
	
}
