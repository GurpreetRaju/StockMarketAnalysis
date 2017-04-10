package Model;

import java.io.*;
import java.util.Properties;

/**
 * Created by Nikita on 2017-04-09.
 */
public class PropertiesSingleton {
    private static PropertiesSingleton instance;
    private static String propFileName;
    private static Properties prop;

    static {
        propFileName = "config.properties";
        prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propFileName);

            // load a properties file
            prop.load(input);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private PropertiesSingleton() {
    }

    public static PropertiesSingleton getInstance() {
        return instance;
    }

    public static boolean checkProperty(String uid, String pwd) {
        String result = prop.getProperty(uid.trim());
        if (result != null) {
            if (result.trim().equals(pwd.trim())) return true;
            else return false;
        } else return false;
    }
    
    @SuppressWarnings("unused")
	public static String getProperty(String uid){
    	String result = "";
    	try {
			InputStream inputStream = new FileInputStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
				result = prop.getProperty(uid.trim());
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	   	
    	return result;    	
    }

    public static boolean saveProperty(String uid, String pwd) {
        OutputStream output = null;
        boolean isNoError = true;

        String result = prop.getProperty(uid.trim());

        if (result == null) {
            try {
                output = new FileOutputStream(propFileName);
                prop.setProperty(uid, pwd);
                System.out.println("to prop" + uid + " pwd " + pwd);
                prop.store(output, null);

            } catch (Exception ex) {
                ex.printStackTrace();
                isNoError = false;
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        isNoError = false;
                    }
                }

            }
        } else {
            isNoError = false;
        }
        return isNoError;
    }
    public static boolean saveConfigProperty(String key, String value) {
    	OutputStream output = null;
        boolean isNoError = true;
        try {
        	output = new FileOutputStream(propFileName);
            prop.setProperty(key, value);
            System.out.println("to prop" + key + " value " + value);
            prop.store(output, null);
        } catch (Exception ex) {
        	ex.printStackTrace();
            isNoError = false;
        } finally {
        	if (output != null) {
        		try {
        			output.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        			isNoError = false;
        		}
        	}
        }
        return isNoError;
    }
}
