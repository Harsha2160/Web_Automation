package com.MercuryTours.qa.RetryLogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
//Run-time Retry Logic
public class AnnotationTransformer implements IAnnotationTransformer {
@SuppressWarnings("rawtypes")

public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
{
	
annotation.setRetryAnalyzer(RetryAnalyzer.class);	
		
}
	

}
