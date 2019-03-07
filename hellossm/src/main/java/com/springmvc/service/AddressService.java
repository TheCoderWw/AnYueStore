package com.springmvc.service;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddrByUserId(int userId) throws MyException;

    void addAddress(Address address);

    int updateAddress(Address address);

    int deleteAddress(int addrId);
}
