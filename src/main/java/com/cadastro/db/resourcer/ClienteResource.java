package com.cadastro.db.resourcer;

import com.cadastro.db.exception.ResourceNotFoundException;
import com.cadastro.db.domain.Cliente;
import com.cadastro.db.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping
public class ClienteResource {

    @Autowired
    ClienteRepository repositorio;

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
        return new ResponseEntity<List<Cliente>>(repositorio.findByNome(nome), HttpStatus.OK);
    }
    @GetMapping("clientes/cpfcnpj")
    public ResponseEntity<List<Cliente>> buscarClientePorCpfCnpj(@RequestParam String cpfcnpj) {
        return new ResponseEntity<List<Cliente>>(repositorio.findByCpfcnpj(cpfcnpj), HttpStatus.OK);
    }
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        cliente.setDataInsercao(Calendar.getInstance().getTime());
        return new ResponseEntity<>(repositorio.save(cliente), HttpStatus.OK);
    }
    @PutMapping("/clientes/{id}")
    public Cliente alterarDadosCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteNovo) {
        Cliente clienteAtual = repositorio.findById(id).get(); // retorna objeto por id
        BeanUtils.copyProperties(clienteNovo, clienteAtual, "id"); // copiar atributos entre objetos
        clienteAtual.setDataExclusao(Calendar.getInstance().getTime());
        return repositorio.save(clienteAtual);
    }

    @DeleteMapping("/clientes/{id}")
    public void deletarClientePorId(@PathVariable("id") Long id) {
        repositorio.deleteById(id);
    }
}