package br.puc.se.designPatterns.behavioral.visitor;

import java.util.HashMap;
import java.util.Map;

/**
 * imposto de renda municipal :)
 * 
 * @author josets
 *
 */
public class IRMTable {

	private Map<ImpostoSobre, Float> feesByType;
	
	public IRMTable() {
		feesByType = new HashMap<>();
		feesByType.put(ImpostoSobre.ORGAO_GOVERNAMENTAL, 0.2f); //20% para orgao governamental
		// restante sao isentos
	}

	public Float getByType(ImpostoSobre entidade) {
		if (this.feesByType.containsKey(entidade)) {
			return this.feesByType.get(entidade);
		}
		return 0.f;
	}
	
}
