package com.tomruk.treetypeservice.service;

import com.tomruk.treetypeservice.dto.TreeTypeRequest;
import com.tomruk.treetypeservice.dto.TreeTypeResponse;
import com.tomruk.treetypeservice.model.TreeType;
import com.tomruk.treetypeservice.repository.TreeTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TreeTypeService {
    private  final TreeTypeRepository treeTypeRepository;

    public void createTreeType(TreeTypeRequest treeTypeRequest){
        TreeType treeType = TreeType.builder()
                .name(treeTypeRequest.getName())
                .createdTs(Instant.now())
                .build();

        treeTypeRepository.save(treeType);
        log.info("Tree Type is saved. Name={}",treeType.getName());
    }

    @SneakyThrows
    public List<TreeTypeResponse> getAllTreeTypes(){
        List<TreeType> treeTypeList =  treeTypeRepository.findAll();
        log.info("Get All Tree Types");
        return treeTypeList.stream().map(this::mapToTreeTypeResponse).collect(Collectors.toList());
    }

    private TreeTypeResponse mapToTreeTypeResponse(TreeType treeType) {
        return TreeTypeResponse.builder()
                .id(treeType.getId())
                .name(treeType.getName())
                .createdTs(treeType.getCreatedTs())
                .updatedTs(treeType.getUpdatedTs())
                .build();
    }
}
