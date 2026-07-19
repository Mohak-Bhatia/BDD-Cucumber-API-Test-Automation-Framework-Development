package pojo;

import TestData.LoginData;

public class UserLoginCredentials {
	
	public static LoginData LoginCredentials() {
		LoginData loginData = new LoginData();
		loginData.setUserEmail(System.getenv("USER_EMAIL"));
		loginData.setUserPassword(System.getenv("USER_PASSWORD"));
		return loginData;
	}

}
