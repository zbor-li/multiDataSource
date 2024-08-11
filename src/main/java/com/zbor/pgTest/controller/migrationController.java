package com.zbor.pgTest.controller;


import com.zbor.pgTest.service.MulDatasOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/migrate")
public class migrationController {

    @Autowired
    private MulDatasOptService mulDatasOptService;

    @GetMapping
    public void migrationData() {
        mulDatasOptService.migrateDataFromAToB();
    }
}
