/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.controller.CustomerForm;
import deim.urv.cat.homework2.model.CustomerDTO;
import deim.urv.cat.homework2.model.Customer;
import java.util.List;

/**
 *
 * @author Kevin
 */
public interface CustomerService {
    List<CustomerDTO> findAll();
    Customer findId(Long id);
    boolean putCustomer(CustomerForm cust);
    Customer findName(String name);
}
