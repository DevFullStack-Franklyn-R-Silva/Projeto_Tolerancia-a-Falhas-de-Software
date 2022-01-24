package br.ufal.cosmos.exceptions;

public class ServicoNaoConfiavelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServicoNaoConfiavelException(String msg) {
		super(msg);
	}

	public ServicoNaoConfiavelException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
