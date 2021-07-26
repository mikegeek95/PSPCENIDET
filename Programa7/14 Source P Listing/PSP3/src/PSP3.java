import java.io.*;

public class PSP3 {

  public static void main(String []args){

    try (BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in))){

      String sFilePath = null;

      OrdenadorDeArchivo odaOrdenador = new OrdenadorDeArchivo();

      Correlacion coCalculador = new Correlacion();
 
      LectorDeArchivo ldaArchivo = new LectorDeArchivo();

      

        System.out.println("********************************************\nFavor de Ingresar el directorio del archivo con los datos a analizar\n********************************************");
        sFilePath = brInput.readLine();

        if(sFilePath.length()!=0){

          try (FileReader frFile = new FileReader(new File(sFilePath))){
        	  
        	  ldaArchivo.frArchivo=frFile;
        	  ldaArchivo.sNombreArchivo=sFilePath;
        	  ldaArchivo.odaOrdenador=odaOrdenador;
        	  ldaArchivo.coCalculador=coCalculador;
        	  ldaArchivo.cuentaCorrelacion();


            odaOrdenador.addArchivo(ldaArchivo);
          }
          catch(IOException e){
            System.out.println(e);
          }
        }
      

      coCalculador.printResultado();

    }catch(IOException e){
      System.out.println(e);
    }
  }
}