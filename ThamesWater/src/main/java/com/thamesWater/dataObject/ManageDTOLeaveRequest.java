package com.thamesWater.dataObject;

public class ManageDTOLeaveRequest implements ManageDTO {
	private String TestCase;
	private String RequestType;
	private String StartDate;
	private String EndDate;
	private String Note;
	private String IlnessCode;
	private String CertificationDate;
	private String ReportedOn;
	

	public String getTestCase() {
		return TestCase;
	}

	public void setTestCase(String testCase) {
		this.TestCase = testCase;
	}

	public String getRequestType() {
		return RequestType;
	}

	public void setRequestType(String requestType) {
		this.RequestType = requestType;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		this.StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		this.EndDate = endDate;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		this.Note = note;
	}

	public String getIlnessCode() {
		return IlnessCode;
	}

	public void setIlnessCode(String ilnessCode) {
		this.IlnessCode = ilnessCode;
	}

	public String getCertificationDate() {
		return CertificationDate;
	}

	public void setCertificationDate(String certificationDate) {
		this.CertificationDate = certificationDate;
	}

	public String getReportedOn() {
		return ReportedOn;
	}

	public void setReportedOn(String reportedOn) {
		this.ReportedOn = reportedOn;
	}
}
