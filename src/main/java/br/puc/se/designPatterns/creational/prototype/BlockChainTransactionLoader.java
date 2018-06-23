package br.puc.se.designPatterns.creational.prototype;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlockChainTransactionLoader {
	
	Map<String, List<UserTransaction>> cache;
	
	public BlockChainTransactionLoader() {
		this.cache = new HashMap<>();
	}
	
	private BlockChainTransactionLoader(Map<String, List<UserTransaction>> existentCache) {
		this.cache = new HashMap<>(existentCache);
	}

	public BlockChainTransactionLoader deepCopy() {
		return new BlockChainTransactionLoader(this.cache);
	}
	
	public List<UserTransaction> loadTransactionsFromFile(String fileName) {
		if (this.cache.containsKey(fileName)) {
			return this.cache.get(fileName);
		}
		return loadTheMessages(fileName);
	}
	
	private List<UserTransaction> loadTheMessages(String fileName) {
		try {
			Thread.sleep(60000);
			return PrototypeUtils.readLinesFromResource(fileName);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return new LinkedList<>();
	}
	
}
