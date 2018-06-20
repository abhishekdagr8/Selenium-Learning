package com.thamesWater.dataModelHandler;

import java.util.List;
import com.thamesWater.dataModel.ManageModelExecution;
import com.thamesWater.dataObject.ManageDTOExecution;

public class ManageModelHandlerExecution extends ManageModelHandler{

private static final ManageModelExecution model = new ManageModelExecution();
	
	public static ManageDTOExecution getDTO(String rowname){
		return model.get(rowname);
	}
	
	public static List<ManageDTOExecution> getDTOList(String rowname){
		return model.getList(rowname);
	}
}
