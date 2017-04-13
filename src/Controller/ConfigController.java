package Controller;

import Model.ConfigModel;
import View.ConfigSourceDialog;

public class ConfigController {
	private ConfigModel model;
	//private ConfigSourceDialog view;
	
	public ConfigController(){
		this.model = new ConfigModel();
		//this.view = new ConfigSourceDialog(this);
	}
	
	public void updateConfig(boolean b, String filePath){
		model.setValues(b, filePath);
		//System.out.print("Source : " + model.isSourceFile()+" File saved " + model.getValues());
	}
	public String getValues(){
		return model.getValues();
	}
	
	public static void main(String arg){
		ConfigController c = new ConfigController();
	}
	
}
