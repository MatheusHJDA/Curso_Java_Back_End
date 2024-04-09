package com.example.dao;

import com.example.cadastrocliente.Cliente;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClienteMapDAO implements IClienteDAO{
    private Map<Long, Cliente> map;
    public ClienteMapDAO() {
        this.map = new TreeMap<>();
    }
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clientecadastrado = this.map.get(cpf);
        if (clientecadastrado != null){
            this.map.remove(clientecadastrado.getCpf(), clientecadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clientecadastrado = this.map.get(cliente.getCpf());
        if (clientecadastrado != null) {
            clientecadastrado.setNome(cliente.getNome());
            clientecadastrado.setCpf(cliente.getCpf());
            clientecadastrado.setEndereco(cliente.getEndereco());
            clientecadastrado.setNumero(cliente.getNumero());
        }

    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}