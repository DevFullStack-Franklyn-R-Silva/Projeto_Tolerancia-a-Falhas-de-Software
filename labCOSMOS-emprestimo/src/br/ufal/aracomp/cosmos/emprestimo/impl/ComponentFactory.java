package br.ufal.aracomp.cosmos.emprestimo.impl;

import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;

public class ComponentFactory {
	private static IManager manager = null;
	
	private ComponentFactory() {
		// faz nada - SINGLETON
	}
	
	//FACTORY METHOD
	public static IManager createInstance(){
		//SINGLETON
		if(manager == null)
			manager = new Manager();
		return manager;
	}
}
