import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOC {
	
	int tamañoPrograma=0;
	static String[] tipos = {"main","void","String","int","float","boolean", "byte","short","long","char"};
	int apertura=0;
	int cierre=0;
	int lineasmetodos=0;
	
	
	public String validarRuta(String ruta) {
		boolean rutaCorrecta = ruta.endsWith("/");
		if (rutaCorrecta) {
			return ruta;
		}
		else {
			ruta=ruta+"/";
			return ruta;
		}
	}

	public boolean reglas(String linea) {
		boolean comentario1 = linea.startsWith("/*");
		boolean comentario2 = linea.startsWith("//");
		boolean comentario3 = linea.startsWith("*/");
		boolean lineaVacia = (linea.length() == 0);
		
		if(!(comentario1 || comentario2 || comentario3 || lineaVacia)) {
			return true;
		}
		else {
			return false;
			}
		}
	
	public int ContadorLineasLOC(String ruta) {
		File directorio = new File(ruta);
		String [] archivos = directorio.list();
		int cantidadArchivos = archivos.length;
		
		for(int i=0; i < cantidadArchivos; i++) {
			try {
				int contadorLineas = 0;
				int lineasvacias = 0;
				int contadorMetodos = 0;
				boolean idemet=false;

				
				FileReader fr = new FileReader(ruta + archivos[i]);
				BufferedReader br = new BufferedReader(fr);
				
				String linea = br.readLine();
				
				System.out.println("\nNombre de Clase: " + archivos[i]);
				
				while(linea != null) {
					linea = linea.trim();
					
					if (reglas(linea)) {
						contadorLineas++;
					}
					else {
						lineasvacias++;
					}
					idemet=identificarMetodos(linea);
					if(idemet) {
						contadorMetodos++;
						System.out.println();
						System.out.println("Item numero: "+contadorMetodos);
						datosMetodos(linea);
						
					}
					lienasmetodos(idemet,linea,contadorLineas,contadorMetodos);
					linea = br.readLine();
				}
				System.out.println();
				System.out.println("Total  de Items: "+contadorMetodos);
				System.out.println("Lineas vacias: "+lineasvacias);
				System.out.println("Lineas de Codigo: "+contadorLineas);

				tamañoPrograma = tamañoPrograma + contadorLineas;
				br.close();
			}catch (IOException e) {
		        e.printStackTrace();
		        System.out.println("exception");
		    }
		}
		
		return tamañoPrograma;
	}
	
	public boolean identificarMetodos(String linea) {
		Pattern patron = Pattern.compile("^((public|private)?( )?(static)?( )?\\w+ \\w+\\()");
		Matcher matcher = patron.matcher(linea);
		boolean metodo = matcher.find(); 
		return metodo;
	}

	public void datosMetodos(String linea) {
		int m;
		boolean rest=false;
		String encontrados="";
		String nombresitems="";
    	for(m=0;m<tipos.length;m++) {
    	boolean resultado = linea.contains(tipos[m]);
    	
    	if(resultado) {
    		encontrados= tipos[m];
    		if(tipos[m].equals("main"))
    			System.out.println("");
    		}
    	}
    	
    	String[] parts = linea.split(" ");
    	
    	for(m=0;m<tipos.length;m++) {
        	if(parts[2].equals(tipos[m])) {
        		rest=true;
        	}
        	
    	}
    	if(parts[2].equals("void") && (parts[3].equals("main(String") || parts[3].equals("main("))) {
    		nombresitems= "main()";
    	}else if(rest) {
    		if(parts[3].endsWith(")")) {
    			nombresitems= parts[3];
    		}
    		else {
    			nombresitems= parts[3]+" "+parts[4];
    		}
    	}
    	else {
    		
    		if(parts[2].endsWith(")")) {
    			nombresitems= parts[2];
    		}
    		else {
    			nombresitems= parts[2]+" "+parts[3];
    		}
    	}
    	
    	System.out.println("Nombre de Item: "+nombresitems);
    	System.out.println("Tipo  de Item: "+encontrados);
    	
    	 
	}
	
	public void lienasmetodos(boolean identificador, String linea,int NumLinea, int NumMetodo) {

		if(identificador) {
			lineasmetodos=NumLinea;
			cierre=0;
			if(linea.endsWith("{")){
				apertura=1;
			}
			else {
				apertura=0;
			}
		}
		
		if(!identificador && NumMetodo!=0) {
			if(linea.endsWith("{")) {
				apertura++;
			}
			if(linea.endsWith("}")){
				cierre++;
			}
	
			if(apertura==cierre){
				
				lineasmetodos=(NumLinea-lineasmetodos)+1;
				System.out.println("lineas de Item: "+lineasmetodos);
				lineasmetodos=0;
				cierre=1;
				apertura=0;
			}
		}
		
	}
}
