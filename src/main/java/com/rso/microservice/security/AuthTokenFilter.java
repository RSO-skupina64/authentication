package com.rso.microservice.security;

//public class AuthTokenFilter extends OncePerRequestFilter {
public class AuthTokenFilter {

//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            String jwt = parseJwt(request);
//            if (jwt != null && JwtUtils.validateJwtToken(jwt)) {
//                String username = JwtUtils.getUsernameFromJwtToken(jwt);
//
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            }
//        } catch (Exception e) {
//
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String parseJwt(HttpServletRequest request) {
//        String headerAuth = request.getHeader("Authorization");
//
//        if (headerAuth != null && !headerAuth.isBlank() && headerAuth.startsWith("Bearer")) {
//            return headerAuth.substring(7);
//        }
//        return null;
//    }

}
