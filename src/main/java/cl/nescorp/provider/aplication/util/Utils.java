package cl.nescorp.provider.aplication.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Utils {
	
	public static String findFirstName(String nombreCompleto) {
	
	String[] primerNombre=nombreCompleto.split("\\s+");
	
	
	
	return nombreCompleto;
		
	}
	
	public static String findNombreMes(LocalDateTime date) {
		
		Month mes = date.getMonth();

		 String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		 String primeraLetra = nombreMes.substring(0,1);
		 String mayuscula = primeraLetra.toUpperCase();
		 String demasLetras = nombreMes.substring(1, nombreMes.length());
		 nombreMes = mayuscula + demasLetras;
		 return nombreMes;
	}
	
	public static LocalDateTime findDateTimeNow() {
		Instant nowUtc = Instant.now();
		ZoneId zoneId = ZoneId.of("America/Santiago");
		ZonedDateTime now = ZonedDateTime.ofInstant(nowUtc, zoneId);
		return now.toLocalDateTime();
	}
	
	
	public static String escribirFecha(LocalDateTime dateTime) {
		Month mes = dateTime.getMonth();
		String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		return dateTime.getDayOfMonth()+"/"+nombreMes+"/"+dateTime.getYear();
	}
	
	
	public static String limpiarHtml(String codeHtml) {
		
		//primero reemplazar las etiquetas <h a <p
		codeHtml=codeHtml.replaceAll("<h1", "<p");
		codeHtml=codeHtml.replaceAll("</h1>", "</p>");
		
		codeHtml=codeHtml.replaceAll("<h2", "<p");
		codeHtml=codeHtml.replaceAll("</h2>", "</p>");
		
		codeHtml=codeHtml.replaceAll("<h3", "<p");
		codeHtml=codeHtml.replaceAll("</h3>", "</p>");
		
		codeHtml=codeHtml.replaceAll("<h4", "<p");
		codeHtml=codeHtml.replaceAll("</h4>", "</p>");
		
		codeHtml=codeHtml.replaceAll("<h5", "<p");
		codeHtml=codeHtml.replaceAll("</h5>", "</p>");
		
		codeHtml=codeHtml.replaceAll("<h6", "<p");
		codeHtml=codeHtml.replaceAll("</h6>", "</p>");
		
		if(codeHtml.startsWith("<link") || codeHtml.startsWith("<style>")) { // si comienza en link o style comenzar a contar el contenido a partir del primer <p
			
			Integer firstP=codeHtml.indexOf("<p");
				
			codeHtml=codeHtml.substring(firstP, codeHtml.length());
			
		}
		
		codeHtml=codeHtml.replaceAll("style=", "id=");//quitar los estilos y transformarlos en id
		
		codeHtml=codeHtml.replaceAll("</br>", "<br />"); //posible error de br 
		codeHtml=codeHtml.replaceAll("<br>", "<br />"); //posible error de br 
		
		return codeHtml;
		
	}
	
}
