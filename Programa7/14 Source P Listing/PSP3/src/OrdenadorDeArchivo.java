import java.util.*;
import java.io.*;

public class OrdenadorDeArchivo{
  LinkedList<LectorDeArchivo> ldaLinkListArchivos;
  LinkedList<Parte> ptLinkListPartes;
  int iCantLineasTotales;


  public OrdenadorDeArchivo(){
    ldaLinkListArchivos = new LinkedList<LectorDeArchivo>();
    ptLinkListPartes = new LinkedList<Parte>();
    iCantLineasTotales = 0;
  }


  public void addArchivo(LectorDeArchivo ldaArchivo){

    boolean mayor = true;

    if(ldaLinkListArchivos.size()==0){
      ldaLinkListArchivos.add(ldaArchivo);
    }
    else{
      for(int i = 0; i<ldaLinkListArchivos.size();i++){

        if(ldaArchivo.iCantLineasInfo < ldaLinkListArchivos.get(i).iCantLineasInfo){

          ldaLinkListArchivos.add(i,ldaArchivo);
          mayor = false;
          break;
        }
      }
      if(mayor){
        ldaLinkListArchivos.add(ldaArchivo);
      }
    }
  }


  public void addParte(Parte ptParte ){

    ptLinkListPartes.add(ptParte);
  }


  public void agregaLDCTotales(){
    iCantLineasTotales++;
  }


  public void printList(){

    int iCantTotalLineasInfo = 0;
    int iCantTotalLineasBlanco = 0;


    for (int i = 0;i<ldaLinkListArchivos.size() ;i++ ) {
      System.out.println("Nombre del archivo: "+ldaLinkListArchivos.get(i).sNombreArchivo);
      System.out.println("Cantidad de líneas en blanco: "+ldaLinkListArchivos.get(i).iCantLineasBlanco);
      iCantTotalLineasBlanco+=ldaLinkListArchivos.get(i).iCantLineasBlanco;
      System.out.println("Cantidad de líneas con información: "+ldaLinkListArchivos.get(i).iCantLineasInfo);
      iCantTotalLineasInfo+=ldaLinkListArchivos.get(i).iCantLineasInfo;
      System.out.println("--------------------------------------------------------------------");
    }


    System.out.println("Cantidad de archivos: "+ldaLinkListArchivos.size());
    System.out.println("Cantidad total de líneas en blanco: "+iCantTotalLineasBlanco);
    System.out.println("Cantidad total de líneas con información: "+iCantTotalLineasInfo);
  }


  public void printPartList(){
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ConteoLDC.txt"), "utf-8"))){
      System.out.println("PARTES BASE:");
      writer.write("PARTES BASE:\n");
      for (int i = 0;i<ptLinkListPartes.size() ;i++ ) {
        if(ptLinkListPartes.get(i).generaResultado()=='b'){
          System.out.println("   "+ptLinkListPartes.get(i).sNombreParte+":  T="+ptLinkListPartes.get(i).iLDCTotales+
                          ", I="+ptLinkListPartes.get(i).iCantItems+", B="+ptLinkListPartes.get(i).iLDCBase+
                          ", D="+ptLinkListPartes.get(i).iLDCBorradas+", M="+ptLinkListPartes.get(i).iLDCModificadas+
                          ", A="+ptLinkListPartes.get(i).iLDCAgregadas);
          writer.write("   "+ptLinkListPartes.get(i).sNombreParte+":  T="+ptLinkListPartes.get(i).iLDCTotales+
                          ", I="+ptLinkListPartes.get(i).iCantItems+", B="+ptLinkListPartes.get(i).iLDCBase+
                          ", D="+ptLinkListPartes.get(i).iLDCBorradas+", M="+ptLinkListPartes.get(i).iLDCModificadas+
                          ", A="+ptLinkListPartes.get(i).iLDCAgregadas+"\n");
        }
      }
      System.out.println("--------------------------------------------------------------------");
      writer.write("--------------------------------------------------------------------\n");
      System.out.println("PARTES NUEVAS:\n");
      writer.write("PARTES NUEVAS:\n");
      for (int i = 0;i<ptLinkListPartes.size() ;i++ ) {
        if(ptLinkListPartes.get(i).generaResultado()=='n'){
          System.out.println("   "+ptLinkListPartes.get(i).sNombreParte+":  T="+ptLinkListPartes.get(i).iLDCTotales+
                          ", I="+ptLinkListPartes.get(i).iCantItems);
          writer.write("   "+ptLinkListPartes.get(i).sNombreParte+":  T="+ptLinkListPartes.get(i).iLDCTotales+
                          ", I="+ptLinkListPartes.get(i).iCantItems+"\n");
        }
      }
      System.out.println("--------------------------------------------------------------------");
      writer.write("--------------------------------------------------------------------\n");
      System.out.println("PARTES REUSADAS:");
      writer.write("PARTES REUSADAS:\n");
      for (int i = 0;i<ptLinkListPartes.size() ;i++ ) {
        if(ptLinkListPartes.get(i).generaResultado()=='r'){
          System.out.println("   "+ptLinkListPartes.get(i).sNombreParte+":  T="+ptLinkListPartes.get(i).iLDCTotales+
                          ", I="+ptLinkListPartes.get(i).iCantItems+", B="+ptLinkListPartes.get(i).iLDCBase);
          writer.write("   "+ptLinkListPartes.get(i).sNombreParte+":  T="+ptLinkListPartes.get(i).iLDCTotales+
                          ", I="+ptLinkListPartes.get(i).iCantItems+", B="+ptLinkListPartes.get(i).iLDCBase+"\n");
        }
      }
      System.out.println("--------------------------------------------------------------------");
      writer.write("--------------------------------------------------------------------\n");


      System.out.println("Total de LDC: "+iCantLineasTotales);
      writer.write("Total de LDC: "+iCantLineasTotales+"\n");
      writer.close();

    }
    catch(IOException e){
      System.out.println("Couldn't open BufferedWriter"+e);
    }


  }
}