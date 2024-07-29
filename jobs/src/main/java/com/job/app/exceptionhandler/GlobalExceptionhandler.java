package com.job.app.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.job.app.constants.AppConstants;
import com.job.app.entity.ApiResponse;
import com.job.app.exception.AuthenticationFailedException;
import com.job.app.exception.EarlyProcessException;
import com.job.app.exception.ResourceNotFoundException;
import com.job.app.exception.ResourcesAlreadyExists;
import com.job.app.exception.UserAlreadyPresentException;
import com.job.app.exception.UserNotFoundException;


@ControllerAdvice
public class GlobalExceptionhandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, "404");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotvalidException(MethodArgumentNotValidException ex) {
		Map<String, String> res = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourcesAlreadyExists.class)
	public ResponseEntity<ApiResponse> resourceAlreadyExists(ResourcesAlreadyExists ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, "409");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.FOUND);

	}

	

	@ExceptionHandler(EarlyProcessException.class)
	public ResponseEntity<ApiResponse> earlyProcessException(EarlyProcessException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, "1008");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<ApiResponse> userAlreadyExists(UserAlreadyPresentException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, "409");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.FOUND);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFoundExceptionHandler(UserNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, "404");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthenticationFailedException.class)
	public ResponseEntity<ApiResponse> requestTimeOut(AuthenticationFailedException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, "401");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.UNAUTHORIZED);
	}

	

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiResponse> IllegalArgumentException(IllegalArgumentException ex) {
		ApiResponse apiResponse = new ApiResponse(AppConstants.SOMETHING_WENT_WRONG, false, "402");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.UNAUTHORIZED);
	}
}
