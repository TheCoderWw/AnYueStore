package com.springmvc.service;

import com.springmvc.dao.AddressMapper;
import com.springmvc.dao.MyException;
import com.springmvc.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddrByUserId(int userId) throws MyException {
        List<Address> addressList = addressMapper.getAddressByUserId(userId);
        if (addressList == null)
            throw new MyException("该用户暂无收货地址");
        return addressList;
    }

    @Override
    public void addAddress(Address address) {
        addressMapper.addAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int deleteAddress(int addrId) {
        return addressMapper.deleteAddress(addrId);
    }


}
