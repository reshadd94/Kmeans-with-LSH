import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Main Function
 * Created by Reshad_Dee on 01.06.2017.
 * @author <a href="mailto:a1409161@unet.univie.ac.at">Reshad Dernjnai</a>
 */
public class _main {

    public static String getLocalPath(String filename){
        File root = null;
        try {
            root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        File resource = new File(root, filename);
        String filePath = resource.toString();
        return filePath;
    }


    public static void main(String[] args){
        System.out.println("Please move the csv file here: " + getLocalPath("\\"));
        //Data import from CSV! Because hash calculation are taking to long we are importing here only 11000 lines of csv!
        ArrayList<double[]> pointsData = new ArrayList<>();
        try {
            CSVFileReader csvReader = new CSVFileReader(getLocalPath("LSH-nmi.csv"), ',', 280500);
            pointsData = csvReader.getPoints();
        } catch (IOException e){System.err.println("Caught IOException: " + e.getMessage());}
        Point[] points = new Point[pointsData.size()];
        for(int i = 0; i < pointsData.size(); i++){
            points[i] = new Point(pointsData.get(i), 0);
        }

        //Locality-Sensitive Hashing calculations
        Point[] hashedPoints[];
        long start = System.nanoTime();
        LSH lsh = new LSH();
        LSHFunction[][] lshFunction = lsh.initHashFunctions(points);
        double[] hashsignatures = lsh.calculateHashFunctions(points, lshFunction);
        double elapsedTimeInSec = (System.nanoTime() - start) * 1.0e-9;
        System.out.println("Runtime for hashing of 10 dim dataset: " + elapsedTimeInSec + " seconds");
        //Output of hashed signatures
        for(int i = 0; i < hashsignatures.length; i++){
            System.out.println(hashsignatures[i]);
        }

        //Data import from CSV! Whole dataset 291500!
        pointsData = new ArrayList<>();
        try {
            CSVFileReader csvReader = new CSVFileReader(getLocalPath("LSH-nmi.csv"), ',', 0);
            pointsData = csvReader.getPoints();
        } catch (IOException e){System.err.println("Caught IOException: " + e.getMessage());}
        points = new Point[pointsData.size()];
        for(int i = 0; i < pointsData.size(); i++){
            points[i] = new Point(pointsData.get(i), 0);
        }

        //Kmeans on 10 Dimensions
        start = System.nanoTime();
        Kmeans kmeans = new Kmeans(points, 15);
        elapsedTimeInSec = (System.nanoTime() - start) * 1.0e-9;
        Point[] afterkmeans = kmeans.getPoints();
        for(int i = 0; i < afterkmeans.length; i++){
            System.out.println(afterkmeans[i].pointToString());
        }
        System.out.println("Number of Points before Kmeans: " + points.length);
        System.out.println("Number of Points after Kmeans: " + afterkmeans.length);
        System.out.println("Runtime for Kmeans on 10 dim: " + elapsedTimeInSec + " seconds");

    }
}
