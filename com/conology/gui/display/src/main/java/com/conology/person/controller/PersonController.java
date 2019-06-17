package com.conology.person.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conology.person.model.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

	// load person data
	
	private List<Person> thePersons;
	
	@PostConstruct
	private void loadData() {
		
		// create persons
		Person per1 = new Person(1, "Aleš",40,0);
		Person per2 = new Person(2, "Rok",35,5);
		Person per3 = new Person(3, "Bojan",20,20);

		// create the list
		thePersons = new ArrayList<>();
		
		// add to the list
		thePersons.add(per1);
		thePersons.add(per2);
		thePersons.add(per3);
	
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listPersons(Model theModel) {
		
		// add to the spring model
		theModel.addAttribute("persons", thePersons);
		
		return "list-persons";
	}
}