
public class CalculadorE {
		double dP1;
		double dP2;
		double dE;
		double dX;
		int iDof;
		int iNum_seg;
		double dP;
		CalculadorP cpCalcP = new CalculadorP();



		public void calculaE(){
			dE = 0.0000001;
			iNum_seg = 100;
			double dGammaDenominador;
			double dGammaNumerador;
			double dGammaConst;
			double dPotenciaDof;

			if(iDof%2 == 0){
				dGammaDenominador = calculaGammaEntera(iDof/2);
			}
			else{
				dGammaDenominador = calculaGammaFraccion(iDof/2.0);
			}
			if((iDof+1)%2==0){
				dGammaNumerador = calculaGammaEntera((iDof+1)/2);
			}
			else{
				dGammaNumerador = calculaGammaFraccion((iDof+1)/2.0);
			}
			
			dGammaConst = dGammaNumerador/((Math.pow(iDof*Math.PI,0.5))*dGammaDenominador);
			
			dPotenciaDof = -1*((iDof+1)/2.0);
			
			cpCalcP.dX=dX;
			cpCalcP.iDof=iDof;
			cpCalcP.iNum_seg=iNum_seg;
			cpCalcP.dGammaConst=dGammaConst;
			cpCalcP.dPotenciaDof=dPotenciaDof;

			
			dP1 = cpCalcP.calculaP();
			
			iNum_seg *= 2;			
			cpCalcP.iNum_seg=iNum_seg;			
			dP2 = cpCalcP.calculaP();
			
			while(Math.abs(dP1-dP2)>=dE){
				
				dP1 = dP2;				
				iNum_seg *= 2;				
				cpCalcP.iNum_seg=iNum_seg;
				dP2 = cpCalcP.calculaP();
			}
			
			dP = dP2;
		}



		public double calculaGammaEntera(double dNum){
			double dGamma = 1;
			dNum--;
			while(dNum>1){
				dGamma*=dNum;
				dNum--;
			}
			return dGamma;
		}



		public double calculaGammaFraccion(double dNum){
			double dGamma = 1;
			dNum--;
			while(dNum>=0.5){
				dGamma*=dNum;
				dNum--;
			}
			dGamma*=Math.sqrt(Math.PI);
			return dGamma;
		}
}
