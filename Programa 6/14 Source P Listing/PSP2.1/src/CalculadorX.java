public class CalculadorX {
	CalculadorE ceCalcE = new CalculadorE();
	double dX1;
	double dX2;
	double dP1;
	double dP2;
	double dD;
	double dE;
	double dP;
	int iDof;
	double dX;



	public double calculaX(){
		dD = 1;
		dE = 0.0000001;
		
		if(dP != 0){
			dX1 = 0;
			boolean sumando = true;
			ceCalcE.dX=dX1;
			ceCalcE.iDof=iDof;
			
			ceCalcE.calculaP();
			
			dX2 = dX1 + dD;
			ceCalcE.dX=dX2;
			ceCalcE.calculaP();
			
			dP2 = ceCalcE.dP;
			
			while(Math.abs(dX1-dX2) > dE){
				dX1 = dX2;
				
				if((dP2 > dP && sumando) || (dP2 < dP && !sumando)){
					dD = dD/-2.0;
					sumando = !sumando;
				}
				
				dX2 = dX1 + dD;
				ceCalcE.dX=dX2;
				ceCalcE.calculaP();
				dP2 = ceCalcE.dP;
			}
			
			dX = dX2;
		}
		else{
			dX = 0;
		}
		return dX;
	}

}