package com.thamesWater.dataModel;

import java.util.List;

import com.thamesWater.dataObject.DTO;
import com.thamesWater.dataObject.ManageDTOLeaveRequest;

public class ManageModelLeaveRequest extends ManageModel {
	private final String sheetName = "ManageLeaveRequest";

	@SuppressWarnings("unchecked")
	@Override
	public ManageDTOLeaveRequest get(String rownname) {
		ManageDTOLeaveRequest dto=new ManageDTOLeaveRequest();
		
		dto.setRequestType(xls.getCellData(sheetName, "RequestType", rownname));
		dto.setStartDate(xls.getCellData(sheetName, "StartDate", rownname));
		dto.setEndDate(xls.getCellData(sheetName, "EndDate", rownname));
		dto.setNote(xls.getCellData(sheetName, "Note", rownname));
		dto.setIlnessCode(xls.getCellData(sheetName, "IlnessCode", rownname));
		dto.setCertificationDate(xls.getCellData(sheetName, "CertificationDate", rownname));
		dto.setReportedOn(xls.getCellData(sheetName, "ReportedOn", rownname));	
		return dto;
	}

	@Override
	public <T extends DTO> List<T> getList(String rownname) {
		// TODO Auto-generated method stub
		return null;
	}

}
