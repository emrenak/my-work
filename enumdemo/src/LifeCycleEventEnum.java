
import java.util.Map;

public enum LifeCycleEventEnum {
	
	BCC("bcc"),
	MSISDNC("msisdnc"),
	BILLING("billing"),
	USAGE("U"),
	PROVISIONING("prov"),
	RERATINGSTART("reratingStart"),
	RERATINGEND("reratingEnd");

	private String lcEventName;
	private Map<String, Object> lcEventParameterMap;
	private boolean isReratingEvent = true;
	
	private LifeCycleEventEnum(String name) {
		this.lcEventName = name;
	}
	
	public String getLcEventName() {
		return lcEventName;
	}
	
	public void setLcEventName(String lcEventName) {
		this.lcEventName = lcEventName;
	}

	public Map<String, Object> getLcEventParameterMap() {
		return lcEventParameterMap;
	}

	public void setLcEventParameterMap(Map<String, Object> lcEventParameterMap) {
		this.lcEventParameterMap = lcEventParameterMap;
	}

	public boolean isReratingEvent() {
		return isReratingEvent;
	}

	public void setReratingEvent(boolean isReratingEvent) {
		this.isReratingEvent = isReratingEvent;
	}

	
	
}
