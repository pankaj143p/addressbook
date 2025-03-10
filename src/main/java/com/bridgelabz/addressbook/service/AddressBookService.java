package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// service  layer to write all functions(ex-crud oprations)
@Service
public class AddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    // method for return all the entries
    public List<AddressBookEntity> getAllEntries(){
        return addressBookRepository.findAll();
    }

    // method to add entry
    public AddressBookEntity addEntry(AddressBookDTO addressBookDTO){
        AddressBookEntity addressBookEntity = new AddressBookEntity(addressBookDTO.getName(), addressBookDTO.getAddress(),addressBookDTO.getCity(), addressBookDTO.getState(), addressBookDTO.getZipCode(),addressBookDTO.getPhoneNumber());
        return addressBookRepository.save(addressBookEntity);
    }

    // method to find entry by id
    public AddressBookEntity getEntryById(Long id){
        return addressBookRepository.findById(id).orElse(null);
    }

    // method to update entry
    public AddressBookEntity updateEntry(Long id, AddressBookDTO addressBookDTO){
        Optional<AddressBookEntity> existingAddressOpt = addressBookRepository.findById(id);
        if (existingAddressOpt.isPresent()) {
            AddressBookEntity existingAddresBook = existingAddressOpt.get();
            existingAddresBook.setName(addressBookDTO.getName());
            existingAddresBook.setAddress(addressBookDTO.getAddress());
            existingAddresBook.setCity(addressBookDTO.getCity());
            existingAddresBook.setState(addressBookDTO.getState());
            existingAddresBook.setZipCode(addressBookDTO.getZipCode());
            existingAddresBook.setPhoneNumber(addressBookDTO.getZipCode());
            return addressBookRepository.save(existingAddresBook);

        }
        return null;
    }
    // method for delete entry
    public boolean deleteEntry(Long id){
        if(addressBookRepository.existsById(id)){
            addressBookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


