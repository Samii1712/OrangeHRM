package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


import pages.SearchAddedUSer;

public class MyListener implements ITestListener {

	@Override
    public void onTestFailure(ITestResult result) {
		
		SearchAddedUSer.captureRecord();
	}
	 @Override
	    public void onTestSuccess(ITestResult result) {
		SearchAddedUSer.captureRecord();
	}
}
