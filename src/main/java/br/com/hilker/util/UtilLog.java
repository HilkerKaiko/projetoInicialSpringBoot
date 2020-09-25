package br.com.hilker.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UtilLog {

	   
	   public static Log getLog(){
	      return LogFactory.getLog(Thread.currentThread().getStackTrace()[2].getClassName()); 
	   }
	   
	}
