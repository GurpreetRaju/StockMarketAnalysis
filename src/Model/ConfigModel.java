package Model;

public class ConfigModel {
	public ConfigModel(){}
	
	public void setValues(boolean newSource,String newFile){
		if(!newFile.equals((String) "")){
			PropertiesSingleton.saveConfigProperty("file", newFile);
		}
		else{
			System.out.println("Value null");
		}
		
		if(newSource){
			if(PropertiesSingleton.saveConfigProperty("filesource", "true")){
			}
		}
		else{
			PropertiesSingleton.saveConfigProperty("filesource", "false");
		}
		System.out.println("property saved");
	}
	public boolean isSourceFile(){
		String result = PropertiesSingleton.getProperty("filesource");
		System.out.println(result);
		if(result.equals("true")){
			return true;
		}
		else{
			return false;
		}
	}
	public String getValues(){
		return PropertiesSingleton.getProperty("file");
	}
}
