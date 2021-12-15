package com.in28minutes.rest.webservices.restfulwebservices.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author a13400520
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class BaseResponse<T> {

	private String message;

	private Integer errorCode;

	private T body;

	public BaseResponse(String message, Integer errorCode, T body) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.body = body;
	}
	public BaseResponse(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer statusCode) {
		this.errorCode = statusCode;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "BaseResponse [message=" + message + ", errorCode=" + errorCode + ", body=" + body + "]";
	}

}
