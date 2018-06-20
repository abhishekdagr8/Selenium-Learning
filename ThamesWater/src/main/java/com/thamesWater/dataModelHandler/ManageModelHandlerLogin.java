package com.thamesWater.dataModelHandler;

import java.util.List;
import com.thamesWater.dataModel.ManageModelLogin;
import com.thamesWater.dataObject.ManageDTOLogin;


public class ManageModelHandlerLogin extends ManageModelHandler{
private static final ManageModelLogin model = new ManageModelLogin();
	
	public static ManageDTOLogin getDTO(String rowname){
		return model.get(rowname);
	}
	
	public static List<ManageDTOLogin> getDTOList(String rowname){
		return model.getList(rowname);
	}

}
