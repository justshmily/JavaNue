package test2;

import org.apache.log4j.Logger;

public class Login {

	private static Logger log=Logger.getLogger(Login.class);
	
	public boolean login(String user,String password) {
		log.debug("user:"+user);
		log.debug("password:"+password);
		
		if("root".equals(user)&&"root".equals(password)) {
			log.info("登录成功");
			return true;
		}
		log.info("登录失败");
		return false;
	}
}
