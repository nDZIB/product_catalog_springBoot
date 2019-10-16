package com.categoryservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class CategoryErrorController implements ErrorController{

	
	
	private String errorPath;
	@Override
	public String getErrorPath() {
		return "/category/error";
	}
	
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}
	
//	@GetMapping("/error")
//	public ResponseEntity<String> getError() {
//		return new ResponseEntity<String>("get error/category not found error", HttpStatus.NOT_FOUND);
//	}
//	
//	@PostMapping("/error") 
//	public ResponseEntity<String> postError() {
//		return new ResponseEntity<String>("post error/cannot add category", HttpStatus.BAD_REQUEST);
//	}
//	
//	@PutMapping("/error")
//	public ResponseEntity<String> putError() {
//		return new ResponseEntity<String>("put error/cannot find the specified category", HttpStatus.NOT_FOUND);
//	}
//	
//	@DeleteMapping("/error")
//	public ResponseEntity<String> deleteError() {
//		return new ResponseEntity<String>("delete error/cannot delete the specified category", HttpStatus.METHOD_NOT_ALLOWED);
//	}
	
	
	@RequestMapping("/error")
	  public String handleCategoryError(HttpServletRequest request) {
	      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
	      return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
	                      + "<div>Exception Message: <b>%s</b></div>"
	                      + "<div>Click here: <a href ='http://%s/swagger-ui.html'> FOR DOCUMENTATION</a></div><body></html>",
	              statusCode, exception==null? "N/A": exception.getMessage(), request.getHeader("host"));
	  }
}
