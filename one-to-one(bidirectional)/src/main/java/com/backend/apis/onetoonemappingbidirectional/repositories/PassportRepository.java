package com.backend.apis.onetoonemappingbidirectional.repositories;

import com.backend.apis.onetoonemappingbidirectional.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {
}
