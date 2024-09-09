package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

     private static final Logger logger = LogManager.getLogger(UsuarioController.class);
     private final  UsuarioController usuarioService;

     @PostMapping
    public ResponseEntity<Object> create(@RequestBody Usuario usuario){}
    logger.info("Requisição para criar usuário recebida");
    try{
        Usuario user = usuarioService.salvar(usuario);
        logger.info("Usuário criado com sucesso: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    } catch (Exception e) {
        logger.error("Erro ao criar usuário: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário: " + e.getMessage());
    }

}
@GetMapping("/{id}")
public ResponseEntity<Object>getById(@PathVariable Long id){
    logger.info("Requisição para buscar usuário por ID recebida: {}", id);
    try{
        Usuario user = usuarioService.buscarPorId(id);
        if(user == null){
            logger.warn("Usuário não encontrado: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        logger.info("Usuário encontrado: {}", user);
        return ResponseEntity.ok(user);
    } catch (Exception e){
        logger.error("Erro ao buscar usuário por ID: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuário: " + e.getMessage());
    }
}
@PostMapping("/login")
public ResponseEntity<Object> login(@RequestBody Usuario usuario){
    logger.info("Requisição para login recebida");

    try{
        // Verificar se o email e a senha foram fornecidos
        if(usuario.getEmail() == null || usuario.getSenha() == null){
            logger.warn("Email ou senha não fornecidos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email e senha são obrigatórios");
        }
        Usuario user = usuarioService.login(usuario.getEmail(), usuario.getSenha());
        if(user == null){
            logger.warn("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        logger.info("Usuário logado com sucesso: {}", user);
        return ResponseEntity.ok(user);
    } catch (Exception e){
        logger.error("Erro ao fazer login: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao fazer login: " + e.getMessage());
    }
}
}