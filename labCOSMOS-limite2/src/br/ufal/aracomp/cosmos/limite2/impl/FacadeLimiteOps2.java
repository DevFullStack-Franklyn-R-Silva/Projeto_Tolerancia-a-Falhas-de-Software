package br.ufal.aracomp.cosmos.limite2.impl;

import br.ufal.aracomp.cosmos.limite2.spec.dt.ClienteDT2;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;

class FacadeLimiteOps2 implements ILimiteOps2 {

	@Override
	/**
	 * 29% do salario do cliente Deve retornar valor >=0
	 */
	public double calcularLimite(ClienteDT2 client) {
		double limite = client.salario * 0.29;
		if (limite >= 0)
			return limite;
		else
			return 0;
	}

}
