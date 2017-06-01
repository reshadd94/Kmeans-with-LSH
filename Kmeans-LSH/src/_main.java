import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by Reshad_Dee on 01.06.2017.
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
        System.out.println("#####" + getLocalPath("test"));

    }
}
