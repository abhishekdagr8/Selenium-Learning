package com.thamesWater.dataModel;

import java.util.List;

import com.ibm.genericUtility.XlsReader;
import com.thamesWater.dataObject.DTO;

public abstract class ManageModel implements Model{
protected static String filename = "ThamesWaterFiori";
XlsReader xls = new XlsReader(
		System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename + ".xlsx");
	
	@Override
	public abstract <T extends DTO> T get(String rownname);
	
	@Override
	public abstract <T extends DTO> List<T> getList(String rownname);

}
