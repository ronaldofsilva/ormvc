package br.ueg.br.si.p4.reflection.fw.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ueg.br.si.p4.reflection.fw.dao.DAO;
import br.ueg.br.si.p4.reflection.fw.model.Conta;
import br.ueg.br.si.p4.reflection.fw.validation.ContaValidator;


@Controller
public class ContaController {	
	
	@RequestMapping(path = "conta/add", method = RequestMethod.GET)	
	public String add() {
		return "cadastro-conta";
	}
	
	@RequestMapping(path = "conta/list", method = RequestMethod.GET)	
	public String list(Conta conta) {						
		DAO<Conta> dao = new DAO<Conta>(Conta.class);		
		List<Conta> lista = dao.listaTodos(Conta.class);
		for (Conta c : lista) {
			System.out.println(c.getId()+" - "+c.getNome());
		}		
		return "lista-conta";
	}
	
	
	@RequestMapping(path = "conta/save")	
	public String save(@Valid Conta conta, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "cadastro-conta";
		}else {
			DAO<Conta> dao = new DAO<Conta>(Conta.class);
			dao.adiciona(conta);
			System.out.println(conta.getNome());					
			return "redirect:lista";
		}
		
	}	
	
	@RequestMapping(path = "conta/lista", method = RequestMethod.GET)	
	public ModelAndView listModel(Conta conta) {						
		DAO<Conta> dao = new DAO<Conta>(Conta.class);		
		List<Conta> lista = dao.listaTodos(Conta.class);
		ModelAndView modelAndView= new ModelAndView("lista-conta");
		modelAndView.addObject("contas",lista);
		return modelAndView;
	}
	
	
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ContaValidator());
	}
	
	

}
