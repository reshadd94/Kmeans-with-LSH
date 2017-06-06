/**
 * Created by Richard Homonnai on 03.06.2017.
 */

package kmeans_lsh;

import java.util.*;
import kmeans_lsh.LSHFunction;
import kmeans_lsh.Point;

public class LSH {

	public void LSH() {
	}

	public void initHashFunctions(Point[] points) {
		LSHFunction[][] lshFunctions;

		/* generate Random object */
        Random r = new Random();

		/* initialize the LSH functions */
		for (int i = 0; i < sizeof(points); i++) {
			for (int j = 0; j < buckets; j++) {
				/* initialize vector a */
				for (int k = 0; k < dimension; k++) {
					lshFunctions[i][j].a[k] = r.getNextGaussian();
				}
                /* initialize b */
                lshFunctions[i][j].b = r.nextDouble() * w;                
			}
		}
	}
}
