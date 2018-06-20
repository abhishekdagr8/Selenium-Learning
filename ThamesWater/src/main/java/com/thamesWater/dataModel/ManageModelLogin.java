package com.thamesWater.dataModel;

import java.util.ArrayList;
import java.util.List;

import com.thamesWater.dataObject.ManageDTOLogin;



public class ManageModelLogin extends ManageModel {
	
	private final String sheetName = "ManageLogin";
//	XlsReader xls = new XlsReader(
//			System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename + ".xlsx");

	@SuppressWarnings("unchecked")
	@Override
	public ManageDTOLogin get(String rownname) {
		ManageDTOLogin dto = new ManageDTOLogin();
		
		dto.setuserName(xls.getCellData(sheetName, "Username", rownname));
		dto.setpassword(xls.getCellData(sheetName, "Password", rownname));
		
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageDTOLogin> getList(String rownname) {
		List<ManageDTOLogin> list = new ArrayList<ManageDTOLogin>();
		
		for (int i = 1; i <= xls.getRowCount(this.sheetName); i++) {
			if (xls.getCellData(sheetName, "ScenarioName", i).equals(rownname)) {
				ManageDTOLogin dto = new ManageDTOLogin();
				dto.setuserName(xls.getCellData(sheetName, "Username", i));
				dto.setpassword(xls.getCellData(sheetName, "Password", i));

				list.add(dto);
				
			}
		}
		return list;
	}
}
