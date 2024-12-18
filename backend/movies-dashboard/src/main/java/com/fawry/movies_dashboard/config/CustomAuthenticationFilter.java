//package com.fawry.movies_dashboard.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.Scanner;
//
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super.setAuthenticationManager(authenticationManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        if ("application/json".equalsIgnoreCase(request.getContentType())) {
//            try {
//                // Read the input stream and parse it as a String
//                Scanner scanner = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
//                String requestBody = scanner.hasNext() ? scanner.next() : "";
//
//                // Validate the request body is not empty
//                if (requestBody.trim().isEmpty()) { // Use trim().isEmpty() instead of isBlank()
//                    throw new RuntimeException("Request body is empty");
//                }
//
//                // Parse the JSON into a Map
//                Map<String, String> credentials = objectMapper.readValue(requestBody, Map.class);
//
//                // Validate the presence of "username" and "password"
//                String username = credentials.get("username");
//                String password = credentials.get("password");
//                if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
//                    throw new RuntimeException("Missing required fields: 'username' or 'password'");
//                }
//
//                // Create the authentication token
//                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
//                setDetails(request, authRequest);
//                return this.getAuthenticationManager().authenticate(authRequest);
//
//            } catch (Exception e) {
//                // Handle parsing errors or validation issues
//                throw new RuntimeException("Failed to parse or validate authentication request body", e);
//            }
//        }
//
//        // Handle invalid content type
//        try {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("{\"error\":\"Invalid content type. Please use application/json.\"}");
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to write error response", e);
//        }
//
//        return null;
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("application/json");
//        response.getWriter().write("{\"status\":\"success\"}");
//    }
//}