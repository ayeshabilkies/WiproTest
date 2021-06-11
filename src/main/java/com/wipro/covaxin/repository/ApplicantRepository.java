package com.wipro.covaxin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.covaxin.domain.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
