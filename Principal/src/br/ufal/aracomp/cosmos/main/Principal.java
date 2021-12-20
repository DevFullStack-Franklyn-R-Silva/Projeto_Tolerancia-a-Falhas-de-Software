package br.ufal.aracomp.cosmos.main;

import java.util.Locale;

import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.cosmos.connectorSimples.ConnectorSimples;

public class Principal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// Configuracao arquitetural

		// instanciar o componente Emprestimo
		IManager compEmp = ComponentFactory.createInstance();

		// instanciar o componente limite
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory
				.createInstance();

		// instanciar o conector
		ILimiteOps limiteOps;
		limiteOps = (ILimiteOps) compLimite.getProvidedInterface("ILimiteOps");
		ConnectorSimples conn = new ConnectorSimples(limiteOps);

		// fazer os "binding"
		compEmp.setRequiredInterface("ILimiteReq", conn);

		// EXECUTAR O SISTEMA
		// instanciar o componente Emprestimo
		IEmprestimoOps objEmpOps = (IEmprestimoOps) compEmp.getProvidedInterface("IEmprestimoOps");
		UsuarioDT usuario = new UsuarioDT();
		usuario.rendimentos = "1500";
		System.out.println(String.format("%.2f", objEmpOps.liberarEmprestimoAutomatico(usuario)));

		System.out.println("Reconfiguração Arquitetural em Realizada");
		compEmp.setRequiredInterface("IlimiteReq", null);
		System.out.println(String.format("%.2f", objEmpOps.liberarEmprestimoAutomatico(usuario)));
	}

}
