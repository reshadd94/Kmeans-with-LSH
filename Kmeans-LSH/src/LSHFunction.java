/**
 * Created by Richard Homonnai on 03.06.2017.
 */
public class LSHFunction {
	private double[] a;
	private double b;

	public void LSHFunction(double[] a, double b) {
		this.a = a;
		this.b = b;
	}

	public void LSHFunction() {
		/* empty constructor */
	}

    public double[] getA() {
        return this.a;
    }
    
    public double getB() {
        return this.b;
    }
    
    public void setA(double a, int i) {
        this.a[i] = a;
    }
    
    public void setB(double b) {
        this.b = b;
    }
}