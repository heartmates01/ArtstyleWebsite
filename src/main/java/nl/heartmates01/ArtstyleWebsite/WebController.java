package nl.heartmates01.ArtstyleWebsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

  @GetMapping("/")
  public String showHomePage() {
    return "welcome";
  }
}
