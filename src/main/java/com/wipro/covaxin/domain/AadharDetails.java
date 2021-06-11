package com.wipro.covaxin.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AadharDetails {
	
	@Id
	@Column(name = "id")
	private Long aadharId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@Column(nullable = false)
	private String gender;

	public Long getAadharId() {
		return aadharId;
	}

	public void setAadharId(Long aadharId) {
		this.aadharId = aadharId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadharId == null) ? 0 : aadharId.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AadharDetails other = (AadharDetails) obj;
		if (aadharId == null) {
			if (other.aadharId != null)
				return false;
		} else if (!aadharId.equals(other.aadharId))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AadharDetails [aadharId=" + aadharId + ", name=" + name + ", dob=" + dob + ", gender=" + gender + "]";
	}
}
