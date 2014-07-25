package com.dealsmessanger.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.dealsmessanger.service.UserServiceImpl;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserServiceImpl userService;
	
    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
    	
    	UserDetails principal = userService.loadUserByUsername(authentication.getName());
    	if (principal != null) {
    		final Authentication auth = new UsernamePasswordAuthenticationToken(principal, 
    				authentication.getCredentials().toString(), principal.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return auth;
    	} 
    	throw new BadCredentialsException("OOPS......check your login details.");
    	
        
/*        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        if (name.equals("admin") && password.equals("system")) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return auth;
        } else {
        	throw new BadCredentialsException("OOPS......check your login details.");
        }*/
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
