/**
 * LectorDeArchivo
 *
 * Clase que lee la cantidad de lineas en blanco y la cantidad de lineas de información de un archivo
 * al igual que su nombre. En la version se le agrego la funcionalidad de contar líneas de código y
 * asociar el OrdenadorDeArchivo asignado a el programa, al igual utiliza los regexes para definir
 * como se suman las líneas. Ahora se le agregó la funcionalidad de detectar parejas ordenadas de
 * números para poder calcular factores de correlacion
 *
 * @author Iker Arbulu Lozano   A01190690
 * @date 29/02/2016
 * @version 3.0
 */

//&p-LectorDeArchivo
//&b=110
import java.io.*;
import java.util.regex.*;

public class LectorDeArchivo{
  FileReader frArchivo;
  int iCantLineasBlanco;
  int iCantLineasInfo;
  String sNombreArchivo;

  OrdenadorDeArchivo odaOrdenador;

  Correlacion coCalculador;

	void cuentaCorrelacion(){
		
	  iCantLineasInfo = 0;
	  iCantLineasBlanco = 0;

	  BufferedReader brLector = null;

	  try{

	    brLector = new BufferedReader(this.frArchivo);

	    String sCurrentLine;

	    if((sCurrentLine = brLector.readLine()) != null){
	    	if(Pattern.matches("\\d+(\\.\\d+)?", sCurrentLine)){
          if (Float.parseFloat(sCurrentLine.trim()) >= 0){
            coCalculador.fxk=(Float.parseFloat(sCurrentLine.trim()));
          }
          else{
            System.out.println("Error en la entrada");
          }
	    	}
	    	else{
	    		System.out.println("Error en la entrada");
	    		System.exit(0);
	    	}
	    }

	    while ((sCurrentLine = brLector.readLine()) != null) {

	        if(Pattern.matches("\\d+(\\.\\d+)?,\\d+(\\.\\d+)?",sCurrentLine)){
            if(Float.parseFloat(sCurrentLine.substring(0,sCurrentLine.indexOf(",")).trim())>=0 && Float.parseFloat(sCurrentLine.substring(sCurrentLine.indexOf(",")+1).trim())>=0){
	        	  coCalculador.pareja(Float.parseFloat(sCurrentLine.substring(0,sCurrentLine.indexOf(",")).trim()),Float.parseFloat(sCurrentLine.substring(sCurrentLine.indexOf(",")+1).trim()));
            }
            else{
              System.out.println("Error en la entrada");
            }
	        }
	        else{
	        	System.out.println("Error en la entrada");
	    		System.exit(0);
	        }
	    }

	  }
	  catch(IOException e){
	    System.out.println(e);
	  }

	  finally{

	    try{
	      if (brLector!=null){
	        brLector.close();
	      }
	    }

	    catch(IOException ex){
	      System.out.println(ex);
	    }
	  }

	}
}