package br.ufal.aracomp.cosmos.emprestimo.spec.prov;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;

public interface IEmprestimoOps {
	public double liberarEmprestimoAutomatico(UsuarioDT client);
}
