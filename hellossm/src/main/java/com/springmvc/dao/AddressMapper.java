package com.springmvc.dao;

import com.springmvc.pojo.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AddressMapper {
    List<Address> getAddressByUserId(int id);

    void addAddress(Address address);

    int updateAddress(Address address);

    int deleteAddress(int addrId);

    Address selectAddressById(int addrId);
}
