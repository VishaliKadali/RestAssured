package hooks;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private int retryCount=0;
	private static final int maxRetryCount=3; //Number of retries

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
