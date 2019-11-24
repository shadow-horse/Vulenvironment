
import java.lang.management.ManagementFactory;
import javax.management.*;

/**
 * 
 * @author snow
 * 当前进程的MBean服务器并打印出所有已注册的MBean
 */
public class MBeanExample {
	public static void main(String[] args) throws Exception {
		// Connect to the MBean server of the current Java process
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        System.out.println( server.getMBeanCount() );

        // Print out each registered MBean
        for ( Object object : server.queryMBeans(new ObjectName("*:*"), null) ) {
           System.out.println( ((ObjectInstance)object).getObjectName() );
        }
	}

}
