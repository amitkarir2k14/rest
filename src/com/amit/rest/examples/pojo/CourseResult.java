package com.amit.rest.examples.pojo;

public enum CourseResult {

	Pass(1),Fail(0);
	
	private int result;

	CourseResult(int result){
		this.setResult(result);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
