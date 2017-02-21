package tp.service;

import java.util.List;
import tp.model.Pendientes;

public interface PendientesService {
	
	public void pendienteSave(Pendientes p);
	
	public void pendienteUpdate(Pendientes p);
	
	public List<Pendientes> pendientesFindByExample();
	
	public Pendientes pendientesGetById(int id);
	
	public void pendientesRemove(int id);
}
