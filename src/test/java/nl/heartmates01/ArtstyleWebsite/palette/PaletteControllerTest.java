package nl.heartmates01.ArtstyleWebsite.palette;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PaletteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private PaletteRepository paletteRepository;

  @Test
  void addPalette() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/palettes/add")
            .formField("color1", "test1")
            .formField("color2", "test2")
            .formField("color3", "test3")
            .formField("color4", "test4")
            .formField("color5", "test5"))
        .andDo(print()).andExpect(status().isOk());
    List<Palette> result = paletteRepository.findByColor1("test1");
    assertEquals(1, result.size());
  }

  @Test
  void deleteById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/palettes/add")
            .formField("color1", "test1")
            .formField("color2", "test2")
            .formField("color3", "test3")
            .formField("color4", "test4")
            .formField("color5", "test5"))
        .andDo(print()).andExpect(status().isOk());
    List<Palette> result = paletteRepository.findByColor1("test1");
    assertEquals(1, result.size());

    mockMvc.perform(MockMvcRequestBuilders
        .delete("/palettes/delete/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    List<Palette> resultDel = paletteRepository.findByColor1("test1");
    assertEquals(0, resultDel.size());
  }
}