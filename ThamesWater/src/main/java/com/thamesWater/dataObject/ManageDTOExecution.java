package com.thamesWater.dataObject;

public class ManageDTOExecution implements ManageDTO {
	
	private String TestCaseName;
	private String MethodName;
	private String Execute;
	private int rows;
	public String getTestCaseName() {
		return TestCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.TestCaseName = testCaseName;
	}
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		this.MethodName = methodName;
	}
	public String getExecute() {
		return Execute;
	}
	public void setExecute(String execute) {
		this.Execute = execute;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

}
