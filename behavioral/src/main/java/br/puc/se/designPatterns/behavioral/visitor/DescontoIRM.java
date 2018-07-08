package br.puc.se.designPatterns.behavioral.visitor;

public class DescontoIRM {

	private IRMTable table = new IRMTable();
	
	public void ajustaValor(Pagamento pagamento) {
		Float novoValor = pagamento.getValor() * (1 - table.getByType(pagamento.getTipoEntidade()));
		pagamento.setValor(novoValor);
	}

}
