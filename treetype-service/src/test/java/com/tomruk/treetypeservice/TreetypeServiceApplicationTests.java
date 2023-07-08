package com.tomruk.treetypeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomruk.treetypeservice.dto.TreeTypeRequest;
import com.tomruk.treetypeservice.repository.TreeTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class TreetypeServiceApplicationTests {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.7");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TreeTypeRepository treeTypeRepository;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void shouldCreateTreeType() throws Exception {
        TreeTypeRequest treeTypeRequest = getTreeTypeRequest();
        String treeTypeRequestString = objectMapper.writeValueAsString(treeTypeRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/treetype")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(treeTypeRequestString))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1, treeTypeRepository.findAll().size());
    }

    private TreeTypeRequest getTreeTypeRequest() {
        return TreeTypeRequest.builder()
                .name("Test")
                .build();
    }
}
