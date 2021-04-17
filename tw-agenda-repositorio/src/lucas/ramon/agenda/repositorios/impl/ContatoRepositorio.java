package lucas.ramon.agenda.repositorios.impl;

import java.util.ArrayList;
import java.util.List;


import lucas.ramon.agenda.repositorios.interfaces.AgendaRepositorio;
import lucasramon.agenda.entidades.Contato;

public class ContatoRepositorio implements AgendaRepositorio<Contato>{
	
	private static List<Contato> contatos =new ArrayList<Contato>();

	@Override
	public List<Contato> selecionar() {
		
		return contatos;
	}

	@Override
	public void inserir(Contato entidade) {
	    contatos.add(entidade);
		
	}

	@Override
	public void atualizar(Contato entidade) {
		var original = contatos.stream().filter(contato -> contato.getName().equals(entidade.getName())).findFirst();
		if (original.isPresent()) {
			original.get().setOld(entidade.getOld());
			original.get().setTelephone(entidade.getTelephone());
		}
	}

	@Override
	public void excluir(Contato entidade) {
		contatos.remove(entidade);
		
	}

}
