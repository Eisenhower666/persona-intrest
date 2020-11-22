package com.thoughtworks.xbyi.persona.test.application.restful;

import com.thoughtworks.xbyi.persona.Application;
import com.thoughtworks.xbyi.persona.domain.entity.ConsumeFeature;
import com.thoughtworks.xbyi.persona.domain.entity.Credit;
import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import com.thoughtworks.xbyi.persona.domain.entity.Intrests;
import com.thoughtworks.xbyi.persona.domain.repository.DemographicRepository;
import com.thoughtworks.xbyi.persona.domain.repository.IConsumeRepository;
import com.thoughtworks.xbyi.persona.domain.repository.ICreditRepository;
import com.thoughtworks.xbyi.persona.domain.repository.IntrestsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PersonaProfileEndPointTest {
    private final static Logger logger = LoggerFactory.getLogger(PersonaProfileEndPointTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DemographicRepository demographicRepository;

    @Autowired
    private ICreditRepository creditRepository;

    @Autowired
    private IConsumeRepository consumeRepository;

    @Autowired
    private IntrestsRepository intrestsRepository;

    private Credit create(String job){
        Credit credit = new Credit();
        credit.setJob(job);
        return creditRepository.save(credit);
    }

    private Demographic insert(String name) {
        Demographic demographic = new Demographic();
        demographic.setName(name);
        return demographicRepository.save(demographic);
    }

    private ConsumeFeature insert(int catering, int mother, int car, int financial) {
        ConsumeFeature consume = new ConsumeFeature();
        consume.setCatering(catering);
        consume.setMother(mother);
        consume.setCar(car);
        consume.setFinancial(financial);
        return consumeRepository.save(consume);
    }

    private Intrests add(int outdoors, int techEnthusiasts, int car, int fitnessEnthusiasts) {
        Intrests intrests = new Intrests();
        intrests.setOutdoors(outdoors);
        intrests.setTechEnthusiasts(techEnthusiasts);
        intrests.setFitnessEnthusiasts(fitnessEnthusiasts);
        return  intrestsRepository.save(intrests);
    }

    @Test
    public void get_all_demographics() throws Exception {
        insert("demographic");
        mockMvc.perform(get("/v1/api/demographics").contextPath("/v1/api").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void get_all_credit() throws Exception{
        create("dagongren");
        mockMvc.perform(get("/v1/api/credit").contextPath("/v1/api").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void get_all_consume() throws Exception{
        insert(1, 1, 1, 0);
        mockMvc.perform(get("/v1/api/consume").contextPath("/v1/api").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void get_all_intrests() throws Exception{
        add(1, 1, 1, 0);
        mockMvc.perform(get("/v1/api/intrests").contextPath("/v1/api").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray());
    }

}
