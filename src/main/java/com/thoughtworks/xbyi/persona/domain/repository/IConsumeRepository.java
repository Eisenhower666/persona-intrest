package com.thoughtworks.xbyi.persona.domain.repository;

import com.thoughtworks.xbyi.persona.domain.entity.ConsumeFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsumeRepository extends JpaRepository<ConsumeFeature, Long> {
}
