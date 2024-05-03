package com.ranim.supermarches.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.entities.Type;
import com.ranim.supermarches.service.SupermarcheService;

import jakarta.validation.Valid;

@Controller
public class SupermarcheController {

	@Autowired
	SupermarcheService supermarcheService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}

	@RequestMapping("/ListeSupermarches")
	public String listeProduits(ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		
		Page<Supermarche> supers = supermarcheService.getAllSupermarchesParPage(page, size);
		modelMap.addAttribute("supermarches", supers);
		modelMap.addAttribute("pages", new int[supers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSupermarches";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Type> typs = supermarcheService.getAllTypes();
		modelMap.addAttribute("supermarche", new Supermarche());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("types", typs);
		return "formSupermarche";
	}

	@RequestMapping("/saveSupermarche")
	public String saveSupermarche(@Valid Supermarche supermarche, BindingResult bindingResult,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "2") int size) {
		
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formSupermarche";
		if (supermarche.getIdSupermarche()==null) //ajout
			isNew=true;
		
		supermarcheService.saveSupermarche(supermarche);
		
		if (isNew) // ajout
		{
			Page<Supermarche> supers = supermarcheService.getAllSupermarchesParPage(page, size);
			currentPage = supers.getTotalPages()-1;
		} else // modif
			currentPage = page;
		
		
		return ("redirect:/ListeSupermarches?page="+currentPage+"&size="+size);
	}

	@RequestMapping("/supprimerSupermarche")
	public String supprimerSupermarche(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		
		supermarcheService.deleteSupermarcheById(id);
		Page<Supermarche> supers = supermarcheService.getAllSupermarchesParPage(page, size);
		modelMap.addAttribute("supermarches", supers);
		modelMap.addAttribute("pages", new int[supers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSupermarches";
	}

	@RequestMapping("/modifierSupermarche")
	public String editerSupermarche(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "2") int size) {
		Supermarche s = supermarcheService.getSupermarche(id);
		List<Type> typs = supermarcheService.getAllTypes();
		modelMap.addAttribute("supermarche", s);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("types", typs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);


		

		return "formSupermarche";
	}

	@RequestMapping("/updateSupermarche")
	public String updateSupermarche(@ModelAttribute("supermarche") Supermarche supermarche,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateConstruction = dateformat.parse(String.valueOf(date));
		supermarche.setDateConstruction(dateConstruction);
		supermarcheService.updateSupermarche(supermarche);
		List<Supermarche> supers = supermarcheService.getAllSupermarches();
		modelMap.addAttribute("supermarche", supers);
		return "listeSupermarches";
	}

}
