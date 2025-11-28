package com.project.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.spring.mydiary.business.EntryBusinessInterface;
import com.project.spring.mydiary.business.UserBusinessInterface;
import com.project.spring.mydiary.entities.Entry;
import com.project.spring.mydiary.entities.User;

@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private UserBusinessInterface userBusinessInterface;

	public UserBusinessInterface getUserBusinessInterface() {
		return userBusinessInterface;
	}

	public void setUserBusinessInterface(UserBusinessInterface userBusinessInterface) {
		this.userBusinessInterface = userBusinessInterface;
	}
	
	@Autowired
	private EntryBusinessInterface entryBusinessInterface;
	
	public EntryBusinessInterface getEntryBusinessInterface() {
		return entryBusinessInterface;
	}

	public void setEntryBusinessInterface(EntryBusinessInterface entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}

	

	@RequestMapping("home")
	public ModelAndView homepage() {

		ModelAndView model = new ModelAndView("loginpage");

		return model;
	}

	@RequestMapping("register")
	public ModelAndView registrationpage() {

		ModelAndView model = new ModelAndView("registrationpage");

		return model;
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user") User user) {
		
		//code to save user details in database

		ModelAndView model = new ModelAndView("loginpage");
		userBusinessInterface.save(user);

		return model;

	}
	
	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("user") User user) {
		
		ModelAndView model = new ModelAndView("loginpage");
		
		User user1 = userBusinessInterface.findByUsername(user.getUsername());
		if(user1 != null && user.getPassword().equals(user1.getPassword())) {
			model.setViewName("userhomepage");
			model.addObject("user",user1);
			
			session.setAttribute("user", user1);
			
			List<Entry> entries = null;
			
			try {
				entries = entryBusinessInterface.findByUserId(user1.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addObject("entrieslist",entries);
		}
		
		
		return model;
		
	}
	
	@RequestMapping("addentry")
	public ModelAndView addentry() {
		
		ModelAndView model = new ModelAndView("addentry");
		
		User user1 = (User) session.getAttribute("user");
		if(user1==null) {
			model.setViewName("loginpage");
		}
		
		return model;
	}
	
	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry")Entry entry) {
		
		ModelAndView model = new ModelAndView("userhomepage");
		
		entryBusinessInterface.save(entry);
		
		User user1 = (User) session.getAttribute("user");
		
		List<Entry> entries = null;
		
		try {
			entries = entryBusinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries);
		
		return model;
	}
	
	@RequestMapping("viewentry")
	public ModelAndView viewentry(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView("displayentry");
		
		Entry entry = entryBusinessInterface.findById(id);
		model.addObject("entry",entry);
		
		return model;
	}
	
	@RequestMapping("userhome")
	public ModelAndView userhomepage() {

		ModelAndView model = new ModelAndView("userhomepage");
		
		User user1 = (User) session.getAttribute("user");
		List<Entry> entries = null;
		
		try {
			entries = entryBusinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries);

		return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView("displayupdateentry");
		
		Entry entry = entryBusinessInterface.findById(id);
		model.addObject("entry",entry);
		
		User user1 = (User) session.getAttribute("user");
		if(user1==null) {
			model.setViewName("loginpage");
		}
		
		return model;
	}
	
	@RequestMapping("processupdateentry")
	public ModelAndView processupdateentry(@ModelAttribute("entry")Entry entry) {
		
		ModelAndView model = new ModelAndView("userhomepage");
		
		entryBusinessInterface.update(entry);
		
		User user1 = (User) session.getAttribute("user");
		
		List<Entry> entries = null;
		
		try {
			entries = entryBusinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries);
		
		return model;
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView("userhomepage");
		
		User user1 = (User) session.getAttribute("user");
		
		Entry entry = entryBusinessInterface.findById(id);
		
		if(user1==null) {
			model.setViewName("loginpage");
		}else
		entryBusinessInterface.delete(entry);
		
		
		List<Entry> entries = null;
		
		try {
			entries = entryBusinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addObject("entrieslist",entries);
				
		return model;
	}
	
	@RequestMapping("signout")
	public ModelAndView signout() {

		ModelAndView model = new ModelAndView("loginpage");
		session.invalidate();

		return model;
	}


}
