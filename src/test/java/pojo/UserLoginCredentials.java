package pojo;

import TestData.LoginData;

public class UserLoginCredentials {
	public static LoginData LogInCredentials() {
		LoginData loginData = new LoginData();
		loginData.setUserEmail("bhatiamohak1702@gmail.com");
		loginData.setUserPassword("2204@50Mb");
		
		return loginData;
	}

}
