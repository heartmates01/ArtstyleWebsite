package nl.heartmates01.ArtstyleWebsite.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {

  @Autowired
  private SettingRepository settingRepository;

  @GetMapping("/settings")
  public String settings(Model model) {
    Iterable<Setting> settingList = settingRepository.findAll();

    model.addAttribute("settings", settingList);
    System.out.println(settingList);
    return "settings";
  }

  //add
  @GetMapping("/settings/add")
  public String addSetting() {
    return "settings-add";
  }

  @PostMapping("/settings/add")
  public String storeSettings(@Validated Setting setting) {
    settingRepository.save(setting);
    return "redirect:/settings";
  }

  //edit
  @GetMapping("/settings/edit/{setting}")
  public String editSetting(@PathVariable Setting setting) {
    return "settings-edit";
  }

  @PostMapping("/settings/edit")
  public String updateSetting(@Validated @ModelAttribute Setting setting) {
    System.out.println(setting);
    settingRepository.save(setting);
    return "redirect:/settings";
  }

  //delete
  @GetMapping("/settings/delete/{setting}")
  public String deleteSetting(@PathVariable Setting setting) {
    return "settings-delete";
  }

  @PostMapping("/settings/delete")
  public String removeSetting(@Validated @ModelAttribute Setting setting) {
    System.out.println(setting);
    settingRepository.delete(setting);
    return "redirect:/settings";
  }
    //show
  @GetMapping("/settings/show/{setting}")
  public String showSetting(@PathVariable Setting setting) {
    return "settings-show";
  }

  @PostMapping("/settings/show")
  public String showAllSettingInfo(@Validated @ModelAttribute Setting setting) {
    System.out.println(setting);
    settingRepository.findById(setting.getId());
    return "redirect:/settings";
  }
}
