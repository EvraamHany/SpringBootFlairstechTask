package com.flairstech.task;

import com.flairstech.task.entities.CountryView;
import com.flairstech.task.rest.CountryViewController;
import com.flairstech.task.services.CountryViewService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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

    CountryView countryView = new CountryView("AFG","Afghanistan","Asia",
            "Southern and Central Asia",45,"Pashto");


    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void checkIfCountryWithCodeIsExist() throws Exception {
//
        Mockito.when(
                countryViewService.getCountryData(Mockito.anyString())).thenReturn(countryView);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/service/country/AFG").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"code\": \"AFG\",\n" +
                "    \"name\": \"Afghanistan\",\n" +
                "    \"continent\": \"Asia\",\n" +
                "    \"region\": \"Southern and Central Asia\",\n" +
                "    \"lifeExpectancy\": 45,\n" +
                "    \"language\": \"Pashto\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);



    }


}
