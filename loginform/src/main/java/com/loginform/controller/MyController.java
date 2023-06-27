package com.loginform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginform.entities.LoginData;

import jakarta.validation.Valid;
import java.util.regex.*;



@Controller
public class MyController {

	@GetMapping("/form2")
	public String openForm(Model model) {
		System.out.println("hi ravi");
		model.addAttribute("loginData", new LoginData());
		return "form";
		
	}
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result ) { 
		
		System.out.println(loginData.getUserName());
		
		String username=loginData.getUserName();
		String email=loginData.getEmail();
		 //Regular Expression   
        String regex = "^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+$";  
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(email);  
        System.out.println(matcher);
      //  System.out.println(username.length());
		
		if(result.hasErrors()) {
			
			return "form";
		}else if(username.length() <1) {
			return "form";
		}else if(matcher.equals("false")) {
			return "form";
		}else {
			return "success";
		}
		
		
		
		
	}
}



//
//
//<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
//<dependency>
//<groupId>javax.validation</groupId>
//<artifactId>validation-api</artifactId>
//<version>2.0.1.Final</version>       
//</dependency>
//
//<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-validator -->
//<dependency>
//<groupId>org.hibernate</groupId>
//<artifactId>hibernate-validator</artifactId>
//<version>6.1.7.Final</version>
//</dependency>
//







