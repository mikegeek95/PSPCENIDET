
public class CalculadorP {
	double dSumP;
	int iDof;
	double dX;
	int iNum_seg;
	double dGammaConst;
	double dPotenciaDof;


	
	public double calculaP(){
		double dW;
		int cont = 1;
		dW = (double)(dX/iNum_seg);
		dSumP = dW/3* calculaTDist(0);

		for(double dXi = dW; dXi < dX; dXi+=dW){
			if((cont % 2)==0){
				dSumP+=dW/3*4*calculaTDist(dXi);
			}
			else{
				dSumP+=dW/3*2*calculaTDist(dXi);
			}
			cont++;
		}
		dSumP+=dW/3*calculaTDist(dX);
		return dSumP;
	}


	public double calculaTDist(double dXi){
		double dT;
		dT = Math.pow((1 + (dXi*dXi)/iDof),dPotenciaDof)*dGammaConst;
		return dT;
	}

}
