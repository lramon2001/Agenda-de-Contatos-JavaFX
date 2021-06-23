package repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entidades.Contato;
import repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorio  implements AgendaRepositorio<Contato> {
    private static List<Contato> listaContatos = new ArrayList<Contato>();
    
	@Override
	public List<Contato> selecionar() {	
		return listaContatos;
	}

	@Override
	public void inserir(Contato entidade) {
    listaContatos.add(entidade);
		
	}

	@Override
	public void atualizar(Contato entidade) {
		var original = listaContatos.stream().filter(contato -> contato.getNome().equals(entidade.getNome())).findFirst();
		if (original.isPresent()) {
			original.get().setIdade(entidade.getIdade());
			original.get().setTelefone(entidade.getTelefone());
		}
	}

	@Override
	public void excluir(Contato entidade) {
		listaContatos.remove(entidade);
		
	}
	

}
