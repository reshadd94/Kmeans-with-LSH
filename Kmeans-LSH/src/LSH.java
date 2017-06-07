import java.util.Random;

/**
 * Created by Richard Homonnai on 03.06.2017.
 */
public class LSH {
	private int buckets = 100;
	private double w = 0.1;

	public void LSH() {
	}

	public void initHashFunctions(Point[] points) {
		int n = points.length;
		int d = points[0].getData().length;
		LSHFunction[][] lshFunctions = new LSHFunction[points.length][dimension];

		/* generate Random object */
        Random r = new Random();

		/* initialize the LSH functions */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < buckets; j++) {
				/* initialize vector a */
				for (int k = 0; k < d; k++) {
					lshFunctions[i][j].setA(r.nextGaussian(), k);
				}
                /* initialize b */
                lshFunctions[i][j].setB(r.nextDouble() * w);
			}
		}
	}

	double[] calculateHashFunctions(Point[] points, LSHFunction[][] lshFunctions) {
		double sum = 0.0;
		int n = points.length;
		int d = points[0].getData().length;
		double[][] ret = new double[n][d];

		for (int i = 0; i < n; i++) {
			sum = 0;

			for (int j = 0; j < d; j++) {
				sum += points[i].getDataPoint(j) * lshFunctions[i][j].getA(j);
			}
		}
	}
}
