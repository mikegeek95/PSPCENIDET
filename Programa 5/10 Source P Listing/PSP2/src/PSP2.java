import java.util.Scanner;

public class PSP2 {
	
	public static void main(String[] args) {
		CALC funcion = new CALC();
		
		try (var input = new Scanner (System.in)) {
			System.out.println("Ingresa x: "); 
			funcion.valorx = input.nextFloat();
			System.out.println("Ingresa dof: "); 
			funcion.valordof = input.nextFloat();
		
		    System.out.println("numerador: "+funcion.numerador());
		    System.out.println("denimador: "+funcion.denominador());
		    System.out.println("funcion x: "+funcion.funcionx());
		    System.out.println("funcion x por 4: "+funcion.funcionx4());
		    System.out.println("funcion x por 2: "+funcion.funcionx2());
		    System.out.println("funcion 0: "+funcion.funcion0());
		    System.out.println("P: "+funcion.funcionp());
		}
	    
	}
	
}