/**
 * Modified by Reshad_Dee on 06.06.2017.
 * <a href="mailto:a1409161@unet.univie.ac.at">Reshad Dernjnai</a>
 * Based on Point.java by Richard Homonnai
 */
public class Point {
    double x;
    double y;
    int c;

    public Point(double x, double y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public int getCluster() {
        return this.c;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setCluster(int c) {
        this.c = c;
    }

    public String pointToString() {
        return "Point (" + x + ", " + y + ") @Cluster " + c;
    }
}
