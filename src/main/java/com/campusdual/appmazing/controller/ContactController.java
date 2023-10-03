package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.iContactService;
import com.campusdual.appmazing.model.dto.ContactDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private iContactService contactService;

    @GetMapping
    public String testController() {
        return "Contact controller is working!";
    }

    @PostMapping
    public String testController(@RequestBody String name) {
        return "Esto está funcionando " + name + "!";
    }

    @PostMapping(value = "/get")
    public ContactDTO queryContact(@RequestBody ContactDTO contactDTO) {
        return this.contactService.queryContact(contactDTO);
    }

    @GetMapping(value = "/getAll")
    public List<ContactDTO> queryAllContact() {
        return this.contactService.queryAllContact();
    }

    @PostMapping(value = "/add")
    public int addContact(@RequestBody ContactDTO contactDTO) {
        return this.contactService.insertContact(contactDTO);
    }

    @PutMapping(value = "/put")
    public int putContact(@RequestBody ContactDTO contactDTO) {
        return this.contactService.updateContact(contactDTO);
    }

    @DeleteMapping (value = "/delete")
    public int deleteContact(@RequestBody ContactDTO contactDTO) {
        return this.contactService.deleteContact(contactDTO);
    }
}
