package ru.sertok.security.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.sertok.security.token.TokenAuthentication;

import javax.servlet.*;
import java.io.IOException;
import java.util.Optional;

@Component
public class TokenAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Optional.ofNullable(servletRequest.getParameter("token")).ifPresent(token -> SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(token)));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
