
public class Cal {

	public static void main(String[] args) {
		
		  double[][] x = { {  1,  10,  20 },
                  {  1,  20,  40 },
                  {  1,  40,  15 },
                  {  1,  80, 100 },
                  {  1, 160,  23 },
                  {  1, 200,  18 } };
		 double[] y = { 243, 483, 508, 1503, 1764, 2129 };

		 Correlacion  rell = new Correlacion();
		 rell.printResultado(x, y);

		
	}

}