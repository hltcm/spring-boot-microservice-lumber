package com.tomruk.treetypeservice.controller;

import com.tomruk.treetypeservice.dto.TreeTypeRequest;
import com.tomruk.treetypeservice.dto.TreeTypeResponse;
import com.tomruk.treetypeservice.service.TreeTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/treetype")
public class TreeTypeController {

    private final TreeTypeService treeTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTreeType(@RequestBody TreeTypeRequest treeTypeRequest){
        treeTypeService.createTreeType(treeTypeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TreeTypeResponse> getAllTreeTypes(){
        return treeTypeService.getAllTreeTypes();
    }
}
