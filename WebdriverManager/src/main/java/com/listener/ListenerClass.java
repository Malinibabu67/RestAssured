package com.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.basePackage.BaseClass;
import com.extentManager.ExtentManager;

public class ListenerClass extends ExtentManager implements ITestListener{

	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());

	}
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.INDIGO));
			String pathname = BaseClass.screenShot(BaseClass.driver, result.getName());
			try {
				test.addScreenCaptureFromPath(pathname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +  " - Test case Failed", ExtentColor.RED));
			String pathname = BaseClass.screenShot(BaseClass.driver, result.getName());
			try {
				test.addScreenCaptureFromPath(pathname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, "Test case skipped is " + result.getName());

		}
	}

}


