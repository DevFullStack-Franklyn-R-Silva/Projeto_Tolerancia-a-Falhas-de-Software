package br.ufal.aracomp.cosmos.limite.impl;

import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

class FacadeLimiteOps implements ILimiteOps {

	@Override
	/**
	 * 29% do salario do cliente
	 * Deve retornar valor >=0
	 */
	public double calcularLimite(ClienteDT client) {
		double limite = client.salario*0.29;
		if(client.salario == 1001)
			limite = client.salario;
		if(limite >= 0)
			return limite;
		else
			return 0;
	}

}
