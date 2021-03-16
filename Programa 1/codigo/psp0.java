import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class PSP0 {

  public static void main(String []args)throws IOException{

     Scanner entradaEscaner = new Scanner (System.in);

    Calculo ca = new Calculo();
    
    int i=0;
    
    do {
      System.out.println("selecciona una opcion numerica");
      System.out.println("************************");
      System.out.println("1 - definir variables");
      System.out.println("2 - obtener media");
      System.out.println("3 - obtener derivacion estandar");
      System.out.println("4 - salir");
      i = entradaEscaner.nextInt ();
      

      switch(i) {
          case 1:
            ca.definir(); 
            break;
          case 2:
            ca.media();
            break;
           case 3:
             ca.deriv_stand();
            break;
           case 4:
             System.out.println("Hasta luego");
             System.exit(0);
            break;
          default:
            System.out.println("OPCION ON VALIDA, INTENTE NUEVAMENTE");
            break;
        }
    }
    while(i!=4);
    
  }
  
}