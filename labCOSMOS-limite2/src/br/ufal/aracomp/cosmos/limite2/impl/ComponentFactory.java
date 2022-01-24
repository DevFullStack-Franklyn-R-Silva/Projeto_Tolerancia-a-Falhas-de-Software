package br.ufal.aracomp.cosmos.limite2.impl;

import br.ufal.aracomp.cosmos.limite2.spec.prov.IManager;

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
