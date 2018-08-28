import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class airApp {

	static String airReadBegin = "Air request sending";
	static String airReadEnd = "Air response code";
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS"); 
		try (BufferedReader br = new BufferedReader(new FileReader("airtimes.out"))) {
			boolean diffCalculated = false;
			String sCurrentLine;
			String prevMsisdn = "";
			long totalProcessing = 0;
			long totalMsisdnProcessed =0;
			Date dbStart=null,dbEnd=null;
			while ((sCurrentLine = br.readLine()) != null) {
				String msisdn = sCurrentLine.split(" - ")[1].split(" ")[0];
				String arr[] = sCurrentLine.split(" ");
				String date =  arr[2]+" "+arr[3];
				if(!msisdn.equals(prevMsisdn)){
					if(sCurrentLine.contains(airReadBegin)){
						// start time
						dbStart = formatter.parse(date);
						diffCalculated = false;
						prevMsisdn = msisdn;
					}
				}else{
					if(!diffCalculated && sCurrentLine.contains(airReadEnd)){
						dbEnd = formatter.parse(date);
						long diff = dbEnd.getTime() - dbStart.getTime();
						diffCalculated = true;
						//System.out.println("Diff for msisdn:" + msisdn + "is:" + diff);
						totalMsisdnProcessed++;
						totalProcessing += diff;
					}
				}
				//System.out.println(sCurrentLine);
			}
			System.out.println("Total processing for air: " + totalProcessing + " millis. Total msisdn size: " + totalMsisdnProcessed);

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
}
