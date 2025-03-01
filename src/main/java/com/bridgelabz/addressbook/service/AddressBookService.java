package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    // In-memory ArrayList to store entries
    private List<AddressBookEntity> addressBookList = new ArrayList<>();
    private Long idCounter = 1L; // For simulating the id auto-increment

    // method for returning all the entries
    public List<AddressBookEntity> getAllEntries(){
        return addressBookList;
    }

    // method to add entry
    // method to add entry
    public AddressBookEntity addEntry(AddressBookDTO addressBookDTO){
        // Create a new AddressBookEntity using the data from the AddressBookDTO
        AddressBookEntity addressBookEntity = new AddressBookEntity(
                idCounter++, // Increment the idCounter for each new entry
                addressBookDTO.getName(), // Set the name
                addressBookDTO.getAddress(), // Set the address
                addressBookDTO.getEmail(), // Set the email
                addressBookDTO.getPhoneNumber() // Set the phone number
        );

        // Add the newly created address book entity to the list
        addressBookList.add(addressBookEntity);

        // Return the newly created addressBookEntity
        return addressBookEntity;
    }


    // method to find entry by id
    public AddressBookEntity getEntryById(Long id){
        Optional<AddressBookEntity> addressBookEntity = addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();
        return addressBookEntity.orElse(null);
    }

    // method to update entry
    public AddressBookEntity updateEntry(Long id, AddressBookDTO addressBookDTO){
        AddressBookEntity existingEntity = getEntryById(id);
        if (existingEntity != null) {
            existingEntity.setName(addressBookDTO.getName());
            existingEntity.setAddress(addressBookDTO.getAddress());
            existingEntity.setEmail(addressBookDTO.getEmail());
            existingEntity.setPhoneNumber(addressBookDTO.getPhoneNumber());
            return existingEntity;
        }
        return null;
    }

    // method to delete entry
    public boolean deleteEntry(Long id){
        AddressBookEntity addressBookEntity = getEntryById(id);
        if (addressBookEntity != null) {
            addressBookList.remove(addressBookEntity);
            return true;
        }
        return false;
    }
}






// service  layer to write all functions(ex-crud oprations)
//
//@Service
//public class AddressBookService {
//    @Autowired
//    AddressBookRepository addressBookRepository;
//
//    // method for return all the entries
//    public List<AddressBookEntity> getAllEntries(){
//        return addressBookRepository.findAll();
//    }
//
//    // method to add entry
//    public AddressBookEntity addEntry(AddressBookDTO addressBookDTO){
//        AddressBookEntity addressBookEntity = new AddressBookEntity(addressBookDTO.getName(), addressBookDTO.getAddress(),addressBookDTO.getEmail(),addressBookDTO.getPhoneNumber());
//        return addressBookRepository.save(addressBookEntity);
//    }
//
//    // method to find entry by id
//    public AddressBookEntity getEntryById(Long id){
//        return addressBookRepository.findById(id).orElse(null);
//    }
//
//    // method to update entry
//    public AddressBookEntity updateEntry(Long id, AddressBookDTO addressBookDTO){
//        if(addressBookRepository.existsById(id)){
//            AddressBookEntity addressBookEntity = new AddressBookEntity(addressBookDTO.getName(), addressBookDTO.getAddress(),addressBookDTO.getEmail(),addressBookDTO.getPhoneNumber());
//            return addressBookRepository.save(addressBookEntity);
//        }
//        return null;
//    }
//    // method for delete entry
//    public boolean deleteEntry(Long id){
//        if(addressBookRepository.existsById(id)){
//            addressBookRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//}


