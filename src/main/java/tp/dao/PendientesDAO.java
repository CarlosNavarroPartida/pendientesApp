package tp.dao;
import tp.model.Pendientes;
import java.util.List;

public interface  PendientesDAO {
	
	public void pendienteSave(Pendientes p);
	
	public void pendienteUpdate(Pendientes p);
	
	public List<Pendientes> pendientesFindByExample();
	
	public Pendientes pendientesGetById(int id);
	
	public void pendientesRemove(int id);
}

 