package com.slokam.healthcare.pojo.ErrorInform;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.healthcare.Exception.HealthCareException;
import com.slokam.healthcare.pojo.ErrorInfo;
@RestControllerAdvice
public class HealthCareExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo>handleException(Exception e){
		ErrorInfo ei=new ErrorInfo();
		ei.setErrorId(345);
		ei.setException(e);
		ei.setMessage("application went wrong");
		return new ResponseEntity<ErrorInfo>(ei,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(HealthCareException.class)
	public ResponseEntity<ErrorInfo>handleHealthCare(HealthCareException e){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorId(errorInfo.getErrorId());
		errorInfo.setMessage(errorInfo.getMessage());
		errorInfo.setException(e);
	    return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
