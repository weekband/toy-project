package com.kh.toy.common.code;

public enum Config {
	
	//DOMAIN(WWW.NAVER.COM)
	SNTP_AUTHENTICATION_ID("gyqja15@gmail.com"),
	SNTP_AUTHENTICATION_PASSWORD("dlwmfldjf150"),
	COMPANY_EMAIL("gyqja15@gmail.com"),
	//UPLOAD_PATH("C:\\CODE\\upload\\"); 운영서버
	UPLOAD_PATH("C:\\CODE\\upload\\"); //개발서버
	
	public final String DESC;
	
	private Config(String desc) {
		this.DESC = desc;
	}
}
