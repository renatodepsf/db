package com.cadastro.db.service;

import com.cadastro.db.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    @Autowired
    private RestTemplate restTemplate;

    public Endereco buscarEnderecoPorCep(String cep) {
        Endereco response = restTemplate.
                getForObject(String.format("http://viacep.com.br/ws/%s/json", cep), Endereco.class);
        return response;
    }
}
