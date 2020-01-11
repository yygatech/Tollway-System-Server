package dev.ericyao.tollway.server.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController implements ErrorController {
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if (status != null) {
			int code = Integer.parseInt(status.toString());
			
			if (code == HttpStatus.NOT_FOUND.value()) {
				return "error/error-404";
			} else if (code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error/error-500";
			} else if (code == HttpStatus.FORBIDDEN.value()) {
				return "error/error-403";
			}
		}
		return "error/error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	
}
