import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
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
        ArrayList<Double[]> points = new ArrayList<>();
        try {
            CSVFileReader csvReader = new CSVFileReader(getLocalPath("LSH-nmi.csv"), ',', 0);
            points = csvReader.getPoints();
        } catch (IOException e){System.err.println("Caught IOException: " + e.getMessage());}

        for(Double[] d : points){
            System.out.println(d[0] + " at point[0]");
        }
        System.out.println(points.size() + " points imported!");
    }
}
