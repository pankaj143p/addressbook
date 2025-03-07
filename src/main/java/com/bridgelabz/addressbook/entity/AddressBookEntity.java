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
    private String city;


    private String state;
    private String zipCode;
    private String phoneNumber;

    public AddressBookEntity(Long id, String name, String address, String city, String state, String zipCode, String phoneNumber) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;

    }

    public AddressBookEntity(String name, String address, String city, String state, String zipCode, String phoneNumber) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;
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

    public String getState() {
        return state;
    }

    public void setState(String state){
        this.state=state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
    public AddressBookEntity() {
    }

    // Constructor that accepts AddressBookDTO
    public AddressBookEntity(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();

    }

}
