package com.ibm.genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.thamesWater.dataModelHandler.ManageModelHandlerExecution;
import com.thamesWater.dataObject.ManageDTOExecution;

import Factory.ComplexReportFactory;

public class Listeners implements ITestListener,IAnnotationTransformer {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ComplexReportFactory.getResult(result);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ComplexReportFactory.getResult(result);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ComplexReportFactory.getResult(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		//ExtentReport.startReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//ExtentReport.endReport();
		
	}
	
	@SuppressWarnings( "rawtypes" )
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		List<String> activatedTest=new ArrayList<String>();;
		String tobeExecuted=null;
		
		List<ManageDTOExecution> list;
		list=ManageModelHandlerExecution.getDTOList("TestCaseName");
		
		for(ManageDTOExecution data:list) {
			tobeExecuted=data.getExecute();
			if(tobeExecuted.equalsIgnoreCase("YES")) {
				activatedTest.add(data.getMethodName());
			}
		}
		
		boolean flag=false;
		for(String tcName:activatedTest) {
			if(tcName.equalsIgnoreCase(testMethod.getName())) {
				flag=true;
				break;
			}
		}
		
		if(flag==false) {
			annotation.setEnabled(false);
		}else {
			annotation.setEnabled(true);
		}		
	}

}
