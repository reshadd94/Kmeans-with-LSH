import java.util.ArrayList;

/**
 * Modified by Reshad_Dee on 06.06.2017.
 * <a href="mailto:a1409161@unet.univie.ac.at">Reshad Dernjnai</a>
 * Based on Point.java by Richard Homonnai
 */
public class Point {
    double[] data;
    int c;

    public Point(double[] data, int c) {
        this.c = c;
        this.data = data;
    }

    public double[] getData() {
        return data;
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
        return "Point (" + data[0] + ", " + data[1] + ") @Cluster " + c;
    }
}
