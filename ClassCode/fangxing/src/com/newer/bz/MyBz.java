package com.newer.bz;

import org.apache.log4j.Logger;

public class MyBz {
	
	private static Logger log=Logger.getLogger(MyBz.class);
	
	
	public boolean login(String user,String password){
		
		log.debug("user:"+user);
		log.debug("password:"+password);
		
		if("root".equals(user)&&"root".equals(password)){
			log.info("µÇÂ¼³É¹¦");
			return true;
		}
		log.info("µÇÂ¼Ê§°Ü");
		return false;
	}

	
}
