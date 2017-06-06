import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;

/**
 * Class is responsible for the Import of the Data source.
 * @see <a href="http://opencsv.sourceforge.net/">http://opencsv.sourceforge.net/</a>
 * @author <a href="mailto:a1409161@unet.univie.ac.at">Reshad Dernjnai</a>
 */
public class CSVFileReader {
	
	private char seperator;
	private String pathOfCSVFile = null;
	private int beginWithLine;
	private ArrayList<double[]> points = new ArrayList<>();


	public CSVFileReader(String csvPath, char seperator, int beginWithLine) throws IOException {
		this.seperator = seperator;
		this.beginWithLine = beginWithLine;
		pathOfCSVFile = csvPath;
		doImport();
	}

	public void doImport() throws IOException {
		String[] nextLine;
		int counter = 0;
		int lineNumber = 0;
		FileReader fileReader = new FileReader(pathOfCSVFile);
		CSVReader csvReader = null;
		csvReader = new CSVReader(fileReader, seperator, '"', beginWithLine);
		while ((nextLine = csvReader.readNext()) != null) {
			if (nextLine != null) {
				double[] point = new double[10];
				for (int i = 0; i < 10; i++) {
					if(nextLine[i] != null)
						point[i] = Double.parseDouble(nextLine[i]);
					else
						point[i] = 0.0;
				}
				points.add(point);
				lineNumber++;
				counter++;
			}
		}
	}

	public ArrayList<double[]> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<double[]> points) {
		this.points = points;
	}

	public char getSeperator() {
		return seperator;
	}

	public void setSeperator(char seperator) {
		this.seperator = seperator;
	}

	public String getPathOfCSVFile() {
		return pathOfCSVFile;
	}

	public void setPathOfCSVFile(String pathOfCSVFile) {
		this.pathOfCSVFile = pathOfCSVFile;
	}

	public int getBeginWithLine() {
		return beginWithLine;
	}

	public void setBeginWithLine(int beginWithLine) {
		this.beginWithLine = beginWithLine;
	}
}
