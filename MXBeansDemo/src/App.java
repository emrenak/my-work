import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;


public class App {
	
	public static void main(String[] args) {
		
		System.out.println("test");
		
		RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();

		// Get the standard attribute "VmVendor"
		String vendor = mxbean.getVmVendor();
		
		System.out.println(vendor);
		
		double avg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
		
		System.out.println(avg);
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		 try {
			ObjectName oname = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
			
			if (mbs.isInstanceOf(oname, "com.sun.management.OperatingSystemMXBean")) {
				Long l = (Long) mbs.getAttribute(oname, "TotalPhysicalMemorySize");
				System.out.println("Memory:" + l);
				//ProcessCpuLoad
				double c = (Double) mbs.getAttribute(oname, "ProcessCpuLoad"); // since 1.7
				System.out.println("CPU:" + c);
				
			}
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReflectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	
		 MBeanServerConnection serverConn;
		 
		 try {
		    //connect to a remote VM using JMX RMI
		    
		    JMXServiceURL address = new JMXServiceURL("service:jmx:remoting-jmx://localhost:19898");
		    
		    // remote vm e ip üzerinden baglanirken test ortaminda waiting (muhtemelen time-out) hatasi veriyor. 
		    
		    //JMXServiceURL address = new JMXServiceURL("service:jmx:remoting-jmx://10.201.232.125:19898"); 
		    
		    JMXConnector connector = JMXConnectorFactory.connect(address);

		    serverConn = connector.getMBeanServerConnection();

		    ObjectName objName = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
		    
			if (mbs.isInstanceOf(objName, "com.sun.management.OperatingSystemMXBean")) {
				Long l2 = (Long) mbs.getAttribute(objName, "TotalPhysicalMemorySize");
				System.out.println("TotalPhysicalMemorySize:" + l2);
				Long l4 = (Long) mbs.getAttribute(objName, "FreePhysicalMemorySize");
				System.out.println("FreePhysicalMemorySize:" + l4);
				//ProcessCpuLoad
				double c2 = (Double) mbs.getAttribute(objName, "ProcessCpuLoad");
				System.out.println("ProcessCpuLoad:" + c2);
				double c3 = (Double) mbs.getAttribute(objName, "SystemCpuLoad"); // 0 ile 1 arasýnda degisiyor. Cýkan deger * 100 dersek % kac kullaným olduguna dair yaklasik deger elde etmis oluruz. 
				System.out.println("SystemCpuLoad:" + c3);
				
			}

		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

}
