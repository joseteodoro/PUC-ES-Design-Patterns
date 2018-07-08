package br.puc.se.designPatterns.behavioral.visitor;

public class AjudaDeCusto {

	public void ajustaValor(Pagamento pagamento) {
		if (pagamento.getTipoEntidade() == ImpostoSobre.PESSOA_FISICA && pagamento.getValor() < 250.f) {
			pagamento.setValor(pagamento.getValor() * 1.1f);
		} else {
			pagamento.setValor(pagamento.getValor() * 0.98f);
		}
	}

}
