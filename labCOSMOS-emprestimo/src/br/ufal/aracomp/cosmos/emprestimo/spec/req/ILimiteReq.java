package br.ufal.aracomp.cosmos.emprestimo.spec.req;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;

public interface ILimiteReq {
	double estimarLimite(UsuarioDT usuario);

}
