import Jama.Matrix;
import Jama.QRDecomposition;

public class regresion {
    private final Matrix beta;  
    private double sse;         
    private double sst;        

    public regresion(double[][] x, double[] y) {
        int n = y.length;
        Matrix matrixX = new Matrix(x);
        Matrix matrixY = new Matrix(y, n);
        QRDecomposition qr = new QRDecomposition(matrixX);
        beta = qr.solve(matrixY);
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += y[i];
        double mean = sum / n;
        for (int i = 0; i < n; i++) {
            double dev = y[i] - mean;
            sst += dev*dev;
        }
        Matrix residuals = matrixX.times(beta).minus(matrixY);
        sse = residuals.norm2() * residuals.norm2();
    }


    public double beta(int j) {
        return beta.get(j, 0);
    }


    public double R2() {
        return 1.0 - sse/sst;
    }

}