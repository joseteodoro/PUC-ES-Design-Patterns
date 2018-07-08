package br.puc.se.designPatterns.behavioral.visitor;

import java.util.HashMap;
import java.util.Map;

/**
 * imposto de renda estadual :)
 * 
 * @author josets
 *
 */
public class IRETable {

	private Map<ImpostoSobre, Float> feesByType;
	
	public IRETable() {
		feesByType = new HashMap<>();
		feesByType.put(ImpostoSobre.PESSOA_FISICA, 0.2f); //20% para pessoa fisica
		feesByType.put(ImpostoSobre.PESSOA_JURIDICA, 0.1f); //10% para pessoa jurica
		// ong e governo sao isentos
	}

	public Float getByType(ImpostoSobre entidade) {
		if (this.feesByType.containsKey(entidade)) {
			return this.feesByType.get(entidade);
		}
		return 0.f;
	}
	
}
