package pojo;

import propertiesFetcher.ConfigReader;

public class UserLoginCredentials {
	
	private String email;
	private String password;
		
	public UserLoginCredentials(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public static UserLoginCredentials LoginCredentials() {
		
		String email=ConfigReader.getProperty("user.email");
		String password=ConfigReader.getProperty("user.pasword");
		
		return new UserLoginCredentials(email,password);
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String toString() {
        return "UserLoginCredentials{" +
                "email='" + email + '\'' +
                ", password='***MASKED***'" +
                '}';
    }

}
