package ms.jiren.todo.security.controller.auth;

import lombok.RequiredArgsConstructor;
import ms.jiren.todo.security.controller.auth.dto.AuthResponse;
import ms.jiren.todo.security.controller.auth.dto.LoginRequest;
import ms.jiren.todo.security.controller.auth.dto.RegisterRequest;
import ms.jiren.todo.security.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
