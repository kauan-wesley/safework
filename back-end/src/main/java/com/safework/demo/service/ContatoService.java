package com.safework.demo.service;

import com.safework.demo.model.Contato;
import com.safework.demo.repository.ContatoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public Optional<Contato> atualizar(Long id, Contato dados) {

        Optional<Contato> contatoEncontrado =
                contatoRepository.findById(id);

        if (contatoEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Contato contato = contatoEncontrado.get();

        contato.setNome(dados.getNome());
        contato.setEmail(dados.getEmail());
        contato.setEmpresa(dados.getEmpresa());
        contato.setMensagem(dados.getMensagem());

        return Optional.of(contatoRepository.save(contato));
    }

    public boolean excluir(Long id) {

        if (!contatoRepository.existsById(id)) {
            return false;
        }

        contatoRepository.deleteById(id);

        return true;
    }
}