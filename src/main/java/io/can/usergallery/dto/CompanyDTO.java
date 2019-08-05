package io.can.usergallery.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable {

	private static final long serialVersionUID = -4097085896522237384L;

	private String name;

	private String catchPhrase;

	private String bs;

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
	public String toString() {
		return "CompanyDTO [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}

}
