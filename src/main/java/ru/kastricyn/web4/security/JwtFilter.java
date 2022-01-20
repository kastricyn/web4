package ru.kastricyn.web4.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.kastricyn.web4.exception.BaseException;
import ru.kastricyn.web4.exception.WrongTokenException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class JwtFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    private final List<AntPathRequestMatcher> noFilterPath = Arrays.asList(
            new AntPathRequestMatcher("/*"),
            new AntPathRequestMatcher("/index.html"),
            new AntPathRequestMatcher("/login"),
            new AntPathRequestMatcher("/resources/**"),
            new AntPathRequestMatcher("/api/users/**"),
            new AntPathRequestMatcher("/echo"));

    public JwtFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws IOException {
        try {
            if (noFilterPath.stream().anyMatch(path -> path.matches(request))) {
                filterChain.doFilter(request, response);
            } else {
                String token = jwtTokenProvider.resolveToken(request);
                if (token != null && jwtTokenProvider.validateToken(token)) {
                    Authentication auth = jwtTokenProvider.getAuthentication(token);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    filterChain.doFilter(request, response);
                } else {
                    throw new WrongTokenException("Истекший или несуществующий JWT токен");
                }
            }
        } catch (BaseException e) {
            handleBaseApiException(e, response);
        } catch (Exception e) {
            handleException(e, HttpServletResponse.SC_BAD_REQUEST, "BAD_REQUEST_ERROR", response);
        }
    }

    private void handleBaseApiException(BaseException exception, HttpServletResponse res) throws IOException {
        handleException(exception, exception.getHttpStatus().value(), exception.getErrorCode(), res);
    }

    private void handleException(Exception exception, int status, String errorCode, HttpServletResponse res) throws IOException {
        SecurityContextHolder.clearContext();
        res.resetBuffer();
        res.setCharacterEncoding("UTF-8");
        res.setStatus(status);
        res.setHeader("Content-Type", "application/json");
        PrintWriter out = res.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        message.put("errorCode", errorCode);
        message.put("message", exception.getMessage());
        out.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message));
    }
}
