package br.puc.se.designPatterns.behavioral.visitor;

public class DescontoIRE {

	private IRETable table = new IRETable();
	
	public void ajustaValor(Pagamento pagamento) {
		Float novoValor = pagamento.getValor() * (1 - table.getByType(pagamento.getTipoEntidade()));
		pagamento.setValor(novoValor);
	}

}
