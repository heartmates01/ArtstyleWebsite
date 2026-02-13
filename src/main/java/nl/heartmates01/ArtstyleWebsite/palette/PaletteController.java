package nl.heartmates01.ArtstyleWebsite.palette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaletteController {

  @Autowired
  private PaletteRepository paletteRepository;

  @GetMapping("/palettes")
  public String palettes(Model model) {
    Iterable<Palette> paletteList = paletteRepository.findAll();

    model.addAttribute("palettes", paletteList);
    System.out.println(paletteList);
    return "palettes";
  }

  //add
  @GetMapping("/palettes/add")
  public String addPalette() {
    return "palettes-add";
  }

  @PostMapping("/palettes/add")
  public String storePalettes(@Validated Palette palette) {
    paletteRepository.save(palette);
    return "redirect:/palettes";
  }

  //edit
  @GetMapping("/palettes/edit/{palette}")
  public String editPalette(@PathVariable Palette palette) {
    return "palettes-edit";
  }

  @PostMapping("/palettes/edit")
  public String updatePalette(@Validated @ModelAttribute Palette palette) {
    System.out.println(palette);
    paletteRepository.save(palette);
    return "redirect:/palettes";
  }

  //delete
  @GetMapping("/palettes/delete/{palette}")
  public String deletePalette(@PathVariable Palette palette) {
    return "palettes-delete";
  }

  @PostMapping("/palettes/delete")
  public String removePalette(@Validated @ModelAttribute Palette palette) {
    System.out.println(palette);
    paletteRepository.delete(palette);
    return "redirect:/palettes";
  }
}
