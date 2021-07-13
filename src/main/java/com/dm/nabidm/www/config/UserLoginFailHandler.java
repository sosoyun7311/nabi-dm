package com.dm.nabidm.www.config;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserLoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		if (exception instanceof AuthenticationServiceException) {
			// request.setAttribute("msg", "존재하지 않는 사용자입니다.");
			request.setAttribute("msg", "10");
		} else if (exception instanceof BadCredentialsException) {
			// request.setAttribute("msg", "아이디 또는 비밀번호가 틀립니다.");
			request.setAttribute("msg", "10");
		} else if (exception instanceof LockedException) {
			// request.setAttribute("msg", "잠긴 계정입니다..");
			request.setAttribute("msg", "99");
		} else if (exception instanceof DisabledException) {
			// request.setAttribute("msg", "비활성화된 계정입니다..");
			request.setAttribute("msg", "99");

		} else if (exception instanceof AccountExpiredException) {
			// request.setAttribute("msg", "만료된 계정입니다..");
			request.setAttribute("msg", "99");
		} else if (exception instanceof CredentialsExpiredException) {
			// request.setAttribute("msg", "비밀번호가 만료되었습니다.");
			request.setAttribute("msg", "99");
		} else {
			request.setAttribute("msg", "99");
		}

		super.setDefaultFailureUrl("/");
		super.onAuthenticationFailure(request, response, exception);

	}
}
