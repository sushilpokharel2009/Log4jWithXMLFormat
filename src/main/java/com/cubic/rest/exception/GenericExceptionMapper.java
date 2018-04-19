package com.cubic.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cubic.rest.entity.ErrorInfo;

public class GenericExceptionMapper implements ExceptionMapper<Exception>{
	private final static Logger logger = LoggerFactory.getLogger(GenericExceptionMapper.class);
	
	
	@Override
	public Response toResponse(final Exception exception) {
		logger.error("Exception occured = {}",exception);
		final ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrCode("ERR-1000");
		errorInfo.setErrDesc(exception.getMessage());
		return Response.serverError().entity(errorInfo).build();
		
	}

	
}
