package br.ufal.cosmos.connectorSimples;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite2.spec.dt.ClienteDT2;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;
import br.ufal.aracomp.cosmos.limite3.spec.dt.ClienteDT3;
import br.ufal.aracomp.cosmos.limite3.spec.prov.ILimiteOps3;
import br.ufal.cosmos.exceptions.ServicoNaoConfiavelException;

public class ConnectorEmprestimoLimite implements ILimiteReq {

	ILimiteOps limiteOps;

	ILimiteOps2 limiteOps2;

	ILimiteOps3 limiteOps3;

	public ConnectorEmprestimoLimite() {
	}

	public ConnectorEmprestimoLimite(ILimiteOps limiteOps) {
		this.limiteOps = limiteOps;
	}

	public ConnectorEmprestimoLimite(ILimiteOps2 limiteOps2) {
		this.limiteOps2 = limiteOps2;
	}

	public ConnectorEmprestimoLimite(ILimiteOps3 limiteOps3) {
		this.limiteOps3 = limiteOps3;
	}

	public ConnectorEmprestimoLimite(ILimiteOps limiteOps, ILimiteOps2 limiteOps2, ILimiteOps3 limiteOps3) {
		this.limiteOps = limiteOps;
		this.limiteOps2 = limiteOps2;
		this.limiteOps3 = limiteOps3;
	}

	@Override
	public double estimarLimite(UsuarioDT usuario) {
		ClienteDT cliente = new ClienteDT();
		cliente.salario = Double.parseDouble(usuario.rendimentos);

		ClienteDT2 cliente2 = new ClienteDT2();
		cliente2.salario = Double.parseDouble(usuario.rendimentos);

		ClienteDT3 cliente3 = new ClienteDT3();
		cliente3.salario = Double.parseDouble(usuario.rendimentos);

		double cli1 = this.limiteOps.calcularLimite(cliente);
		double cli2 = this.limiteOps2.calcularLimite(cliente2);
		double cli3 = this.limiteOps3.calcularLimite(cliente3);

		double diferenca = 0.0;
		final double porcentagem = 100.0;
		
		try {
			if (cli1 > cli2) {
				diferenca = ((cli1 - cli2) / cli2) * porcentagem;
				if (diferenca >= 0.0 && diferenca <= 5.0) {
					return (cli1 + cli2) / 2.0;
				}

			} else if (cli1 < cli2) {
				diferenca = ((cli2 - cli1) / cli1) * porcentagem;
				if (diferenca >= 0.0 && diferenca <= 5.0) {
					return (cli1 + cli2) / 2.0;
				}
			} else if (cli1 == cli2) {
				return (cli1 + cli2) / 2.0;
			}
			
			if (cli1 > cli3) {
				diferenca = ((cli1 - cli3) / cli3) * porcentagem;
				if (diferenca >= 0.0 && diferenca <= 5.0) {
					return (cli1 + cli3) / 2.0;
				}

			} else if (cli1 < cli3) {
				diferenca = ((cli3 - cli1) / cli1) * porcentagem;
				if (diferenca >= 0.0 && diferenca <= 5.0) {
					return (cli1 + cli3) / 2.0;
				}
			} else if (cli1 == cli3) {
				return (cli1 + cli3) / 2.0;
			}

			if (cli2 > cli3) {
				diferenca = ((cli2 - cli3) / cli3) * porcentagem;
				if (diferenca >= 0.0 && diferenca <= 5.0) {
					return (cli2 + cli3) / 2.0;
				}

			} else if (cli2 < cli3) {
				diferenca = ((cli3 - cli2) / cli2) * porcentagem;
				if (diferenca >= 0.0 && diferenca <= 5.0) {
					return (cli2 + cli3) / 2.0;
				}
			} else if (cli2 == cli3) {
				return (cli2 + cli3) / 2.0;
			}

			System.out.println("");
			System.err.println("Existe diferença de limites");
			throw new ServicoNaoConfiavelException("Error ao executar");

		} catch (ServicoNaoConfiavelException e) {
			throw new ServicoNaoConfiavelException(
					"ERROR: Serviço Não Confiável !\nSistema indisponível ! " + e.getMessage(), e.getCause());
		}
//O método getCause() da classe Throwable é o método embutido usado para retornar a causa desse lançamento ou nulo se a causa não puder ser determinada para a Exceção ocorrida.
	}

}
