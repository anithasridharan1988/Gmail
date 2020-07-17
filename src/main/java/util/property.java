package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;

public class property {
	
	public Properties ps = null;
	public FileInputStream fp = null;
	
	public Properties propertyfile(String filepath)
	{
		File fs = new File(filepath);
		try {
			fp = new FileInputStream(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ps = new Properties();
		try {
			ps.load(fp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

}
