package sshdemo;


public class App {

	public static void main(String[] args) {
		Process p;
		try {
			String[] s = new String[]{"/data/qrr_stb/lib/subsDumpTool2.sh","10.162.15.12", "touch /tmp/keepwork & && nohup /opt/sdp/DataTool/bin/subscriberDumpTool load /var/tmp/subscriberdump_1.7006.1_block.tar 2>&1 < /dev/null"}; 
			p = Runtime.getRuntime().exec(s);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
