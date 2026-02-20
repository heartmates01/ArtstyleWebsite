package nl.heartmates01.ArtstyleWebsite.artstyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArtstyleController {

  @Autowired
  private ArtstyleRepository artstyleRepository;

  @GetMapping("/artstyles")
  public String artstyles(Model model) {
    Iterable<Artstyle> artstyleList = artstyleRepository.findAll();

    model.addAttribute("artstyles", artstyleList);
    System.out.println(artstyleList);
    return "artstyles";
  }

  //add
  @GetMapping("/artstyles/add")
  public String addArtstyle() {
    return "artstyles-add";
  }

  @PostMapping("/artstyles/add")
  public String storeArtstyles(@Validated Artstyle artstyle) {
    artstyleRepository.save(artstyle);
    return "redirect:/artstyles";
  }

  //edit
  @GetMapping("/artstyles/edit/{artstyle}")
  public String editArtstyle(@PathVariable Artstyle artstyle) {
    return "artstyles-edit";
  }

  @PostMapping("/artstyles/edit")
  public String updateArtstyle(@Validated @ModelAttribute Artstyle artstyle) {
    System.out.println(artstyle);
    artstyleRepository.save(artstyle);
    return "redirect:/artstyles";
  }

  //delete
  @GetMapping("/artstyles/delete/{artstyle}")
  public String deleteArtstyle(@PathVariable Artstyle artstyle) {
    return "artstyles-delete";
  }

  @PostMapping("/artstyles/delete")
  public String removeArtstyle(@Validated @ModelAttribute Artstyle artstyle) {
    System.out.println(artstyle);
    artstyleRepository.delete(artstyle);
    return "redirect:/artstyles";
  }
    //show
  @GetMapping("/artstyles/show/{artstyle}")
  public String showArtstyle(@PathVariable Artstyle artstyle) {
    return "artstyles-show";
  }

  @PostMapping("/artstyles/show")
  public String showAllArtstyleInfo(@Validated @ModelAttribute Artstyle artstyle) {
    System.out.println(artstyle);
    artstyleRepository.findById(artstyle.getId());
    return "redirect:/artstyles";
  }
}
