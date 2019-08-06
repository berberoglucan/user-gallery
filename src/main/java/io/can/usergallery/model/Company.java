package io.can.usergallery.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable{

	private static final long serialVersionUID = 3013411748496358166L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyId;

	private String name;

	@Column(name = "catch_phrase")
	private String catchPhrase;

	private String bs;

	public Company() {
		super();
	}

	public Company(String name, String catchPhrase, String bs) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bs, catchPhrase, companyId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
		return Objects.equals(bs, other.bs) && Objects.equals(catchPhrase, other.catchPhrase)
				&& Objects.equals(companyId, other.companyId) && Objects.equals(name, other.name);
	}

}
