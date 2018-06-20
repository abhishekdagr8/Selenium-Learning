package com.thamesWater.dataModelHandler;

import java.util.List;
import com.thamesWater.dataModel.ManageModelLeaveRequest;
import com.thamesWater.dataObject.ManageDTOLeaveRequest;

public class ManageModelHandlerLeaveRequest extends ManageModelHandler{

	private static final ManageModelLeaveRequest model = new ManageModelLeaveRequest();
	
	public static ManageDTOLeaveRequest getDTO(String rowname){
		return model.get(rowname);
	}
	
	public static List<ManageDTOLeaveRequest> getDTOList(String rowname){
		return model.getList(rowname);
	}

}
