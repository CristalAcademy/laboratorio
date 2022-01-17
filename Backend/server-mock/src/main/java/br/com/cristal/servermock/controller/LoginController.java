package br.com.cristal.servermock.controller;

import br.com.cristal.servermock.model.LoginRequest;
import br.com.cristal.servermock.model.LoginResponse;
import br.com.cristal.servermock.model.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                LoginResponse
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .profile(Profile.CANDIDATO)
                        .nome(request.getNome())
                        .build()
        );
    }
}
