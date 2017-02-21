package tp.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tp.dao.PendientesDAO;
import tp.model.Pendientes;
import tp.service.PendientesService;

@Service
@Component
@Configurable
public class PendienteServiceImpl implements PendientesService {

	@Autowired
	private PendientesDAO pendientesDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void pendienteSave(Pendientes p) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();

	}

	@Transactional
	public void pendienteUpdate(Pendientes p) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();

	}

	@Transactional
	public List<Pendientes> pendientesFindByExample() {
		return pendientesDao.pendientesFindByExample();
	}

	@Transactional
	public Pendientes pendientesGetById(int id) {
		return pendientesDao.pendientesGetById(id);
	}

	@Transactional
	public void pendientesRemove(int id) {
		pendientesDao.pendientesRemove(id);;
	}

}
