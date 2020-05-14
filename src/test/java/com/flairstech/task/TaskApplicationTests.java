package com.flairstech.task;

import com.flairstech.task.entities.CountryView;
import com.flairstech.task.rest.CountryViewController;
import com.flairstech.task.services.CountryViewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    private CountryViewController controller;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryViewService countryViewService;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void checkIfCountryWithCodeIsExist() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "service/country/888").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"status\":\"FAIL\",\"code\":\"INVALID_COUNTRY_CODE\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }


}
