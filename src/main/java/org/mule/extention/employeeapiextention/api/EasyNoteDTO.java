package org.mule.extention.employeeapiextention.api;

import java.io.Serializable;

public class EasyNoteDTO implements Serializable {
    private String ename;
    private int age;
    private String contactNo;
    private String department;
    private String designation;
    private String dob;
    private String doj;
    private String gender;
    private Address address;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", contactNo='" + contactNo + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", dob='" + dob + '\'' +
                ", doj='" + doj + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }
}
