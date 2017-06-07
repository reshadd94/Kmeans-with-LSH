/**
 * Created by Richard Homonnai on 03.06.2017.
 */
public class LSHFunction {
	private double[] a;
	private double b;

	/**
	 * constructor with dimension n
	 */
	public LSHFunction(int n) {
		this.a = new double[n];
		this.b = 0.0;
	}

	/**
	 * return hash vector value at index i
	 */
    public double getA(int i) {
        return this.a[i];
    }
    
	/**
	 * return hash correction value
	 */
    public double getB() {
        return this.b;
    }
    
	/**
	 * set hash vector
	 */
    public void setA(double[] a) {
        this.a = a;
    }
    
	/**
	 * set hash vector value at index i
	 */
    public void setA(double a, int i) {
        this.a[i] = a;
    }
    
	/**
	 * return hash correction value
	 */
    public void setB(double b) {
        this.b = b;
    }
}
