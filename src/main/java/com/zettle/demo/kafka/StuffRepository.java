package com.zettle.demo.kafka;

import com.zettle.demo.kafka.entity.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Long> {
}
