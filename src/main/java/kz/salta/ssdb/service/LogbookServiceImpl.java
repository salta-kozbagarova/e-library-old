package kz.salta.ssdb.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salta.ssdb.dao.BookDao;
import kz.salta.ssdb.dao.LogbookDao;
import kz.salta.ssdb.dao.UserDao;
import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.Logbook;
import kz.salta.ssdb.model.Logbook.ActionType;
import kz.salta.ssdb.model.User;

@Service("logbookService")
public class LogbookServiceImpl implements LogbookService {
	
	@Resource(name = "securityService")
    private SecurityService securityService;
	
	@Autowired
	private LogbookDao logbookDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
    private UserDao userDao;
	
	@Override
	public List<Logbook> findAll() {
		return logbookDao.findAll();
	}

	@Override
	public void addRecord(Long book_id, Logbook.ActionType action) {
		Logbook logbook=new Logbook();
		String username = securityService.findLoggedInUsername();
		User user = userDao.findByUsername(username);
		Book book = bookDao.findOne(book_id);
		logbook.setLibraryCard(user.getLibraryCard());
		logbook.setBook(book);
		if(action.compareTo(Logbook.ActionType.checked_out)==0){
			if(book.getQuantity()<=5){
				logbook.setBookIssuingType(Logbook.IN_THE_HALL);
			}else{
				logbook.setBookIssuingType(Logbook.ON_THE_HANDS);
			}
		}
		logbook.setActionType(action);
		logbook.setDate(new Date());
		logbookDao.save(logbook);
	}

	@Override
	public List<Logbook> findByLibraryCardAndActionType(Logbook.ActionType action) {
		String username = securityService.findLoggedInUsername();
		User user = userDao.findByUsername(username);
		List<Logbook> logbooks = logbookDao.findByLibraryCardAndActionType(user.getLibraryCard(),action);
		return logbooks;
	}

}
