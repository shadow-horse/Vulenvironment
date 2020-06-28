package com.snowsec0.fastjsonvul.fastjson68;
/**
 * fastjson <= 1.2.68 autopass绕过漏洞  
 * 通过Exception绕过autocheck，调用类中的API，通过构造传入的参数进行攻击  
 * 调用该类执行恶意代码   
 */
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import java.net.URL;

public class DatasourceException extends Exception {

    public DatasourceException() {

    }

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(URL url) {
        this.dataSource = new URLDataSource(url);
    }
}
