package com.financas.pessoais.service;


import com.financas.pessoais.DTO.UsuarioDTO;
import com.financas.pessoais.DTO.UsuarioRespondeDTO;
import com.financas.pessoais.excecoes.CadastroUsuarioException;
import com.financas.pessoais.excecoes.UsuarioJaExisteException;
import com.financas.pessoais.model.Usuario;
import com.financas.pessoais.repository.UsuarioRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UsuarioRespondeDTO cadastrarUsuario(UsuarioDTO usuarioDTO) throws CadastroUsuarioException {
            validarUsuario(usuarioDTO);
            verificarEmailExistente(usuarioDTO.email());
            String senhaCodificada =  passwordEncoder.encode(usuarioDTO.senha());
            Usuario usuario = new Usuario(usuarioDTO.nome(), usuarioDTO.email(), senhaCodificada);
            usuarioRepository.save(usuario);

            UsuarioRespondeDTO usuarioRespondeDTO = new UsuarioRespondeDTO(usuarioDTO.nome(), usuarioDTO.email());
        return usuarioRespondeDTO;
    }

    private void validarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null || StringUtils.isBlank(usuarioDTO.nome()) ||
                StringUtils.isBlank(usuarioDTO.email()) || StringUtils.isBlank(usuarioDTO.senha())) {
            throw new CadastroUsuarioException("Todos os campos são obrigatórios");
        }
        if (usuarioDTO.senha().length() < 6){
            throw new CadastroUsuarioException("Senha deve ter no minimo 6 caracteres");
        }
    }

    private void verificarEmailExistente(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new UsuarioJaExisteException("Já existe um usuário com esse e-mail");
        }
    }

}
