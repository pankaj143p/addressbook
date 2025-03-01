package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookEntity,Long> {
    List<AddressBookEntity> findByNameContaining(String name);
}
