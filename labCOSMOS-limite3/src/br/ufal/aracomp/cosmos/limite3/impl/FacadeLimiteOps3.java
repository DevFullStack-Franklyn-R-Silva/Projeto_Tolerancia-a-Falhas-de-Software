package br.ufal.aracomp.cosmos.limite3.impl;

import br.ufal.aracomp.cosmos.limite3.spec.dt.ClienteDT3;
import br.ufal.aracomp.cosmos.limite3.spec.prov.ILimiteOps3;

class FacadeLimiteOps3 implements ILimiteOps3 {

	@Override
	/**
	 * 30% do salario do cliente
	 * Deve retornar valor >=0
	 */
	public double calcularLimite(ClienteDT3 client) {
		double limite = client.salario*0.30;
		if(limite >= 0)
			return limite;
		else
			return 0;
	}

}
