package dev.syntax.security.custom;

import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

// 1. 스프링 시큐리티가 생성해준 CsrfToken의 고유한 랜덤 값을 확인하기 위한 커스텀 필터 클래스
// 2. 직접 구현한 필터이기 때문에 Servlet에서 제공하는 Filter 인터페이스를 통해 구현해야함
// 3. 필터가 구현되었으면 SecurityFilterChain에 추가해야함
public class CsrfTokenLoggingFilter implements Filter {

    private Logger logger = Logger.getLogger(CsrfTokenLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // csrfFilter가 이 필터클래스보다 앞에서 토큰을 만들면, 뒤쪽 필터에서는 만든 토큰을 어떻게 참조??
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");

        logger.info("CSRF TOKEN: " + csrfToken.getToken());

        chain.doFilter(request, response);
    }
}