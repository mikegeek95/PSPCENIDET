import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class MAIN {
	
	public static void main(String[] args) {
		try {
			
			System.out.println("IMPORTANTE: coloque todas los archivos(.java) que componen el programa en un mismo directorio.");
			System.out.println("Si se va a analizar mas de un programa completo, dividelo por carpetas.");
			System.out.print("Ahora escriba la ruta a ese directorio (ej. c:/programa/): ");
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String ruta = br.readLine();
						
			
			File directorio = new File(ruta);
			
			
			BuscarArchivos(directorio,ruta);

			
		}
		catch(final Exception e){
			e.printStackTrace();
			System.out.println("exception");
		}
	}
	//
	public static void BuscarArchivos(File ruta,String fichero) {
		LOC L = new LOC();
		boolean archivo = ruta.isDirectory();
		if(archivo) {
			
			String []directorio= ruta.list();
			if(ruta.canRead()) {
				for(int m=0;m<directorio.length;m++) {
					
					System.out.println("programa "+(m+1));
					System.out.println(fichero+"/"+directorio[m]);
					int tamañoPrograma = L.ContadorLineasLOC(L.validarRuta(fichero+"/"+directorio[m]));
					System.out.println("\nTamaño total del programa numero "+m+1+": "+tamañoPrograma);
					
				}
			}
			
		}

	}
}
