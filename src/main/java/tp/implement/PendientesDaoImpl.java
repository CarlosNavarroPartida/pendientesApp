package tp.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tp.dao.PendientesDAO;
import tp.model.Pendientes;

@Configurable
@Component
@Repository

public class PendientesDaoImpl implements PendientesDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void pendienteSave(Pendientes p) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		sessionFactory.getCurrentSession().save(p);
		tx.commit();
		session.close();
		
	}

	public void pendienteUpdate(Pendientes p) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		sessionFactory.getCurrentSession().update(p);
		tx.commit();
		session.close();
		
	}

	public List<Pendientes> pendientesFindByExample() {
		List<Pendientes> list = this.sessionFactory.openSession()
				.createQuery("from Pendientes").list();
		return list;
	}

	public Pendientes pendientesGetById(int id) {
		Session session = sessionFactory.openSession();
		List<Pendientes> list = session.createQuery("from Pendientes b where b.id = :pendienteId")
				.setParameter("pendienteId", id)
				.list();
		return list.size()>0 ? (Pendientes)list.get(0):null;
	}

	public void pendientesRemove(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.delete((Pendientes) session.load(Pendientes.class,id));
		tx.commit();
		session.close();
		
	}
	
}
