package com.cadastro.db.resourcer;

import com.cadastro.db.domain.Cliente;
import com.cadastro.db.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class ClienteResource {
    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public List<Cliente> buscarTodosClientes() {
        return service.buscarTodosClientes();
    }

    @GetMapping("clientes/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
       return ResponseEntity.ok(service.buscarClientePorId(id));
    }

    @GetMapping("clientes/nome")
    public ResponseEntity<List<Cliente>> buscarClientePorNome(@RequestParam String nome) {
        return new ResponseEntity<>(service.buscarClientePorNome(nome), HttpStatus.OK);
    }

    @GetMapping("clientes/cpfcnpj")
    public ResponseEntity<List<Cliente>> buscarClientePorCpfCnpj(@RequestParam String cpfcnpj) {
        return new ResponseEntity<>(service.buscarClientePorCpfCnpj(cpfcnpj), HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(service.criarCliente(cliente), HttpStatus.OK);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> alterarClientePorId(@PathVariable("id") Long id, @RequestBody Cliente clienteNovo) {
        return new ResponseEntity<>(service.alterarClientePorId(id, clienteNovo), HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public void deletarClientePorId(@PathVariable("id") Long id) {
        service.deletarClientePorId(id);
    }
}