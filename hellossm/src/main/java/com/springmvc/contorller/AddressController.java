package com.springmvc.contorller;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.Address;
import com.springmvc.pojo.Order;
import com.springmvc.service.AddressService;
import com.springmvc.util.TokenUserIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RequestMapping("/address")
@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/getAllAddress")
    @ResponseBody
    public Map<String, Object> getAddressByUserId(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("addressList", addressService.getAddrByUserId(TokenUserIdUtil.getLoginerId(request)));
            map.put("status", 200);
        } catch (MyException e) {
            map.put("status", 201);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/addAddress")
    @ResponseBody
    public Map<String, Object> addAddress(HttpServletRequest request, @RequestBody Address address) {
        Map<String, Object> map = new HashMap<>();
        address.setUserId(TokenUserIdUtil.getLoginerId(request));
        addressService.addAddress(address);
        map.put("status", 200);
        return map;
    }

    @RequestMapping(value = "/updateAddress")
    @ResponseBody
    public Map<String, Object> updateAddress(@RequestBody Address address) {
        Map<String, Object> map = new HashMap<>();
        if (addressService.updateAddress(address) == 1) {
            map.put("status", 200);
        }
        return map;
    }

    @RequestMapping(value = "/deleteAddress")
    @ResponseBody
    public Map<String, Object> deleteAddress(@RequestBody Address address) {
        Map<String, Object> map = new HashMap<>();
        if (address == null) {
            map.put("status", 201);
        } else if (addressService.deleteAddress(address.getId()) == 1) {
            map.put("status", 200);
        } else {
            map.put("status", 201);
        }
        return map;
    }
}
