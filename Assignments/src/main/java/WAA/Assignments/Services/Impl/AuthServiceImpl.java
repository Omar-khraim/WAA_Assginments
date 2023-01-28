package WAA.Assignments.Services.Impl;

import WAA.Assignments.Utility.JwtUtil;
import WAA.Assignments.DTO.LogIn.LogInResponseDTO;
import WAA.Assignments.DTO.LogIn.LoginRequestDTO;
import WAA.Assignments.DTO.LogIn.RefreshTokenRequestDTO;
import WAA.Assignments.Services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    @Override
    public LogInResponseDTO login(LoginRequestDTO loginRequest) {

        // data type from security dependency
        Authentication result = null;

        try{
            // Authentication manager is an interface that comes with spring security authentication package
            result = authenticationManager.authenticate(
                    // also comes with spring security
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        }
        catch (BadCredentialsException e ){
            throw new BadCredentialsException(e.getMessage());
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
        final String accessToken =  jwtUtil.generateToken(userDetails);

        return new LogInResponseDTO(accessToken);
    }

    @Override
    public LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest) {
        return null;
    }
}
