package WAA.Assignments.Services.Impl;

import WAA.Assignments.Reposotory.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService") // removing the name will generate an error,
// the system that will use this object won't be able to detairmen which object is the userDetails is it this one or the original one,
// so we have ot change th title to userDetails service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException, DataAccessException {
        var user = userRepo.findByEmail(s).get();
        var userDetails = new MyUserDetails(user);
        return userDetails;
    }
}
