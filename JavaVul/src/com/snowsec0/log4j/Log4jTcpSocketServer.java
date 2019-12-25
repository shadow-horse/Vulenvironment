package com.snowsec0.log4j;

/**
 * Apache Log4j反序列化漏洞(CVE-2017-5645)
 */


import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.logging.log4j.core.net.server.ObjectInputStreamLogEventBridge;
import org.apache.logging.log4j.core.net.server.TcpSocketServer;

public class Log4jTcpSocketServer {
 
 public static void main(String[] args) {
     TcpSocketServer<ObjectInputStream> myServer = null;
        try {
            myServer = new TcpSocketServer<ObjectInputStream>(8888,new ObjectInputStreamLogEventBridge());
        } catch (IOException e) {
            e.printStackTrace();
        }
        myServer.run();
        System.out.println("run end.");
    }
}