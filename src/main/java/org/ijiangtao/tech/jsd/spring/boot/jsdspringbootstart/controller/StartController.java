package org.ijiangtao.tech.jsd.spring.boot.jsdspringbootstart.controller;

import org.ijiangtao.tech.jsd.spring.boot.jsdspringbootstart.model.Start;
import org.ijiangtao.tech.jsd.spring.boot.jsdspringbootstart.repository.StartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StartController {

    @Autowired
    private StartRepository startRepository;

    @PostMapping(value = "/start/one")
    public Start saveOne(@RequestParam String message) {
        Start start=new Start();
        start.setMessage(message);
        return startRepository.save(start);
    }

    @GetMapping(value = "/start/all")
    public List<Start> getAll() {
        return startRepository.getAll();
    }

    @DeleteMapping(value = "/start/one")
    public Start deleteOne(@RequestParam int index) {
        return startRepository.delete(index);
    }

}
