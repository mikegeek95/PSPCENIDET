public class REGRESION {
	
	static float[]Esize= {130,650,99,150,128,302,95,945,368,961};
	static float[]Pams= {163,765,141,166,137,355,136,1206,433,1130};
	static float[]Aams= {186,699,132,272,291,331,199,1890,788,1601};
	static float[]Adh= {(float) 15.0 , (float) 69.9,(float) 6.5,(float) 22.4,(float) 28.4,(float) 65.9,(float) 19.4,(float) 198.7,(float) 38.8,(float) 138.2};
	
	public static void main(String[] args) {

		System.out.println("*****test 1*****");
		regresion(Esize, Aams);
		System.out.println("*****test 2*****");
		regresion(Esize, Adh);
		System.out.println("*****test 3*****");
		regresion(Pams, Aams);
		System.out.println("*****test 4*****");
		regresion(Pams, Adh);
		
	
	}
	
	public static void regresion(float[] x, float[] y ) {
		float b1,b0,xk=386;
		mb1(x,y,xk);
	}
	
	public static void mb1(float[] x, float[] y ,float xk) {
		float b1 = 0;
		float sx = 0,sy= 0,px= 0,py= 0,sxy= 0,sxx= 0;
		int r;
		
		for(r=0;r<x.length;r++){
			sx=sx+x[r];
			sy=sy+y[r];
			sxy=sxy+(x[r]*y[r]);
			sxx=sxx+(x[r]*x[r]);
		}

		px=sx/x.length;
		py=sy/y.length;

		b1=(sxy-(x.length*px*py))/(sxx-(x.length*(px*px)));
		
		System.out.println("b1="+b1);
		mb0(px,py,b1, xk);
		
	}
	
	public static void mb0(float x, float y,float b1, float xk ) {
		float b0=(y-(b1*x));
		System.out.println("b0="+b0);
		float yk=b0+(b1*xk);
		System.out.println("yk="+yk);
		
	}

}