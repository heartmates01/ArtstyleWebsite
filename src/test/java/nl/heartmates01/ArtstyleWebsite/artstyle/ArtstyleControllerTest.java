package nl.heartmates01.ArtstyleWebsite.artstyle;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import nl.heartmates01.ArtstyleWebsite.customer.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ArtstyleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ArtstyleRepository artstyleRepository;

  @Test
  void addStyleTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/artstyles/add").formField("style", "test"))
        .andDo(print()).andExpect(status().isOk());
    List<Artstyle> result = artstyleRepository.findByStyle("test");
    assertEquals(1, result.size());
  }

  @Test
  void deleteStyleTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/artstyles/add").formField("style", "test"))
        .andDo(print()).andExpect(status().isOk());
    List<Artstyle> result = artstyleRepository.findByStyle("test");
    assertEquals(1, result.size());

    mockMvc.perform(MockMvcRequestBuilders
        .delete("/artstyles/delete/{id}", "1")
        .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    List<Artstyle> resultDel = artstyleRepository.findByStyle("test");
    assertEquals(0, resultDel.size());
  }
}