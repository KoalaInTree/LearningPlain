package com.djcao.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/9/21
 */
public class Main {
    public static void main(String[] args)
        throws MalformedObjectNameException, NotCompliantMBeanException,
        InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("cdj:name=serverInfo");
        platformMBeanServer.registerMBean(new Server(),objectName);
        Thread.sleep(1000000);
    }
}
