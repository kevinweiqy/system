package com.entor.utils;

import java.util.Set;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

public class JsonConfigUtils {

	public static JsonConfig getJsonConfig(){
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new 
				PropertyFilter() {
		    public boolean apply(Object source, 
		    		String name,
		      Object value) {
		     if(value!=null){
		      String typeName = value.getClass()
		      .getName();
		      if (typeName.
		    		  equals("org.hibernate.collection." +
		      		"PersistentSet")
		        ) {
		       return true;
		      }
		     }
		     return false;
		    }
		   });
		
		return jsonConfig;
	}
	
	
	public static JsonConfig getNoCycleJsonConfig(){
		JsonConfig config = new JsonConfig(); 
		config.setJsonPropertyFilter(new PropertyFilter() {  
		    public boolean apply(Object obj, String name, Object value) {  
		    if(value instanceof Set<?>){  
		        return true;  
		    }else{  
		        return false;  
		    }  
		   }  
		}); 

		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
		config.setExcludes(new String[]{"handler","hibernateLazyInitializer"}); 
	    return config;
	}
}
