package com.one.to.one.unidirectional.mapping.repositories;

import com.one.to.one.unidirectional.mapping.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {
}
