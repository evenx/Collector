package com.fountontec.collector.common;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class ValidatorUtils {

	private static ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	
	public static ValidatorFactory getFatory(){
		return vf;
	}
	
}
