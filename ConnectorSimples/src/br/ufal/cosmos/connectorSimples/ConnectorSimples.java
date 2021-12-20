package br.ufal.cosmos.connectorSimples;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

public class ConnectorSimples implements ILimiteReq {

	ILimiteOps limiteOps;

	public ConnectorSimples(ILimiteOps limiteOps) {
		this.limiteOps = limiteOps;
	}

	@Override
	public double estimarLimite(UsuarioDT usuario) {
		try {
			ClienteDT cliente = new ClienteDT();
			cliente.salario = Double.parseDouble(usuario.rendimentos);
			return this.limiteOps.calcularLimite(cliente);
		} catch (Exception e) {
			return 0;
		}
	}

}
