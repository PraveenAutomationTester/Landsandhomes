package com.LandsandHomes.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
public String ReadDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/LandsandHomes.properties");
	Properties prp=new Properties();
	prp.load(fis);
	String values=prp.getProperty(key);
	return values;
	
}
}
