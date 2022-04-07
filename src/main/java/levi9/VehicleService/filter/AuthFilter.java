package levi9.VehicleService.filter;

import levi9.UserService.api.UserServiceApi;
import levi9.VehicleService.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

    private final UserServiceApi userServiceApi;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getRequestURI().startsWith("/vehicle-socket-endpoint")){
            filterChain.doFilter(request, response);
            return;
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "authorization, content-type");
        response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE");

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        String token = request.getHeader("Authorization");
        if (token == null || !userServiceApi.isAuthenticated(token)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User is not authenticated");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
