package hh.swd20.bookstoremavenprojekti.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.bookstoremavenprojekti.domain.User;
import hh.swd20.bookstoremavenprojekti.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private final UserRepository urepository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository urepository ) {
		this.urepository = urepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		
		User curruser = urepository.findByUsername(user);
		UserDetails userDetail = new org.springframework.security.core.userdetails.User(user, curruser.getPasswordHash(),
			AuthorityUtils.createAuthorityList(curruser.getRole()));
		return userDetail;
	}
}
