package com.backend.apis.onetoonemappingbidirectional.repositories;

import com.backend.apis.onetoonemappingbidirectional.entities.Passport;
import com.backend.apis.onetoonemappingbidirectional.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("SELECT p.passport FROM Person p WHERE p.secretKey = :secretKey")
    Optional<Passport> findPassportBySecretKey(String secretKey);

}
