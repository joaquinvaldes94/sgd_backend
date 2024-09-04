package cl.nescorp.provider.aplication.util;

public class Rut {
	
	

	public  static String obtenerRutFormatoByNumbero(String rut) throws Exception{
		
	if(null == rut || rut.length() < 7 	|| rut.length() > 8 ) {
		throw new Exception("No es posible obtener el dv del rut"); 
	}

	    /*la logica para calcular el numero verificador de las cedulas de identidad de chile

        esta dada por la siguiente secuencia (rut prueba 18965316)



	     * multiplicar cada digito por los siguientes valores de forma correlativa.

           - 3 2 7 6 5 4 3 2

	     * * * * * * * *

             1 8 9 6 5 3 1 6



	     * se suman los resultados de cada multiplicacion*

	     * de la suma se extrae el resto

	     * a la contante 11 le sustraimos el resto danto el numero verificador*/



	    char letra = ' ';//almacen temporal de las letras

	    int conversion = 0;//almacen que guarda la transf. char/int

	    int multiplicativos[] = {3,2,7,6,5,4,3,2};//numeros multiplicativos

	    int resSuma[] = new int[1];//almacena la suma en una variable

	    int resto = 0;//guarda el resultado del resto

	    char digitos[] = new char[9];//guarda cada digito del rut en una posicion


    

	    String entrada = rut;//extrae los datos ingresados como String



	    for (int i =0; i<entrada.length();i++){//recorre lo ingresado hasta su tamaño

	    	letra = entrada.charAt(i);//extrae el digito y lo almacena el letra temporalmente

	    	digitos[i] = letra;//guarda el digito extraido desde entrada

	    	String cad = ""+digitos[i];//el digito capturado lo convierte a string

	    	conversion = Integer.parseInt(cad);//el String con un digito lo convierte a int

	    	resSuma[0] = resSuma[0]+conversion*multiplicativos[i];//hace la multiplicacion

	    }



	    resto = resSuma[0]%11;//extrae el resto de la suma

	    Integer digito = (11 - resto);//calcula numero verificador
	    
	    String dv= digito.toString();
	    
	    if (dv.equals("11")) {
	    	dv = "0";
	    	}

	    	if (dv.equals("10")) {
	    		dv = "K";
	    	}


	   return(entrada+"-"+dv);


    }

	public static boolean validarRutCompleto(String rut) {

	    boolean validacion = false;
	    try {
	        rut =  rut.toUpperCase();
	        rut = rut.replace(".", "");
	        rut = rut.replace("-", "");
	        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

	        char dv = rut.charAt(rut.length() - 1);

	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	            validacion = true;
	        }

	    } catch (java.lang.NumberFormatException e) {
	    } catch (Exception e) {
	    }
	    return validacion;
	}

	public static Integer limpiarRut(String rut) {
		
		 rut =  rut.toUpperCase();
	     rut = rut.replace(".", "");
	     rut = rut.replace("-", "");
	     return Integer.parseInt(rut.substring(0, rut.length() - 1));
		
	}
	
	public static String formatearRut(String rut) {
	
		    int cont = 0;
		    String format=null;
		    rut = rut.replace(".", "");
		    rut = rut.replace("-", "");
		    format = "-" + rut.substring(rut.length() - 1);
		    for (int i = rut.length() - 2; i >= 0; i--) {
		        format = rut.substring(i, i + 1) + format;
		        cont++;
		        if (cont == 3 && i != 0) {
		            format = "." + format;
		            cont = 0;
		        }
		    }
		


		    return format;
	}
	

}
