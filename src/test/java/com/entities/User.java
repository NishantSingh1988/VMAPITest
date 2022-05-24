package com.entities;

public class User {
	Profile profile;
	String Email;
	String password;
	String storeUUID;
	String locale;
	
	public User(String email, String password) {
		Email = email;
		this.password = password;
	}
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStoreUUID() {
		return storeUUID;
	}
	public void setStoreUUID(String storeUUID) {
		this.storeUUID = storeUUID;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}

}
