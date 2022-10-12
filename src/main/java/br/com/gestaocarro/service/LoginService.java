package br.com.gestaocarro.service;

import br.com.gestaocarro.repository.LoginRepository;
import br.com.gestaocarro.domain.model.Login;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login save(Login login) {
        return loginRepository.save(login);
    }

    public void deleteById(UUID id) {
        loginRepository.deleteById(id);
    }

    public Login login(Login login) {
        return loginRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());
    }

    public void logoff(UUID id) {
    }

    public void active(UUID id) {
    }

    public void disable(UUID id) {
    }
}
