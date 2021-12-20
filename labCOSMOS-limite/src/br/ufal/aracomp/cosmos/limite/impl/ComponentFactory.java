package br.ufal.aracomp.cosmos.limite.impl;

import br.ufal.aracomp.cosmos.limite.spec.prov.IManager;

public class ComponentFactory {
	private static IManager manager = null;
	
	private ComponentFactory() {
		// fazer nada
	}
	
	public static IManager createInstance(){
		if(manager == null)
			manager = new Manager();
		return manager;
	}
}
