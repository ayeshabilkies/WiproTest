package com.wipro.covaxin.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aadhar_details", referencedColumnName = "id")
	private AadharDetails aadharDetails;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate vaccinationTimeSlot;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AadharDetails getAadharDetails() {
		return aadharDetails;
	}

	public void setAadharDetails(AadharDetails aadharDetails) {
		this.aadharDetails = aadharDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getVaccinationTimeSlot() {
		return vaccinationTimeSlot;
	}

	public void setVaccinationTimeSlot(LocalDate vaccinationTimeSlot) {
		this.vaccinationTimeSlot = vaccinationTimeSlot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadharDetails == null) ? 0 : aadharDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vaccinationTimeSlot == null) ? 0 : vaccinationTimeSlot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (aadharDetails == null) {
			if (other.aadharDetails != null)
				return false;
		} else if (!aadharDetails.equals(other.aadharDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vaccinationTimeSlot == null) {
			if (other.vaccinationTimeSlot != null)
				return false;
		} else if (!vaccinationTimeSlot.equals(other.vaccinationTimeSlot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", aadharDetails=" + aadharDetails + ", name=" + name + ", vaccinationTimeSlot="
				+ vaccinationTimeSlot + "]";
	}
	
}
