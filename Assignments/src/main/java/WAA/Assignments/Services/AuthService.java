package WAA.Assignments.Services;

import WAA.Assignments.DTO.LogIn.LogInResponseDTO;
import WAA.Assignments.DTO.LogIn.LoginRequestDTO;
import WAA.Assignments.DTO.LogIn.RefreshTokenRequestDTO;

public interface AuthService {

    LogInResponseDTO login(LoginRequestDTO loginRequest);
    LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest);
}
