/**
 * Created by Richard Homonnai on 03.06.2017.
 */
public class LSHFunction {
	private double[] a;
	private double b;

	public LSHFunction(int n) {
		/* empty constructor */
		this.a = new double[n];
		this.b = 0.0;
	}

    public double getA(int i) {
        return this.a[i];
    }
    
    public double getB() {
        return this.b;
    }
    
    public void setA(double[] a) {
        this.a = a;
    }
    
    public void setA(double a, int i) {
        this.a[i] = a;
    }
    
    public void setB(double b) {
        this.b = b;
    }
}