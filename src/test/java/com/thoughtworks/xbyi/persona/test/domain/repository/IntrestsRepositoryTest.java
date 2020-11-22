package com.thoughtworks.xbyi.persona.test.domain.repository;

import com.thoughtworks.xbyi.persona.Application;

import com.thoughtworks.xbyi.persona.domain.entity.ConsumeFeature;
import com.thoughtworks.xbyi.persona.domain.entity.Intrests;
import com.thoughtworks.xbyi.persona.domain.repository.IntrestsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ActiveProfiles("test")
public class IntrestsRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(IntrestsRepositoryTest.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IntrestsRepository intrestsRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(intrestsRepository).isNotNull();
    }

    private Intrests insert(int outdoors, int techEnthusiasts, int fitnessEnthusiasts) {
        Intrests intrests = new Intrests();
        intrests.setOutdoors(outdoors);
        intrests.setTechEnthusiasts(techEnthusiasts);
        intrests.setFitnessEnthusiasts(fitnessEnthusiasts);
        return  intrestsRepository.save(intrests);
    }

    /**
     * 为了避免脏数据，Spring Framework 3我们用@Roolback回滚，spirngBoot使用@Transactional
     */
    @Test
    @Transactional
    public void find_all_data() {
        Intrests intrests = insert(1,1,1);
        assert intrests.getId() != null;
        logger.debug(intrests.toString());
        List<Intrests> results = intrestsRepository.findAll();
        assertThat(results.size() > 0);
    }
}
