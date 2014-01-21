package com.lmzy.core.util.validate;

public class ValidateUtil {
	public static boolean validateIsNull(String param){
		if("".equals(param)||param==null)
			return true;
		else
			return false;
	}
}
