import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Our Kmeans modified to take multi dimensional data input!
 *
 * Modified by Reshad_Dee on 06.06.2017.
 * <a href="mailto:a1409161@unet.univie.ac.at">Reshad Dernjnai</a>
 * Based on Generator.java by Richard Homonnai
 */
public class Kmeans implements NMI_Interface {
    private final int N;
    private final int C;
    private int iter; //Iterations till converged
    private final Point[] centroids;
    private final Point[] points;

    /**
     * Constructor takes array of points and c is centroid which should be init as zero.
     *
     * @param data
     * @param c
     */
    public Kmeans(Point[] data, int c) {
        this.N = data.length;
        this.C = c;
        this.iter = 0;
        this.points = data;
        this.centroids = generateRandomClusters(C);
        calculateClusters();
    }

    private Point[] generateRandomClusters(int c) {
        Point[] newPoints = new Point[c];
        for (int i = 0; i < c; i++) {
            newPoints[i] = points[(int)randomDouble(1,N)];
            newPoints[i].setCluster(i+1);
        }

        return newPoints;
    }

    private static double randomDouble(double rangeMin, double rangeMax) {

        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        //System.out.println("Random Double: " + randomValue);

        return randomValue;
    }

    private void calculateClusters() {
        boolean  finished = false;

        while (!finished) {
            finished = true;
            for (int i = 0; i < N; i++) {
                points[i] = assignCluster(points[i]);
            }
            for (int i = 0; i < C; i++) {
                Point newCentroid = calculateMean(i+1);
                double delta = calculateDistance(centroids[i], newCentroid);
                centroids[i] = newCentroid;
                this.iter = this.iter + 1;
                if (delta > 0.0) {
                    finished = false;
                }
            }
        }
        //System.out.println("We are converging. Good bye!");
    }

    private static double calculateDistance(Point p, Point q) {
        /* Euclidean distance between two points */
        double distance = 0;
        double dataP[] = p.getData();
        double dataQ[] = q.getData();
        for(int i=0; i<p.getData().length; i++)
            distance += Math.pow(dataP[i] - dataQ[i],2);
        return Math.sqrt(distance);
    }

    private  Point calculateMean(int clusterNumber) {
        double [] meanData = new double [points[0].getData().length];
        int numPoints = 0;

        for (int i = 0; i < N; i++) {
            if (points[i].getCluster() == clusterNumber) {
                for(int j = 0; j < meanData.length; j++){
                    meanData[j] += points[i].getData()[j];
                }
                numPoints++;
            }
        }
        for(int j = 0; j < meanData.length; j++){
            meanData[j] = meanData[j] / numPoints;
        }

        return new Point(meanData, clusterNumber);
    }

    private Point assignCluster(Point p) {
        double d;

        if (p.getCluster() == 0) {
            d = Double.NaN;
        } else {
            d = calculateDistance(centroids[p.getCluster()-1], p);
        }

        for (int i = 0; i < C; i++) {
            double d2 = calculateDistance(p, centroids[i]);
            if (Double.isNaN(d) || d2 < d) {
                //System.out.println("+ Assigning " + p + " to Cluster " + (i+1) + " (Distance: " + d2 + ") ");
                p.setCluster(i+1);
                d = d2;
            } else {
                //System.out.println("- " + p + " has not changed to Cluster" + (i+1) + " (Distance: " + d2 + ")");
            }
        }
        return p;
    }

    public double NMI(ArrayList<Integer> one, ArrayList<Integer> two){
        if(one.size()!=two.size()){
            throw new IllegalArgumentException("Sizes don't match!");
        }
        int maxone=Collections.max(one);
        int maxtwo=Collections.max(two);

        double[][]count=new double[maxone+1][maxtwo+1];
        //System.out.println(count[1][2]);
        for(int i=0;i<one.size();i++){
            count[one.get(i)][two.get(i)]++;
        }
        //i<maxone=R
        //j<maxtwo=C
        double[]bj=new double[maxtwo+1];
        double[]ai=new double[maxone+1];

        for(int m=0;m<(maxtwo+1);m++){
            for(int l=0;l<(maxone+1);l++){
                bj[m]=bj[m]+count[l][m];
            }
        }
        for(int m=0;m<(maxone+1);m++){
            for(int l=0;l<(maxtwo+1);l++){
                ai[m]=ai[m]+count[m][l];
            }
        }

        double N=0;
        for(int i=0;i<ai.length;i++){
            N=N+ai[i];
        }
        double HU=0;
        for(int l=0;l<ai.length;l++){
            double c=0;
            c=(ai[l]/N);
            if(c>0){
                HU=HU-c*Math.log(c);
            }
        }

        double HV=0;
        for(int l=0;l<bj.length;l++){
            double c=0;
            c=(bj[l]/N);
            if(c>0){
                HV=HV-c*Math.log(c);
            }
        }
        double HUstrichV=0;
        for(int i=0;i<(maxone+1);i++){
            for(int j=0;j<(maxtwo+1);j++){
                if(count[i][j]>0){
                    HUstrichV=HUstrichV-count[i][j]/N*Math.log(((count[i][j])/(bj[j])));
                }
            }
        }
        double IUV=HU-HUstrichV;
        double reto=IUV/(Math.max(HU,HV));

        System.out.println("NMI: "+reto);
        return reto;
    }

    public int getN() {
        return N;
    }

    public int getC() {
        return C;
    }

    public int getIter() {
        return this.iter;
    }

    public Point[] getCentroids() {
        return centroids;
    }

    public Point[] getPoints() {
        return points;
    }
}
