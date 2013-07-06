package br.edu.unoesc.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.model.Pessoa;
@SuppressWarnings("unused")

@Resource
public class PessoaController {

	public static List<Pessoa> pessoas = new ArrayList<>();
	private Result result;
	
	public PessoaController(Result result) {
		this.result = result;
	}
	
	@Path("/pessoa/lista")
	public void lista() {
		result.include("pessoas", pessoas);
	}
	
	@Post
	@Path("/pessoa/salvar")
	public void salvar(Pessoa pessoa) {
		// inclusão
		if (pessoa.getCodigo() ==  null) {
			pessoa.setCodigo(Long.valueOf(pessoas.size()));
			pessoas.add(pessoa);	
		} else { // alteração
			pessoas.set(posicao(pessoa.getCodigo()), pessoa);
		}
		result.redirectTo(this).lista();
	}
	
	
	@Path("/pessoa/formulario")
	public void formulario() {
		
	}
	
	private int posicao(Long codigo) {
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getCodigo().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}

	@Path("/pessoa/excluir/{pessoa.codigo}")
	public void excluir(Pessoa pessoa) {
		if (pessoa != null && pessoa.getCodigo() != null) {
			int posicao = posicao(pessoa.getCodigo());
			if (posicao != -1) {
				pessoas.remove(posicao);	
			}
		}
		result.redirectTo(this.getClass()).lista();
	}
	
}

/*
@Resource
public class PessoaController {

	public static List<Pessoa> pessoas = new ArrayList<>();
	private Result result;
	
	public PessoaController(Result result) {
		this.result = result;
	}
	
	@Path("/pessoa/lista")
	public void lista() {
		result.include("pessoas", pessoas);
	}
	
	private int posicao(Long codigo) {
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getCodigo().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}
	
	@Post
	@Path("/pessoa/salvar")
	public void salvar(Pessoa pessoa) {
		// inclusão
		if (pessoa.getCodigo() ==  null) {
			pessoa.setCodigo(Long.valueOf(pessoas.size()));
			pessoas.add(pessoa);	
		} else { // alteração
			pessoas.set(posicao(pessoa.getCodigo()), pessoa);
		}
		result.redirectTo(this.getClass()).lista();
	}
	
	@Path("/pessoa/excluir/{pessoa.codigo}")
	public void excluir(Pessoa pessoa) {
		if (pessoa != null && pessoa.getCodigo() != null) {
			int posicao = posicao(pessoa.getCodigo());
			if (posicao != -1) {
				pessoas.remove(posicao);	
			}
		}
		result.redirectTo(this.getClass()).lista();
	}
	
	@Path("/pessoa/formulario")
	public void formulario() {
		
	}
	
	@Path("/pessoa/editar/{pessoa.codigo}")
	public void editar(Pessoa pessoa) {
		Pessoa p = pessoas.get(pessoa.getCodigo().intValue());
		if (p != null) {
			result.include("pessoa", p);
		}
		result.redirectTo(this.getClass()).formulario();
	}
	
}
*/