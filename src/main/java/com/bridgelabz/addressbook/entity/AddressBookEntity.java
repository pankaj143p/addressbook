package com.bridgelabz.addressbook.entity;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddressBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public AddressBookEntity(Long id, String name, String address, String phoneNumber, String email) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;

    }

//    public AddressBookEntity(String name, String address, String phoneNumber, String email) {
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public AddressBookEntity() {
    }

    // Constructor that accepts AddressBookDTO
    public AddressBookEntity(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.email = addressBookDTO.getEmail();
    }

}
