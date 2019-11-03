package com.kodilla.travel.controller;

import com.kodilla.travel.mappers.HotelMapper;
import com.kodilla.travel.service.HotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelController.class)
public class HotelControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelService hotelService;

    @MockBean
    private HotelMapper hotelMapper;

    @Test
    public void shouldFetchAllHotels() throws Exception {
        //Given
        //When & Then
    }
}
