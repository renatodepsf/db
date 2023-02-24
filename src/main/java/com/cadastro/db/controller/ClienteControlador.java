package com.cadastro.db.controller;

import com.cadastro.db.exception.ResourceNotFoundException;
import com.cadastro.db.model.Cliente;
import com.cadastro.db.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    ClienteRepositorio repositorio;

    @GetMapping("") //buscar todos
    public List<Cliente> listaClientes() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}") //buscar por id
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
        Cliente cliente = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id: " + id));
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{nome}")
    public List<Cliente> buscarClientePorNome(@RequestParam(value="nome")String nome) {
        return repositorio.findByNome(nome);
    }

    @PostMapping //salvar clientes
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        cliente.setDataInsercao(new Date());
        return repositorio.save(cliente);
    }

    @DeleteMapping("{id}")
    public void deletarClientePorId(@PathVariable("id") Long id) {
        repositorio.deleteById(id);
        Cliente cliente = new Cliente();
        cliente.setDataExclusao(new Date());
    }

    /*
    @GetMapping("clientes/IdNomeCpf")
    public ResponseEntity<Cliente> buscarClientePorIdNomeCpf(Cliente cliente) throws Throwable {
        if (cliente.getId() != null) {
            cliente = (Cliente) repositorio.findAll().stream().filter(p -> p.getId() != null);
        }
        return ResponseEntity.ok(cliente);
    }*/
}