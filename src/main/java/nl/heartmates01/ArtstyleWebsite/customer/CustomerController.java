package nl.heartmates01.ArtstyleWebsite.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customers")
  public String customers(Model model) {
    Iterable<Customer> customerList = customerRepository.findAll();

    model.addAttribute("customers", customerList);
    System.out.println(customerList);
    return "customers";
  }

  //path to add
  @GetMapping("/customers/add")
  public String addCustomer() {
    return "customers-add";
  }

  //store customer
  @PostMapping("/customers/add")
  public String storeCustomer(@Validated Customer customer) {
    customerRepository.save(customer);
    return "redirect:/customers";
  }

  //edit
  @GetMapping("/customers/edit/{customer}")
  public String editCustomer(@PathVariable Customer customer) {
    return "customers-edit";
  }

  @PostMapping("/customers/edit")
  public String updateCustomer(@Validated @ModelAttribute Customer customer) {
    System.out.println(customer);
    customerRepository.save(customer);
    return "redirect:/customers";
  }

  //delete
  @GetMapping("/customers/delete/{customer}")
  public String deleteCustomer(@PathVariable Customer customer) {
    return "customers-delete";
  }

  @PostMapping("/customers/delete")
  public String removeCustomer(@Validated @ModelAttribute Customer customer) {
    System.out.println(customer);
    customerRepository.delete(customer);
    return "redirect:/customers";
  }
    //show
  @GetMapping("/customers/show/{customer}")
  public String showCustomer(@PathVariable Customer customer) {
    return "customers-show";
  }

  @PostMapping("/customers/show")
  public String showAllCustomerInfo(@Validated @ModelAttribute Customer customer) {
    System.out.println(customer);
    customerRepository.findById(customer.getId());
    return "redirect:/customers";
  }
}
