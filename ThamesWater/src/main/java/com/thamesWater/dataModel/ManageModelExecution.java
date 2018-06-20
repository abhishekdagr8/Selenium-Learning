package com.thamesWater.dataModel;

import java.util.ArrayList;
import java.util.List;

import com.thamesWater.dataObject.ManageDTOExecution;

public class ManageModelExecution extends ManageModel{
	
	private final String sheetName = "MasterFile";

	@SuppressWarnings("unchecked")
	@Override
	public ManageDTOExecution get(String rownname) {
		ManageDTOExecution dto=new ManageDTOExecution();
		dto.setTestCaseName(xls.getCellData(sheetName, "TestCaseName", rownname));
		dto.setMethodName(xls.getCellData(sheetName, "MethodName", rownname));
		dto.setExecute(xls.getCellData(sheetName, "Execute", rownname));
		dto.setRows(xls.getRowCount(sheetName));
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageDTOExecution> getList(String rownname) {
		List<ManageDTOExecution> list = new ArrayList<ManageDTOExecution>();
		for (int i = 2; i <= xls.getRowCount(this.sheetName); i++) {
				ManageDTOExecution dto = new ManageDTOExecution();
				dto.setTestCaseName(xls.getCellData(sheetName, 0, i));
				dto.setMethodName(xls.getCellData(sheetName, 1, i));
				dto.setExecute(xls.getCellData(sheetName, 2, i));
				list.add(dto);
			}
		return list;
	}

}
