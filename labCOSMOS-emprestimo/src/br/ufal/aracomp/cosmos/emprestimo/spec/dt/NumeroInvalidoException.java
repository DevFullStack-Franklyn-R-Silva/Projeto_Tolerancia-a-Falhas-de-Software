package br.ufal.aracomp.cosmos.emprestimo.spec.dt;

public class NumeroInvalidoException extends Exception {
	private static final long serialVersionUID = -837659900983918627L;
	
	public NumeroInvalidoException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}
}
