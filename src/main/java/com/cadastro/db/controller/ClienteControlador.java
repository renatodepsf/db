package com.cadastro.db.controller;

import com.cadastro.db.exception.ResourceNotFoundException;
import com.cadastro.db.model.Cliente;
import com.cadastro.db.repository.ClienteRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class ClienteControlador {

    @Autowired
    ClienteRepositorio repositorio;

    @GetMapping("/clientes") //buscar todos
    public List<Cliente> listaClientes() {
        return repositorio.findAll();
    }

    @GetMapping("clientes/{id}") //buscar por id
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
        Cliente cliente = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id: " + id));
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("clientes/nome")
    public ResponseEntity<List<Cliente>> buscarClientePorNome(@RequestParam String nome) {
        return new ResponseEntity<List<Cliente>>(repositorio.findByNome(nome), HttpStatus.MULTI_STATUS);
    }
    @GetMapping("clientes/cpfcnpj")
    public ResponseEntity<List<Cliente>> buscarClientePorCpfCnpj(@RequestParam String cpfcnpj) {
        return new ResponseEntity<List<Cliente>>(repositorio.findByCpfcnpj(cpfcnpj), HttpStatus.MULTI_STATUS);
    }
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(repositorio.save(cliente), HttpStatus.OK);
    }
    @PutMapping("/clientes/{id}")
    public Cliente alterarDadosCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteNovo) {
        Cliente clienteAtual = repositorio.findById(id).get(); // retorna objeto por id
        BeanUtils.copyProperties(clienteAtual, clienteNovo, "id"); // copiar atributos entre objetos
        return repositorio.save(clienteAtual);
    }

    @DeleteMapping("/clientes/{id}")
    public void deletarClientePorId(@PathVariable("id") Long id) {
        repositorio.deleteById(id);
    }
}