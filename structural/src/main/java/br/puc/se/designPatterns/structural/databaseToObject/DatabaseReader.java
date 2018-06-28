package br.puc.se.designPatterns.structural.databaseToObject;


// how can we manage the code to create a lazy load / proxy to load the LogEvent's 
// only when someone call the method `logEntry.getEvents()`
// 
public class DatabaseReader {

	public LogEntry readFromDate(DateRange dateRange) {
		// hit the database and fill the object with the values from database
		return null;
	}
	
}
