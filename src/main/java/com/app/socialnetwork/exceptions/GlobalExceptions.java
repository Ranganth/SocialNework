package com.app.socialnetwork.exceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import javassist.tools.web.BadHttpRequest;
@ControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler  {

	//Handled Custom studentNotFound Exception
		public ResponseEntity<String> handleStudentNotFoundException(NoSuchStudentException e)
		{
			return new ResponseEntity<String>("Student  with the given Id not found", HttpStatus.NOT_FOUND);
		}
		
		//Handled Inbuilt No Such friend Exception
		public ResponseEntity<String> handleFriendNotFoundException(NoSuchFriendException e)
		{
			return new ResponseEntity<String>("Entered Value not present, Please change your Request",HttpStatus.NOT_FOUND);
		}
		//Handled Inbuilt No Such friend Exception
				public ResponseEntity<String> handleNotFoundPermissionException(NoSuchPermissionException e)
				{
					return new ResponseEntity<String>("Entered Permission not present, Please change your Request",HttpStatus.NOT_FOUND);
				}
				
				//Handled Inbuilt No Such friend Exception
				public ResponseEntity<String> handleNotFoundFriendException(NoSuchFriendException e)
				{
					return new ResponseEntity<String>("Entered Value not present, Please change your Request",HttpStatus.NOT_FOUND);
				}
				//Handled Inbuilt No Such friend Exception
						public ResponseEntity<String> handleNotFoundMessageException(NoSuchMessageException e)
						{
							return new ResponseEntity<String>("Entered Permission not present, Please change your Request",HttpStatus.NOT_FOUND);
						}
						
		//Handled Method Not Supported Exception
		@Override
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) 
		{
			return new ResponseEntity<Object>("Please change http method type", HttpStatus.NOT_FOUND);
		}
		
		//Handled Inbuilt NullPointer Exception
		public ResponseEntity<String> handleNullPointerException(NullPointerException e)
		{
			return new ResponseEntity<String>("Null Value Found", HttpStatus.BAD_REQUEST);
		}
		
		//Handled No handler found Exception
		@Override
		protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
				HttpStatus status, WebRequest request) {
			return new ResponseEntity<Object>("Please Enter the Correct Input",HttpStatus.BAD_REQUEST);
		}
}
