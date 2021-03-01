package br.com.divan.hoteldivan.service;

import java.util.List;

import br.com.divan.hoteldivan.model.entity.Lancamento;
import br.com.divan.hoteldivan.model.enums.StatusLancamento;

public interface LancamentoService {
	
	Lancamento salvar(Lancamento lancamento);
	Lancamento atualizar(Lancamento lancamento);
	void deletar(Lancamento lancamento);
	List<Lancamento> buscar(Lancamento lancamentoFiltro);
	void atualizarStatus(Lancamento lancamento, StatusLancamento status);
	void validar(Lancamento lancamento);

}
