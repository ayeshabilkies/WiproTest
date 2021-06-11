package com.wipro.covaxin.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.covaxin.domain.AadharDetails;
import com.wipro.covaxin.domain.Applicant;
import com.wipro.covaxin.repository.ApplicantRepository;

@RestController
@RequestMapping("/api")
public class ApplicantController {
	
	@Autowired
	private ApplicantRepository applicantRepository;

	@GetMapping("/applicants")
	public ResponseEntity<List<Applicant>> getAllApplicants() {
		try {
			List<Applicant> applicants;

			applicants = applicantRepository.findAll();

			if (applicants.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(applicants, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/applicants/{id}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable("id") long id) {
		Optional<Applicant> applicant = applicantRepository.findById(id);

		if (applicant.isPresent()) {
			return new ResponseEntity<>(applicant.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/applicants")
	public ResponseEntity<Object> createApplicant(@RequestBody Applicant applicant) {
		AadharDetails _ad = applicant.getAadharDetails();
		int applicantAge = Period.between(_ad.getDob(), LocalDate.now()).getYears();
		try {
			if(applicant.getId() != null) {
				return new ResponseEntity<>("New applicant cannot have id.", HttpStatus.BAD_REQUEST);
			}
			
			if(applicantAge < 45) {
				return new ResponseEntity<>(applicantAge + " years is not eligible. Minimum age for registration is 45 years.", HttpStatus.BAD_REQUEST);
			}
			Applicant _applicant = applicantRepository
					.save(applicant);
			return new ResponseEntity<>(_applicant, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/applicants/{id}")
	public ResponseEntity<Applicant> updateApplicant(@PathVariable("id") long id, @RequestBody Applicant applicant) {
		Optional<Applicant> _applicant = applicantRepository.findById(id);

		if (_applicant.isPresent()) {
			return new ResponseEntity<>(applicantRepository.save(applicant), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/applicants/{id}")
	public ResponseEntity<HttpStatus> deleteApplicant(@PathVariable("id") long id) {
		try {
			applicantRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
