package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.service.AddressBookService;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    // CORS for this specific method
    @CrossOrigin(origins = "http://localhost:4200") // Allow cross-origin requests from Angular frontend
    @GetMapping("/all")
    public List<AddressBookEntity> getAll() {
        return addressBookService.getAllEntries();
    }

    // CORS for this specific method
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public AddressBookEntity addEntry(@RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.addEntry(addressBookDTO);
    }

    // CORS for this specific method
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/{id}")
    public AddressBookEntity getEntryById(@PathVariable Long id) {
        return addressBookService.getEntryById(id);
    }

    // CORS for this specific method
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{id}")
    public AddressBookEntity updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateEntry(id, addressBookDTO);
    }

    // CORS for this specific method
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public String deleteEntry(@PathVariable Long id) {
        boolean isDelete = addressBookService.deleteEntry(id);
        return isDelete ? "Entry deleted successfully" : "Not found";
    }
}
