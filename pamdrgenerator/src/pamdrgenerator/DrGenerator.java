package pamdrgenerator;

import java.util.Random;

public class DrGenerator {

	String sampleDR = "1|Krmas170|94787212418532667532|5301442388|20150828111532+0300|8668||ADM|COMPASS|||5|1|1|1|August-2015|September-2015|||0|||||||||||"+
			"|DA:860511,,,,6,,,,,,,,,,,,5,,2000,2500,,0,,286,,|UA:999911,0,0,,6,,,,,,,1102124,0,0,,6,,,,,,,933931,0,0,,6,,,,,,,1101143,0,0,,6,,,,"+
			",,,1101144,0,0,,6,,,,,,,999712,0,0,,6,,,,,,,1102554,0,0,,6,,,,,,,1102555,0,0,,6,,,,,,,1101150,0,0,,6,,,,,,,999912,0,0,,6,,,,,,,11011"+
			"51,0,0,,6,,,,,,,933951,0,0,,6,,,,,,,1102128,0,0,,6,,,,,,,1102034,0,0,,6,,,,,,,1102032,0,0,,6,,,,,,,999811,0,0,,6,,,,,,,1102033,0,0,,"+
			"6,,,,,,,999812,0,0,,6,,,,,,,1101155,0,0,,6,,,,,,,1101154,0,0,,6,,,,,,,1101153,0,0,,6,,,,,,,1101152,0,0,,6,,,,,,,1101159,0,0,,6,,,,,,"+
			",1101158,0,0,,6,,,,,,,729711,0,0,,6,,,,,,,999711,0,0,,6,,,,,,,1101157,0,0,,6,,,,,,,1101156,0,0,,6,,,,,,||offer:40110006,5,,201511100"+
			"00000+0200,20151110000000+0200,,20150810000000+0300,20150810000000+0300,,2,1,,,281,|||30000004|";
	char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public String generateDR(){
		String generatedDR = sampleDR.replace("ADM", randomStringGenerator());
		return generatedDR;
	}
	
	public String randomStringGenerator(){
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
}
