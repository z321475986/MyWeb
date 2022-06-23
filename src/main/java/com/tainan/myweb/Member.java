package com.tainan.myweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="memberdata")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String identitynum;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String addres;
	@Column
	private String phone;
	@Column
	private String birthday;
	@Column
	private String sex;
	@Column
	private String height;
	@Column
	private String weight;
	@Column
	private String contactname;
	@Column
	private String contactphone;
	@Column
	private String primarycaregiversname;
	@Column
	private String primarycaregiversphone;
	@Column
	private String pastmedicalhistory;
	@Column
	private String chronicmedicalhistory;
	@Column
	private String cmslevel;
	@Column
	private String dementialevel;
	@Column
	private String medicationprofile;
	@Column
	private String allergy;
	@Column
	private String financialsituation;
	@Column
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentitynum() {
		return identitynum;
	}
	public void setIdentitynum(String identitynum) {
		this.identitynum = identitynum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	public String getPrimarycaregiversname() {
		return primarycaregiversname;
	}
	public void setPrimarycaregiversname(String primarycaregiversname) {
		this.primarycaregiversname = primarycaregiversname;
	}
	public String getPrimarycaregiversphone() {
		return primarycaregiversphone;
	}
	public void setPrimarycaregiversphone(String primarycaregiversphone) {
		this.primarycaregiversphone = primarycaregiversphone;
	}
	public String getPastmedicalhistory() {
		return pastmedicalhistory;
	}
	public void setPastmedicalhistory(String pastmedicalhistory) {
		this.pastmedicalhistory = pastmedicalhistory;
	}
	public String getChronicmedicalhistory() {
		return chronicmedicalhistory;
	}
	public void setChronicmedicalhistory(String chronicmedicalhistory) {
		this.chronicmedicalhistory = chronicmedicalhistory;
	}
	public String getCmslevel() {
		return cmslevel;
	}
	public void setCmslevel(String cmslevel) {
		this.cmslevel = cmslevel;
	}
	public String getDementialevel() {
		return dementialevel;
	}
	public void setDementialevel(String dementialevel) {
		this.dementialevel = dementialevel;
	}
	public String getMedicationprofile() {
		return medicationprofile;
	}
	public void setMedicationprofile(String medicationprofile) {
		this.medicationprofile = medicationprofile;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public String getFinancialsituation() {
		return financialsituation;
	}
	public void setFinancialsituation(String financialsituation) {
		this.financialsituation = financialsituation;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", identitynum=" + identitynum + ", email=" + email
				+ ", password=" + password + ", addres=" + addres + ", phone=" + phone + ", birthday=" +birthday
				+ ", sex=" + sex + ", height=" + height + ", weight=" + weight + ", contactname=" + contactname
				+ ", contactphone=" + contactphone + ", primarycaregiversname=" + primarycaregiversname
				+ ", primarycaregiversphone=" + primarycaregiversphone + ", pastmedicalhistory=" + pastmedicalhistory
				+ ", chronicmedicalhistory=" + chronicmedicalhistory + ", cmslevel=" + cmslevel + ", dementialevel="
				+ dementialevel + ", medicationprofile=" + medicationprofile + ", allergy=" + allergy
				+ ", financialsituation=" + financialsituation + ", note=" + note + "]";
	}
}
