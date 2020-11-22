package com.thoughtworks.xbyi.persona.test.domain.repository;

import com.thoughtworks.xbyi.persona.Application;
import com.thoughtworks.xbyi.persona.domain.entity.ConsumeFeature;
import com.thoughtworks.xbyi.persona.domain.entity.Credit;
import com.thoughtworks.xbyi.persona.domain.repository.IConsumeRepository;
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
public class IConsumeRepositoryTest {
    private final static Logger logger = LoggerFactory.getLogger(ICreditRepositoryTest.class);
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IConsumeRepository consumeRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(consumeRepository).isNotNull();
    }


    private ConsumeFeature insert(ConsumeFeature consumeFeature) {
        return  consumeRepository.save(consumeFeature);
    }

    private ConsumeFeature insert(int relax, int mother, int car) {
        ConsumeFeature consume = new ConsumeFeature();
        consume.setCatering(relax);
        consume.setMother(mother);
        consume.setCar(car);
        return  consumeRepository.save(consume);
    }

    @Test
    public void find_all_data() {
//        ConsumeFeature credit = new ConsumeFeature(0, 1, 0, 1, 1,0, 1);
        ConsumeFeature consume = insert(1,1,1);
        assert consume.getId() != null;
        logger.debug(consume.toString());
        List<ConsumeFeature> results = consumeRepository.findAll();
        assertThat(results.size() > 0);
    }

}
