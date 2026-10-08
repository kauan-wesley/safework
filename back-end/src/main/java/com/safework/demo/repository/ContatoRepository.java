package com.safework.demo.repository;

import com.safework.demo.model.Contato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}