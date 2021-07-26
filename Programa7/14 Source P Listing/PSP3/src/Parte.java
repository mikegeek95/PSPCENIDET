public class Parte{
  int iCantItems;
  int iLDCTotales;
  int iLDCBase;
  int iLDCBorradas;
  int iLDCModificadas;
  int iLDCAgregadas;
  char cTipoParte;
  String sNombreParte;


	public Parte(String sNombreParte){
	
	  this.sNombreParte = sNombreParte;
	
	  iCantItems = 0;
	  iLDCBase = 0;
	  iLDCBorradas = 0;
	  iLDCAgregadas = 0;
	  iLDCModificadas = 0;
	  iLDCTotales = 0;
	}
	
	
	public void agregaItem(){
	  iCantItems++;
	}
	
	public void agregaLDCBase(int iLDC){
	  iLDCBase += iLDC;
	}
	
	public void agregaLDCBorradas(int iLDC){
	  iLDCBorradas += iLDC;
	}
	
	public char generaResultado(){
	  iLDCAgregadas = iLDCTotales - iLDCBase + iLDCBorradas;
	  if(iLDCAgregadas<0||iLDCBase<iLDCBorradas||iLDCBase<iLDCModificadas){
	    cTipoParte = 'e';
	  }
	  else{
	    if(iLDCBase==0&&iLDCBorradas==0&&iLDCModificadas==0&&iLDCAgregadas>0){
	      cTipoParte = 'n';
	    }
	    else if(iLDCBase>0){
	      if(iLDCBorradas==0&&iLDCAgregadas==0&&iLDCModificadas==0){
	        cTipoParte = 'r';
	      }
	      else if(iLDCBorradas>0||iLDCAgregadas>0||iLDCModificadas>0){
	        cTipoParte = 'b';
	      }
	    }
	  }
	  return cTipoParte;
	}

}