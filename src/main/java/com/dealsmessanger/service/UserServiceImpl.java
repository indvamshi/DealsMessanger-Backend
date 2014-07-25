package com.dealsmessanger.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dealsmessanger.model.Admin;
import com.dealsmessanger.model.Business;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		if (request.getParameter("merchant") != null) {
			final Business business = mongoTemplate.findOne(new Query(Criteria.where("name").
					is(userName)), Business.class);
			
			final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>() {{
	            add(new SimpleGrantedAuthority(business.getRole()));
	        }};
			return getUserDetails(business.getName(), business.getPassword(), grantedAuthorities);
		} 
		if (request.getParameter("admin") != null) {
			final Admin admin = mongoTemplate.findOne(new Query(Criteria.where("userName").
					is(userName)), Admin.class);
			
			final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>() {{
	            add(new SimpleGrantedAuthority(admin.getRole()));
	        }};
			return getUserDetails(admin.getUserName(), admin.getPassword(), grantedAuthorities);
		}
		
		return null;

	}

	private UserDetails getUserDetails(final String name, final String password,
			final List<GrantedAuthority> grantedAuthorities) {
		
	       final User authenticatedUser = new User("vchitti", "123", grantedAuthorities);
	        
	        return new UserDetails() {

				private static final long serialVersionUID = 1L;

				@Override
	            public Collection<? extends GrantedAuthority> getAuthorities() {
	                return grantedAuthorities;
	            }

	            @Override
	            public String getPassword() {
	                return null;
	            }

	            @Override
	            public String getUsername() {
	                return authenticatedUser.getUsername();
	            }

	            @Override
	            public boolean isAccountNonExpired() {
	                return true;
	            }

	            @Override
	            public boolean isAccountNonLocked() {
	                return true;
	            }

	            @Override
	            public boolean isCredentialsNonExpired() {
	                return true;
	            }

	            @Override
	            public boolean isEnabled() {
	                return true;
	            }
	        };
	}
	

}
