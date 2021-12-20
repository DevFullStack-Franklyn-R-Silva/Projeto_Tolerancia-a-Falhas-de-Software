package br.ufal.aracomp.cosmos.emprestimo.spec.req;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;

public interface ILimiteReq {
	public double estimarLimite(UsuarioDT usuario);
}
