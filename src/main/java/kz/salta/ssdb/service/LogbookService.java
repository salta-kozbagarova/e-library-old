package kz.salta.ssdb.service;

import java.util.List;

import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.Logbook;

public interface LogbookService {
	
	List<Logbook> findAll();
	
	void addRecord(Long book_id, Logbook.ActionType action);
	
	List<Logbook> findByLibraryCardAndActionType(Logbook.ActionType action);
}
