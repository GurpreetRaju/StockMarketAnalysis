package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.ConfigModel;
import View.ConfigSourceDialog;

public class ConfigController {
	private ConfigModel model;
	
	public ConfigController(){
		this.model = new ConfigModel();
	}
	
	public void updateConfig(boolean b, String filePath){
		model.setValues(b, filePath);
		System.out.print("Source : " + model.isSourceFile()+" File saved " + model.getValues());
	}
	
}
