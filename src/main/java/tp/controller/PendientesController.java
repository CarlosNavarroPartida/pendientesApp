package tp.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

import tp.model.Pendientes;
import tp.service.PendientesService;

@Controller
public class PendientesController {
	
	@Autowired
	PendientesService pendienteService;
	
	@RequestMapping(value="/index", method = RequestMethod.GET) 
	public String getFindByExample(Map<String, Object>map){
		map.put("pendiente", new Pendientes());
		List<Pendientes> pendientesList = pendienteService.pendientesFindByExample();
		map.put("pendienteList", pendientesList);
		map.put("pendienteCount", pendientesList.size());
		return "pendienteHome";
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("pendiente") Pendientes p, BindingResult result){
		if(p.getIdPendiente() > 0){
			pendienteService.pendienteUpdate(p);
		}else{
			pendienteService.pendienteSave(p);
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/delete/{idPendiente}")
	public String delete(@PathVariable("idPendiente") int idPendiente){
		pendienteService.pendientesRemove(idPendiente);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/{idPendiente}")
	public String edit(@PathVariable("idPendiente") int idPendiente, Map<String, Object> map){
		map.put("pendiente", pendienteService.pendientesGetById(idPendiente));
		map.put("pendienteList", pendienteService.pendientesFindByExample());
		map.put("pendienteCount", pendienteService.pendientesFindByExample().size());
		return "pendienteHome";
	}
	
}
