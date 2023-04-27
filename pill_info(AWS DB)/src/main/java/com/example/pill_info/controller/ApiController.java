package com.example.pill_info.controller;

import com.example.pill_info.model.epillinfo;
import com.example.pill_info.model.mediinfo;
import com.example.pill_info.repository.epillinfoRepository;
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
    @Autowired
    private epillinfoRepository infoRepository3;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<mediinfo> result() {
        List<mediinfo> mediinfoList = infoRepository.findAll();
        return mediinfoList;
    }

    @RequestMapping(value = "/epill_all", method = RequestMethod.GET)
    public List<epillinfo> result3() {
        List<epillinfo> epillinfoList = infoRepository3.findAll();
        return epillinfoList;
    }

}
