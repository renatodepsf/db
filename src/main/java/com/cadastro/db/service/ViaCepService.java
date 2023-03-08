package com.cadastro.db.service;

import com.cadastro.db.domain.Endereco;
import com.cadastro.db.domain.ViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    @Autowired
    private RestTemplate restTemplate;
    private static Endereco endereco = new Endereco();

    public ViaCep buscarEnderecoPorCep(String cep) {
        ViaCep viaCep = restTemplate.getForObject(String.format("http://viacep.com.br/ws/%s/json", cep), ViaCep.class);
        return viaCep;
    }
}
