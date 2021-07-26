/**
 * Correlacion
 *
 * Clase que recibe parejas ordenadas para calcular estadísticas y luego poder imprimir las estadísticas
 */

//&p-Correlacion
//&b=56
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Correlacion{
	
	float fPromx;
	float fPromy;
	float fSumx;
	float fSumy;
	float fSumx2;
	float fSumy2;
	float fSumxy;
	int iNumParejas;
	float fxk;
	float fBeta1;
	float fBeta0;
	float fr;
	float fr2;
	float fyk;
	double dSignificancia;
	double dRango;
	double dLimSup;
	double dLimInf;
	CalculadorE ceCalcE = new CalculadorE();
	CalculadorX cxCalcX = new CalculadorX();
	LinkedList<Float> dLinkedListX;
	LinkedList<Float> dLinkedListY;

	  public Correlacion(){
	    fPromx = 0;
	    fPromy = 0;
	    fSumx = 0;
	    fSumy = 0;
	    fSumx2 = 0;
	    fSumy2 = 0;
	    fSumxy = 0;
	    iNumParejas = 0;
	    fxk = 0;
	    fBeta1 = 0;
	    fBeta0 = 0;
	    fr = 0;
	    fr2 = 0;
	    fyk = 0;
	    dSignificancia = 0;
	    dRango = 0;
	    dLimSup = 0;
	    dLimInf = 0;
	    dLinkedListX = new LinkedList<Float>();
	    dLinkedListY = new LinkedList<Float>();
	  }


	  public void pareja(float x, float y){
		  iNumParejas++;
		  fSumx+=x;
		  fSumy+=y;
		  fSumxy+=(x*y);
		  fSumx2+=Math.pow(x, 2);
		  fSumy2+=Math.pow(y, 2);
		  fPromx = fSumx/iNumParejas;
		  fPromy = fSumy/iNumParejas;
		  dLinkedListX.add(x);
		  dLinkedListY.add(y);
	  }


	  public void printResultado(){
			if (!(fxk == 0 && fPromx == 0 && fPromy==0)){
			  if((fSumx2-(iNumParejas*Math.pow(fPromx, 2)))!=0){
				  fBeta1=(float) ((fSumxy-(iNumParejas*fPromx*fPromy))/(fSumx2-(iNumParejas*Math.pow(fPromx, 2))));
				  fBeta0=fPromy-(fBeta1*fPromx);
			  }
			  if((Math.sqrt((iNumParejas*fSumx2-Math.pow(fSumx, 2))*(iNumParejas*fSumy2-Math.pow(fSumy, 2))))!=0){
				  fr = (float) ((iNumParejas*fSumxy-(fSumx*fSumy))/(Math.sqrt((iNumParejas*fSumx2-Math.pow(fSumx, 2))*(iNumParejas*fSumy2-Math.pow(fSumy, 2)))));
				  fr2 = (float) Math.pow(fr, 2);
			  }
			  fyk = fBeta0 + fBeta1*fxk;

			  dSignificancia = calculaSignificancia();
			  dRango = calculaRango();
			  dLimSup = fyk + dRango;
			  dLimInf = fyk - dRango;
			  if (dLimInf < 0){
				  dLimInf = 0;
			  }
			}

		  System.out.println("N = "+iNumParejas);
		  System.out.println("xk = "+String.format("%.0f", fxk));
		  System.out.println("r = "+String.format("%.5f", fr));
		  System.out.println("r2 = "+String.format("%.5f", fr2));
		  System.out.println("b0 = "+String.format("%.5f", fBeta0));
		  System.out.println("b1 = "+String.format("%.5f", fBeta1));
		  System.out.println("yk = "+String.format("%.5f", fyk));
		  System.out.println("sig = "+String.format("%.10f", dSignificancia*100000));
		  System.out.println("ran = "+String.format("%.5f", dRango));
		  System.out.println("LS = "+String.format("%.5f", dLimSup));
		  System.out.println("LI = "+String.format("%.5f", dLimInf));
	  }


	  public double calculaSignificancia(){
		  double dX = (Math.abs(fr)*Math.sqrt(iNumParejas-2))/Math.sqrt(1-fr2);
		  ceCalcE.dX=dX;
		  ceCalcE.iDof=iNumParejas-2;
		  ceCalcE.calculaE();
		  double dP = ceCalcE.dP;
		  return 1-2*dP;
	  }


	  public double calculaRango(){
		  cxCalcX.dP=0.35;
		  cxCalcX.iDof=iNumParejas-2;
		  cxCalcX.calculaX();
		  double dT = cxCalcX.dX;
		  double dDesvEstandar = calculaDesvEstandar();
		  double dSumatoria = 0;
		  for(int i = 0; i< iNumParejas; i++){
			  dSumatoria = Math.pow(dLinkedListX.get(i)-fPromx,2);
		  }
		  double dRangoDer = Math.sqrt(1+1.0/iNumParejas+(Math.pow(fxk-fPromx,2)/dSumatoria));
		  return dT * dDesvEstandar * dRangoDer;
	  }


	  public double calculaDesvEstandar(){
		  double dSumatoria = 0;
		  for(int i = 0; i<iNumParejas;i++){
			  dSumatoria += Math.pow((dLinkedListY.get(i) - fBeta0 - fBeta1 * dLinkedListX.get(i)),2);
		  }
		  return Math.sqrt((1.0/(iNumParejas-2))*dSumatoria);
	  }
}