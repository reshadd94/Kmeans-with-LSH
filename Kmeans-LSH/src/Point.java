import java.util.ArrayList;

/**
 * The class Point.java handles the data and is used as input for Kmeans.java!
 *
 * Modified by Reshad_Dee on 06.06.2017.
 * <a href="mailto:a1409161@unet.univie.ac.at">Reshad Dernjnai</a>
 * Based on Point.java by Richard Homonnai
 */
public class Point {
    double[] data;
    int c;

    /**
     * The constructor gets the array of data/dimensions of point and c as centroid,
     * which should be init by zero.
     */
    public Point(double[] data, int c) {
        this.c = c;
        this.data = data;
    }

    /**
     * Returns the data point array.
     */
    public double[] getData() {
        return data;
    }

    /**
     * Returns a dimension of the data point.
     */
	public double getDataPoint(int i) {
		return data[i];
	}

    public void setData(double[] data) {
        this.data = data;
    }

    public int getCluster() {
        return this.c;
    }

    public void setCluster(int c) {
        this.c = c;
    }

    public String pointToString() {
        String result =  "Point (";
        for(int i = 0; i < data.length; i++)
            if(i==0)
                result = result + data[i];
            else
                result = result + ", " + data[i];
        result = result + ") @Cluster " + c;
        return result;
    }
}
