package nl.heartmates01.ArtstyleWebsite.medium;

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
class MediumControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MediumRepository mediumRepository;

  @Test
  void addMediumTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/mediums/add").formField("type", "test"))
        .andDo(print()).andExpect(status().isOk());
    List<Medium> result = mediumRepository.findByType("test");
    assertEquals(1, result.size());
  }

  @Test
  void deleteByIdTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/mediums/add")
            .formField("type", "test"))
        .andDo(print()).andExpect(status().isOk());
    List<Medium> result = mediumRepository.findByType("test");
    assertEquals(1, result.size());

    mockMvc.perform(MockMvcRequestBuilders.delete("/mediums/delete/{id}", "1").contentType(
        MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    List<Medium> resultDel = mediumRepository.findByType("test");
    assertEquals(0, resultDel.size());
  }
}