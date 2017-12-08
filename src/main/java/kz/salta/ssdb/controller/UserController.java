package kz.salta.ssdb.controller;

import kz.salta.ssdb.form.RegistrationForm;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.User;
import kz.salta.ssdb.service.BookService;
import kz.salta.ssdb.service.LibraryCardService;
import kz.salta.ssdb.service.SecurityService;
import kz.salta.ssdb.service.UserService;
import kz.salta.ssdb.validator.RegistrationFormValidator;
import kz.salta.ssdb.validator.UserValidator;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

	@Resource(name = "userService")
    private UserService userService;

	@Resource(name = "securityService")
    private SecurityService securityService;
	
	@Resource(name = "libraryCardService")
    private LibraryCardService libraryCardService;
	
	@Resource(name = "bookService")
    private BookService bookService;

    @Autowired
    private RegistrationFormValidator registrationFormValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	model.addAttribute("registrationForm",new RegistrationForm());
        
        return "/site/registration";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
    		BindingResult registrationResult, Model model) {
    	//registrationFormValidator.validate(registrationForm, registrationResult);
        if (registrationResult.hasErrors()) {
            return "/site/registration";
        }

        userService.save(registrationForm.getUser());

        securityService.autoLogin(registrationForm.getUser().getUsername(), registrationForm.getUser().getConfirmPassword());
        
        libraryCardService.saveWithUser(registrationForm.getLibraryCard(),registrationForm.getUser());

        return "redirect:/profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "/site/login";
    }

    @RequestMapping(value = {"/", "/profile"}, method = RequestMethod.GET)
    public String profile(Model model) {
        return "/student/profile";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "/student/admin";
    }
    
    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String library(Model model) {
    	model.addAttribute("books",bookService.findAll());
        return "/student/library";
    }
}
