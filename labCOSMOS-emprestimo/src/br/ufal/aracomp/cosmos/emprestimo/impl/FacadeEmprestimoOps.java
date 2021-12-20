package br.ufal.aracomp.cosmos.emprestimo.impl;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;

class FacadeEmprestimoOps implements IEmprestimoOps {
	private IManager manager;
	private ILimiteReq intReq;
	
	public FacadeEmprestimoOps(IManager manager) {
		this.manager = manager;
	}
	
	@Override
	/**
	 * Se rendimento do cliente for maior que 1000
	 * Emprestar 90% do limite de emprestimo
	 * Caso contrario, retorna 0
	 */
	public double liberarEmprestimoAutomatico(UsuarioDT client) {
		try{
			double rendimento = 0;
			try{
				rendimento = Double.parseDouble(client.rendimentos);
			}
			catch(NumberFormatException e){
				System.err.println("Tratamento 1...");
				client.rendimentos = client.rendimentos.replaceAll(",", ".");
				rendimento = Double.parseDouble(client.rendimentos);
				System.out.println("Tratado com sucesso!");
			}
			if(rendimento>1000){
				this.intReq = (ILimiteReq)manager.getRequiredInterface("ILimiteReq");
				double limite = intReq.estimarLimite(client);
				return limite * 0.9;
			}
		}
		catch(NumberFormatException e){
			System.out.println("NUMERO ERRADO!!!");
		//	e.printStackTrace();
		}
		return 0;
	}

}
