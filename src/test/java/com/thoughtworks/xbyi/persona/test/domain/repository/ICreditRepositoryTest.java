package com.thoughtworks.xbyi.persona.test.domain.repository;

import com.thoughtworks.xbyi.persona.Application;
import com.thoughtworks.xbyi.persona.domain.entity.Credit;
import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import com.thoughtworks.xbyi.persona.domain.repository.DemographicRepository;
import com.thoughtworks.xbyi.persona.domain.repository.ICreditRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ActiveProfiles("test")
public class ICreditRepositoryTest {
    private final static Logger logger = LoggerFactory.getLogger(ICreditRepositoryTest.class);
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ICreditRepository creditRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(creditRepository).isNotNull();
    }

    private Credit insert(String job) {
        Credit credit = new Credit();
        credit.setJob(job);
        return  creditRepository.save(credit);
    }

    private Credit insert(Credit creditInfo) {
        return  creditRepository.save(creditInfo);
    }

    @Test
    public void find_all_data() {
        Credit credit = insert("teacher");
//        Credit credit = new Credit("IT打工人", 100.0, 100.0, 10, 1, 80)；
        assert credit.getId() != null;
        logger.debug(credit.toString());
        List<Credit> results = creditRepository.findAll();
        assertThat(results.size() > 0);
    }

}
