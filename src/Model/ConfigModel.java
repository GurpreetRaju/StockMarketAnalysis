package Model;

public class ConfigModel {
	public ConfigModel(){}
	
	public void setValues(boolean newSource,String newFile){
		PropertiesSingleton.saveProperty("file", newFile);
		if(newSource){
			if(PropertiesSingleton.saveConfigProperty("filesource", "true")){
				System.out.println("property saved");
			}
		}
		else{
			PropertiesSingleton.saveConfigProperty("filesource", "false");
		}
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
