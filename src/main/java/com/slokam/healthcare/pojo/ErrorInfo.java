package com.slokam.healthcare.pojo;

public class ErrorInfo {
	private Integer errorId;
	private String message;
	private Throwable Exception;
	
	public ErrorInfo() {
		
	}
	public ErrorInfo(Integer errorId, String message, Throwable exception) {
		super();
		this.errorId = errorId;
		this.message = message;
		Exception = exception;
	}
	public Integer getErrorId() {
		return errorId;
	}
	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getException() {
		return Exception;
	}
	public void setException(Throwable exception) {
		Exception = exception;
	}

}
