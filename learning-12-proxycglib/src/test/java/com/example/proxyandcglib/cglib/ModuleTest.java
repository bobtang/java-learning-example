package com.example.proxyandcglib.cglib;

import com.example.proxyandcglib.module.Application;
import com.example.proxyandcglib.module.handler.RoleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ModuleTest {

    @Autowired
    private RoleController roleController;
    private MockMvc mockMvc;

    @Before
    public void bf() {
        mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
    }

    @Test
    public void registerTest() throws Exception {
        MvcResult mr = mockMvc.perform(
                MockMvcRequestBuilders.get("/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("nick","myci"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("输出 " + mr.getResponse().getContentAsString());
    }
}
