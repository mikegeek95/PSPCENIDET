import java.util.Scanner;

public class Calculo {

	static Float[] numbers;
	static float sumat,dif,len,media,deriv;
	static double de;
	static int cont,y;
	static Scanner entradaEscaner = new Scanner (System.in);


	static void definir() {
		reset();
		
    	System.out.println("define cuandos elementos tendra tu array");
    	cont = entradaEscaner.nextInt ();
    	numbers = new Float [cont];
    	y=0;
    	while(y<cont){
    		System.out.println("Introduce el elemento: "+(y+1));
    		numbers[y]=entradaEscaner.nextFloat();
    		y++;
    	}
    	System.out.println("Elementos guardados");

  }
	
  	static void reset() {
  		numbers = null;
  		sumat=0;
  		dif=0;
  		len=0;
  		media=0;
  		deriv=0;
  		de=0;
  		cont=0;
  		y=0;;
  }

  	static boolean validacion() {
  		boolean r= true;
    	len=numbers.length;
    	if (len==0){
    		System.out.println("array sin datos");
    		r= true;
    	}
    	else if(len > 0){
    		r= false;
    	}
		return r;
  }

  	static void media() {

  		if (validacion()){
  			
  		}
  		else{

	    	System.out.println("Calculando media...");
	    	y=0;
	    	len=numbers.length;
	    	while(y<len){
	    		sumat=sumat+numbers[y];
	    		y++;
	    	}

	    	media=sumat/len;

	    	System.out.println("la media es: "+Math.round(media*100.0)/100.0);
    	}

  }

    	static void deriv_stand() {

    		if (validacion()){
  			
  		}
  		else{ 

  			if (media==0){
  				media();
  			} 

	    	System.out.println("Calculando derivacion...");
	    	y=0;
	    	len=numbers.length;
	    	while(y<len){
	    		dif=(numbers[y]-media)*(numbers[y]-media);
	    		deriv=deriv+dif;
	    		y++;
	    	}

	    	de=Math.sqrt(deriv/(len-1));

	    	System.out.println("la derivacion estandar es: "+Math.round(de*100.0)/100.0);
    	}

  }

}
