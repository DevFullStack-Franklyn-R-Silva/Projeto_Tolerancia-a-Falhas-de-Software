package br.ufal.aracomp.cosmos.limite.impl;

import java.util.HashMap;
import java.util.Set;

import br.ufal.aracomp.cosmos.limite.spec.prov.IManager;

class Manager implements IManager {
	private HashMap<String, Object> providedInterfaces;
	private HashMap<String, Object> requiredInterfaces;

	//CONSTRUCTOR
	Manager() {
		this.providedInterfaces = new HashMap<>();
		this.requiredInterfaces = new HashMap<>();
		//add provided interfaces
		this.providedInterfaces.put("ILimiteOps", new FacadeLimiteOps());
	}
	
	
	@Override
	public Set<String> getProvidedInterfaces() {
		return this.providedInterfaces.keySet();
	}

	@Override
	public Set<String> getRequiredInterfaces() {
		return this.requiredInterfaces.keySet();
	}

	@Override
	public Object getProvidedInterface(String interfaceName) {
		return this.providedInterfaces.get(interfaceName);
	}

	@Override
	public void setRequiredInterface(String interfaceName, Object interfaceObject) {
		this.requiredInterfaces.put(interfaceName, interfaceObject);
	}
	
	@Override
	public Object getRequiredInterface(String interfaceName) {
		return this.requiredInterfaces.get(interfaceName);
	}

}
