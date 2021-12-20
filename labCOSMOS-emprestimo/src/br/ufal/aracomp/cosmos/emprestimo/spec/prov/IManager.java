package br.ufal.aracomp.cosmos.emprestimo.spec.prov;

import java.util.Set;

public interface IManager {
	
	public Set<String> getProvidedInterfaces();
	public Set<String> getRequiredInterfaces();
	public Object getProvidedInterface(String interfaceName);
	public void setRequiredInterface(String interfaceName, Object interfaceObject);
	public Object getRequiredInterface(String interfaceName);
}
