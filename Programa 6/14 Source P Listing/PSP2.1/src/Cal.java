
public class Cal {

	public static void main(String[] args) {
		
		float[]p= {(float) 0.20,(float) 0.45,(float) 0.495};
		int[]dof= {6,15,4};
		int t=0;

		CalculadorX cal = new CalculadorX();
		
		for (t=0;t<p.length;t++) {
			cal.dP=p[t];
			cal.iDof=dof[t];
			System.out.println(cal.calculaX());
		}
	}

}