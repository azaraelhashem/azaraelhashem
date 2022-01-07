package com.example.accessingdatamysql;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.Data;


@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;
  @Autowired
  private FeedBackRepository feedBackRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @PostMapping(path="/NewFeedBack") // Map ONLY POST Requests
  public String addNewFeedback (
    @RequestParam String q1_feedbackType,
    @RequestParam String q2_desc,
    @RequestParam String q3_fName,
    @RequestParam String q3_lName,
    @RequestParam String q4_email
      ) {
    FeedBack feedBack = new FeedBack();
    feedBack.setFbType(q1_feedbackType);

    feedBack.setDescription(q2_desc);
    feedBack.setFName(q3_fName);
    feedBack.setLName(q3_lName);
    feedBack.setEmail(q4_email);
    feedBackRepository.save(feedBack);
    return "redirect:/";
  }

  @PostMapping(path="/UpdateFeedBack") // Map ONLY POST Requests
  public String UpdateFeedback (
    @RequestParam Integer q0_feedbackID,
    @RequestParam String q1_feedbackType,
    @RequestParam String q2_desc,
    @RequestParam String q3_fName,
    @RequestParam String q3_lName,
    @RequestParam String q4_email,Model model
      ) {
    FeedBack feedBack = new FeedBack();
    feedBack.setId(q0_feedbackID);
    feedBack.setFbType(q1_feedbackType);
    feedBack.setDescription(q2_desc);
    feedBack.setFName(q3_fName);
    feedBack.setLName(q3_lName);
    feedBack.setEmail(q4_email);
    feedBackRepository.save(feedBack);
    model.addAttribute("message", "Saved");
    return "redirect:/";
  }

  

  @GetMapping(path="/")
  public String viewHomePage(Model model) {
    Iterable<FeedBack> FeedBackList = feedBackRepository.findAll();
    model.addAttribute("FeedBackList", FeedBackList);         
    return "index";
}

@GetMapping("/FeedbackFiltered")
public String fbFiltered(Model model, @RequestParam String name) {

  Iterable<FeedBack> FeedBackList = feedBackRepository.filtered(name);

    model.addAttribute("FeedBackList", FeedBackList);
    model.addAttribute("message", name);
    return "index";
}

@GetMapping(path="/all")
  public @ResponseBody Iterable<FeedBack> getAllUsers() {
    // This returns a JSON or XML with the users
    return feedBackRepository.findAll();
  }
  
@GetMapping(value = "/remove/{id}")
public String deletePost(@PathVariable(value = "id") Long id, Model model) {

   try{
    feedBackRepository.deleteById(Integer.parseInt(id+""));
    model.addAttribute("FeedBackList", feedBackRepository.findAll());
    model.addAttribute("message", "Deleted");
   }catch(Exception e){
    model.addAttribute("FeedBackList", feedBackRepository.findAll());
    model.addAttribute("message", "account not found");
   }
    return "index";
}

@GetMapping(value = "/Edit/{id}")
public String UpdatePost(@PathVariable(value = "id") Long id, Model model) {
  
   try{
    FeedBack feedBack = feedBackRepository.findById(Integer.parseInt(id+"")).get();
    model.addAttribute("feedback", feedBack);    
    model.addAttribute("message", "Update");
   }catch(Exception e){
    model.addAttribute("FeedBackList", feedBackRepository.findAll());
    model.addAttribute("message", "account not found");
    return "index";
   }
    return "Update";
}
}