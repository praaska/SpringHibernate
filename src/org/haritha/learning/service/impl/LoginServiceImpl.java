package org.haritha.learning.service.impl;

import org.haritha.learning.jpa.dao.JpaLoginDao;
import org.haritha.learning.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private JpaLoginDao jpaLoginDao;
	
	public JpaLoginDao getJpaLoginDao() {
		return jpaLoginDao;
	}

	public void setJpaLoginDao(JpaLoginDao jpaLoginDao) {
		this.jpaLoginDao = jpaLoginDao;
	}

	/*private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
*/
	@Override
	public boolean isValidUser(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("In login service method");
		return jpaLoginDao.isValidUser(username, password);
	}
	

}
