package com.ordersystem.domain;

public class EmpBeam {
	private Integer emp_id;	//Ա�����
	private String emp_name;	//Ա������
	private String emp_gender;	//Ա���Ա�
	private String emp_birday;	//Ա������
	private Integer emp_age;	//����
	private String emp_idcar;	//���֤����
	private String emp_address;	//��ͥסַ
	private String emp_hire_date;	//��ְʱ��
	private String role_name;	//ְλ����
	private Integer emp_fk_pos_id;		//���ְλid
	private String emp_state;	//״̬(��ְ����ְ\���)
	private Integer code_id;	//״̬���
	private String emp_phone;	//�绰����
	private String emp_pic;		//ͼƬ·��
	public Integer getCode_id() {
		return code_id;
	}
	public void setCode_id(Integer code_id) {
		this.code_id = code_id;
	}
	public String getEmp_pic() {
		return emp_pic;
	}
	public void setEmp_pic(String emp_pic) {
		this.emp_pic = emp_pic;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_birday() {
		return emp_birday;
	}
	public void setEmp_birday(String emp_birday) {
		this.emp_birday = emp_birday;
	}
	public Integer getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_idcar() {
		return emp_idcar;
	}
	public void setEmp_idcar(String emp_idcar) {
		this.emp_idcar = emp_idcar;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_hire_date() {
		return emp_hire_date;
	}
	public void setEmp_hire_date(String emp_hire_date) {
		this.emp_hire_date = emp_hire_date;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Integer getEmp_fk_pos_id() {
		return emp_fk_pos_id;
	}
	public void setEmp_fk_pos_id(Integer emp_fk_pos_id) {
		this.emp_fk_pos_id = emp_fk_pos_id;
	}
	
	public String getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(String emp_state) {
		this.emp_state = emp_state;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	@Override
	public String toString() {
		return "emp_id=" + emp_id + ", emp_name=" + emp_name
				+ ", emp_gender=" + emp_gender + ", emp_birday=" + emp_birday
				+ ", emp_age=" + emp_age + ", emp_idcar=" + emp_idcar
				+ ", emp_address=" + emp_address + ", emp_hire_date="
				+ emp_hire_date + ", role_name=" + role_name
				+ ", emp_fk_pos_id=" + emp_fk_pos_id + ", emp_state="
				+ emp_state + ", emp_phone=" + emp_phone + ", emp_pic="
				+ emp_pic;
	}
	
	
}
