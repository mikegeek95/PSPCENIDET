public class CALC {

	float  valorx,valordof,num,den,funcx,numerador,denominador,funcion,valorx2,multiplicador2,sumafunciones1,sumafunciones2,w,funcion0;
	
	float  numerador () {

		float  i;
		float  numsf=valordof/2;
		float  dofapoy=valordof-1;
		float  numeradorsf=(((valordof+1)/2)-1);
		numerador=1;
		
	    if((valordof+1)%2==0){
	        for (i = numeradorsf; i > 0; i--) {
	            numerador = numerador * i;
	        }
	    }else{
	        for (i = numsf; i > 0; i--) {
	            numerador= numerador*((dofapoy)/2);
	            dofapoy=dofapoy-2;
	        }
	        numerador=(float) (numerador*Math.sqrt(Math.PI));
	    }
	    
	    return numerador;
	}
	
	float  denominador() {
		float  densf=valordof/2,dofapoyo=valordof-2,factorialdeno=1,deno=(valordof/2)-1;
		float  i;
		
			if((valordof+1)%2==0){
		        for ( i = densf; i > 1; i--) {
		            factorialdeno = factorialdeno*((dofapoyo)/2);
		            dofapoyo = dofapoyo-2;
		        }
		        factorialdeno = (float) (factorialdeno*Math.sqrt(Math.PI));
		    }else{
		        for ( i = deno; i > 0; i--) {
		            factorialdeno = factorialdeno * i;
		        }
		    }
		    System.out.println(factorialdeno); 
		    denominador=(float) ((Math.pow((valordof*3.1416),(0.5)))*(factorialdeno));
		   return denominador;
	}
	
	float  funcionx() {
		float  multiplicador=(float) Math.pow((1+((valorx*valorx)/valordof)),(-(valordof+1)/2));
		System.out.println(((numerador/denominador)*multiplicador));
		funcion =((numerador/denominador)*multiplicador);
	    return funcion; 
	}
	
	float  funcionx4() {
		float  funcion2,valorx2=valorx/10,a=1, i;
		 w=(valorx/10);
		
	    for ( i=valordof/2; i>0; i--){
	        multiplicador2=(float) Math.pow((1+((valorx2*valorx2)/valordof)),(-(valordof+1)/2));
	        funcion2= ((numerador/denominador)*multiplicador2);
	        sumafunciones1 += (funcion2*4);
	        a=a+2;
	        valorx2= (valorx/10) * a;
	    }
	   
	    return sumafunciones1;
	}
	
	float  funcionx2() {
		float  i,funcion3,b=2;
	    
		for (i=valordof/2; i>1; i--){
	        valorx2= (valorx/10) * b;
	        multiplicador2= (float) Math.pow((1+((valorx2*valorx2)/valordof)),(-(valordof+1)/2));
	        funcion3= ((numerador/denominador)*multiplicador2);
	        sumafunciones2 += (funcion3*2);
	        b=b+2;
	    }

	    return sumafunciones2;
	}
	
	float  funcion0() {
	    multiplicador2=(float) Math.pow((1+((0)/valordof)),(-(valordof+1)/2));
	    funcion0= ((numerador/denominador)*multiplicador2);
	    return funcion0;
	}
	
	float  funcionp() {
		return (w/3)*(funcion0+sumafunciones1+sumafunciones2+funcion);
	}
}