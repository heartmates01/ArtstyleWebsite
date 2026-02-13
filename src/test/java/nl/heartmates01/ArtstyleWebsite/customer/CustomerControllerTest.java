package nl.heartmates01.ArtstyleWebsite.customer;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private CustomerRepository customerRepository;

  @Test
  void addCustomerTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/customers/add").formField("first", "test")
            .formField("last", "test"))
        .andDo(print()).andExpect(status().isOk());
    List<Customer> result = customerRepository.findByFirstName("test");
    assertEquals(1, result.size());
  }

  @Test
  void deleteCustomerTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/customers/add").formField("first", "test")
            .formField("last", "test"))
        .andDo(print()).andExpect(status().isOk());
    List<Customer> result = customerRepository.findByFirstName("test");
    assertEquals(1, result.size());

    mockMvc.perform(MockMvcRequestBuilders
        .delete("/customers/delete/{id}", "1")
        .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    List<Customer> resultDel = customerRepository.findByFirstName("test");
    assertEquals(0, resultDel.size());
  }
}