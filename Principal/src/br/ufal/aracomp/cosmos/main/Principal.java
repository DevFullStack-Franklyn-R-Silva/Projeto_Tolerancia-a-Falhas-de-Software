package br.ufal.aracomp.cosmos.main;

import java.util.Locale;

import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;
import br.ufal.aracomp.cosmos.limite3.spec.prov.ILimiteOps3;
import br.ufal.cosmos.connectorSimples.ConnectorEmprestimoLimite;

public class Principal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		// Configuracao arquitetural
		// instanciar o componente Emprestimo
		IManager compEmp = ComponentFactory.createInstance();

		// instanciar o componente limite
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory
				.createInstance();

		br.ufal.aracomp.cosmos.limite2.spec.prov.IManager compLimite2 = br.ufal.aracomp.cosmos.limite2.impl.ComponentFactory
				.createInstance();

		br.ufal.aracomp.cosmos.limite3.spec.prov.IManager compLimite3 = br.ufal.aracomp.cosmos.limite3.impl.ComponentFactory
				.createInstance();
		
		// instanciar o conectors
		ILimiteOps limiteOps;
		ILimiteOps2 limiteOps2;
		ILimiteOps3 limiteOps3;
		limiteOps = (ILimiteOps) compLimite.getProvidedInterface("ILimiteOps");
		limiteOps2 = (ILimiteOps2) compLimite2.getProvidedInterface("ILimiteOps2");
		limiteOps3 = (ILimiteOps3) compLimite3.getProvidedInterface("ILimiteOps3");
		
		ConnectorEmprestimoLimite conn = new ConnectorEmprestimoLimite(limiteOps, limiteOps2, limiteOps3);

		// fazer os "binding"
		compEmp.setRequiredInterface("ILimiteReq", conn);

		// EXECUTAR O SISTEMA
		// instanciar o componente Emprestimo
		IEmprestimoOps objEmpOps = (IEmprestimoOps) compEmp.getProvidedInterface("IEmprestimoOps");
		UsuarioDT usuario = new UsuarioDT();
		usuario.rendimentos = "1001";

		System.out.println(String.format("%.2f", objEmpOps.liberarEmprestimoAutomatico(usuario)));

		System.out.println("Reconfiguração Arquitetural em Realizada");
		compEmp.setRequiredInterface("IlimiteReq", null);
		System.out.println(String.format("%.2f", objEmpOps.liberarEmprestimoAutomatico(usuario)));

		// ====================================================================================================================

	}

}
