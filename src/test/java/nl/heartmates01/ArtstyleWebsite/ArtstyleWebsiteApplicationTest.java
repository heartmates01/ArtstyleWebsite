package nl.heartmates01.ArtstyleWebsite;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import nl.heartmates01.ArtstyleWebsite.customer.Customer;
import nl.heartmates01.ArtstyleWebsite.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ArtstyleWebsiteApplicationTest {

  @Autowired
  private MockMvc mockMvc;


  @Test
  void main() {
  }

  @Test
  void home() {
  }
}