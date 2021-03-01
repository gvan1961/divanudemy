package br.com.divan.hoteldivan.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divan.hoteldivan.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento,Long>{

}
