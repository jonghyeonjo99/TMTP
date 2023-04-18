package com.example.pill_info.controller;

import com.example.pill_info.model.mediinfo;
import com.example.pill_info.repository.mediinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private mediinfoRepository infoRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<mediinfo> result() {
        List<mediinfo> mediinfoList = infoRepository.findAll();
        return mediinfoList;
    }

}
