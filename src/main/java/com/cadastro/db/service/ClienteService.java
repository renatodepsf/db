package com.cadastro.db.service;
import com.cadastro.db.domain.Cliente;
import com.cadastro.db.domain.Endereco;
import com.cadastro.db.domain.ViaCep;
import com.cadastro.db.exception.ResourceNotFoundException;
import com.cadastro.db.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    @Autowired
    ViaCepService cepService;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> buscarTodosClientes() {
        return repository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id: " + id));
        return cliente;
    }

    public List<Cliente> buscarClientePorNome(String nome) {
        return repository.findByNome(nome);
    }
    public List<Cliente> buscarClientePorCpfCnpj(String cpfcnpj) {
        return repository.findByCpfcnpj(cpfcnpj);
    }

    public Cliente criarCliente(Cliente cliente) {
        ViaCep viaCep1 = cepService.buscarEnderecoPorCep(cliente.getEndereco().getCep());
        Endereco endereco = new Endereco();
        endereco.setCep(viaCep1.getCep());
        endereco.setLogradouro(viaCep1.getLogradouro());
        endereco.setComplemento(viaCep1.getComplemento());
        endereco.setBairro(viaCep1.getBairro());
        endereco.setLocalidade(viaCep1.getLocalidade());
        endereco.setUf(viaCep1.getUf());
        cliente.setDataInsercao(Calendar.getInstance().getTime());
        cliente.setEndereco(endereco);
        return repository.save(cliente);
    }

    public Cliente alterarClientePorId(Long id, Cliente clienteNovo) {
        Cliente clienteAtual = repository.findById(id).get();
        BeanUtils.copyProperties(clienteNovo, clienteAtual, "id");
        clienteAtual.setDataAlteracao(Calendar.getInstance().getTime());
        return repository.save(clienteAtual);
    }

    public void deletarClientePorId(Long id) {
        repository.deleteById(id);
    }
}
