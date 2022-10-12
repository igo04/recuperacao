package br.com.gestaocarro.app.controller;

import br.com.gestaocarro.domain.model.Carro;
import br.com.gestaocarro.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "rh")
@Tag(name = "RH Controller", description = "Controladora que gere o cadastro de carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController(CarroService celularService, CarroService carroService){
        this.carroService = carroService;

    }

    @PostMapping(value = "/carro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um carro", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Carro> save(@RequestBody Carro carro) {
        return new ResponseEntity<>(carroService.save(carro), CREATED);
    }

    @GetMapping(value = "/carro", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lista de carros", responses = {@ApiResponse(description = "Sucesso ao listar os carros", responseCode = "200", content = @Content)})
    ResponseEntity<List<Carro>> findAll() {
        return new ResponseEntity<>(carroService.findAll(), OK);
    }

    @GetMapping(value = "/carro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Localiza um cadastro de carro por ID", responses = {@ApiResponse(description = "Sucesso ao consultar o cadastro", responseCode = "200", content = @Content)})
    ResponseEntity<Carro> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(carroService.findById(id), OK);
    }

    @PutMapping(value = "/carro", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualiza carro", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> update(@RequestBody Carro carro) {
        CarroService.save(carro);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/carro/{id}")
    @Operation(summary = "Exclui um cadastro de carro pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar o cadastro", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        carroService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
    @PatchMapping(value = "/carro/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar preço do carro", responses = {@ApiResponse(description = "Preço do carro", responseCode = "201", content = @Content)})
    ResponseEntity<?> updatePreco(@PathVariable UUID id, @RequestBody float preco) {
        carroService.update(id, preco);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
