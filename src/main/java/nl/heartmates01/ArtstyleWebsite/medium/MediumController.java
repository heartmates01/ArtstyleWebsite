package nl.heartmates01.ArtstyleWebsite.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MediumController {

  @Autowired
  private MediumRepository mediumRepository;

  @GetMapping("/mediums")
  public String mediums(Model model) {
    Iterable<Medium> mediumList = mediumRepository.findAll();

    model.addAttribute("mediums", mediumList);
    System.out.println(mediumList);
    return "mediums";
  }

  //add
  @GetMapping("/mediums/add")
  public String addMedium() {
    return "mediums-add";
  }

  @PostMapping("/mediums/add")
  public String storeMediums(@Validated Medium medium) {
    mediumRepository.save(medium);
    return "redirect:/mediums";
  }

  //edit
  @GetMapping("/mediums/edit/{medium}")
  public String editMedium(@PathVariable Medium medium) {
    return "mediums-edit";
  }

  @PostMapping("/mediums/edit")
  public String updateMedium(@Validated @ModelAttribute Medium medium) {
    System.out.println(medium);
    mediumRepository.save(medium);
    return "redirect:/mediums";
  }

  //delete
  @GetMapping("/mediums/delete/{medium}")
  public String deleteMedium(@PathVariable Medium medium) {
    return "mediums-delete";
  }

  @PostMapping("/mediums/delete")
  public String removeMedium(@Validated @ModelAttribute Medium medium) {
    System.out.println(medium);
    mediumRepository.delete(medium);
    return "redirect:/mediums";
  }
    //show
  @GetMapping("/mediums/show/{medium}")
  public String showMedium(@PathVariable Medium medium) {
    return "mediums-show";
  }

  @PostMapping("/mediums/show")
  public String showAllMediumInfo(@Validated @ModelAttribute Medium medium) {
    System.out.println(medium);
    mediumRepository.findById(medium.getId());
    return "redirect:/mediums";
  }
}
