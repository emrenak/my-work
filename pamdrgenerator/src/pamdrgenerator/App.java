package pamdrgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class App {

	public static void main(String[] args) {
		DrGenerator drGenerator = new DrGenerator();
		for (int i = 0; i < 83121; i++) {
			try{
	             //String path="C:\\Users\\eemrnak\\Desktop\\ne_related\\pamload\\PAM_AA_"+i+".ASN";
				 String path="/nfs/local_test/pam_load/80kpam/PAM_AA_"+i+".ASN";
	             File file = new File(path);

	                // if file doesnt exists, then create it
	                if (!file.exists()) {
	                    file.createNewFile();
	                }

	                FileWriter fw = new FileWriter(file.getAbsoluteFile());
	                BufferedWriter bw = new BufferedWriter(fw);
	                for (int j = 0; j < 26; j++) {
		                bw.write(drGenerator.generateDR());
		                bw.write("\n");
					}
	                bw.close();
	          }catch(Exception e){
	              System.out.println(e);
	          }
			if(i%10==0){
				System.out.println("Generation goes on");
			}
		}
		
		System.out.println("Generation completed");
		
	}

}
