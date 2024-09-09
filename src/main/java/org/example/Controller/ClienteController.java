package org.example.Controller;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/agendamento")
public class ClienteController {
    Logger logger = LogManager.getLogger(this.getClass());
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Cliente cliente) {
        logger.info("Create acessado ClienteController");

        Cliente user = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
}
