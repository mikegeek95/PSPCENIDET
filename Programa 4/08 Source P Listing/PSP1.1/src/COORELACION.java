public class COORELACION {
	
	static float[]AAMS= {186,699,132,272,291,331,199,1890,788,1601};
	static float[]DH= {(float) 15.0,(float) 69.9,(float) 6.5,(float) 22.4,(float) 28.4,(float) 65.9,(float) 19.4,(float) 198.7,(float) 38.8,(float) 138.2};
	
	static float[]AS= {0,30,42,31};
	static float[]PS= {0,50,100,29};
	static float[]DT= {0,60,240,60};
	
	public static void main(String[] args) {

		System.out.println("***** COORELACION TEST 1 *****");
		coorelacion(AAMS, DH);
		System.out.println("***** COORELACION TEST 2 *****");
		coorelacion(AS, DT);
		System.out.println("***** COORELACION TEST 3 *****");
		coorelacion(PS, DT);
		
	}
	
	public static void coorelacion(float[] x, float[] y) {
		float res2 = 0, res = 0;
		float sx = 0,sy= 0,px= 0,py= 0,sxy= 0,sxx= 0, syy= 0;
		int r,sx2,sy2;
		
		for(r=0;r<x.length;r++){
			sx=sx+x[r];
			sy=sy+y[r];
			sxy=sxy+(x[r]*y[r]);
			sxx=sxx+(x[r]*x[r]);
			syy=syy+(y[r]*y[r]);
		}
		
		res=(float) (((x.length*sxy)-(sx*sy)) / (Math.sqrt( (x.length*sxx-Math.pow(sx,2))*(x.length*syy-Math.pow(sy,2)) )));
		System.out.println("r="+res);
		res2=(float) Math.pow(res,2) ;
		System.out.println("r2="+res2);
		
	}

}