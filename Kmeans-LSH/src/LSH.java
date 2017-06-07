import java.util.Random;

/**
 * Created by Richard Homonnai on 03.06.2017.
 */
public class LSH {
	private int buckets = 100;
	private double w = 0.1;

	public void LSH() {
	}

	public LSHFunction[][] initHashFunctions(Point[] points) {
		int n = points.length;
		int d = points[0].getData().length;
		LSHFunction[][] lshFunctions = new LSHFunction[n][buckets];

		/* generate Random object */
        Random r = new Random();

		/* initialize the LSH functions */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < buckets; j++) {
				lshFunctions[i][j].setA(new double[n]);
				/* initialize vector a */
				for (int k = 0; k < d; k++) {
					lshFunctions[i][j].setA(r.nextGaussian(), k);
				}
                /* initialize b */
                lshFunctions[i][j].setB(r.nextDouble() * w);
			}
		}
		return lshFunctions;
	}

	double[] calculateHashFunctions(Point[] points, LSHFunction[][] lshFunctions) {
		double sum = 0.0;
		int n = points.length;
		int d = points[0].getData().length;
		double[] ret = new double[n];

		for (int i = 0; i < n; i++) {
			sum = 0;

			for (int j = 0; j < d; j++) {
				sum += points[i].getDataPoint(j) * lshFunctions[i][j].getA(j);
			}

			sum += lshFunctions[i][i].getB();

			ret[i] = Math.floor(sum / w);
		}

		return ret;
	}
}
