package com.cadastro.db.service;

import com.cadastro.db.domain.EnderecoViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoViaCepService {

    @Autowired
    private RestTemplate restTemplate;

    public EnderecoViaCep buscarEnderecoPorCep(String cep) {
        EnderecoViaCep response = restTemplate.
                getForObject(String.format("http://viacep.com.br/ws/%s/json", cep), EnderecoViaCep.class);
        return response;
    }
}
