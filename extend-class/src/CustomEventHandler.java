
public class CustomEventHandler extends DefaultEventHandler {

	boolean executable = true;
	
	public void setExecutable(boolean executable) {
		this.executable = executable;
	}
	
	@Override
	protected boolean isExecutable(){
		return executable;
	} 
}
