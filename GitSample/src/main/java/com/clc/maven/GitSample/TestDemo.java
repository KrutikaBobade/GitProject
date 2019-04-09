package com.clc.maven.GitSample;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

public class TestDemo {

	public static void main(String[] args) throws IOException {
		Emp e1 = new Emp(1,"AAAA",33,"Pune");
		Emp e2 = new Emp(2,"BAAA",43,"Pune");
		Emp e3 = new Emp(3,"CAAA",13,"Pune");
		Emp e4 = new Emp(4,"DAAA",23,"Pune");
		Emp e5 = new Emp(5,"EAAA",53,"Pune");
		Emp e6 = new Emp(6,"FAAA",63,"Pune");
		Emp e7 = new Emp(7,"AAAA",33,"Pune");
		Emp e8 = new Emp(8,"BAArA",43,"Pune");
		Emp e9 = new Emp(9,"fCAAA",13,"Pune");
		Emp e10 = new Emp(10,"DAAA",23,"Pune");
		Emp e11 = new Emp(11,"EAAgrA",53,"Pune");
		Emp e12 = new Emp(12,"FAArA",63,"Pune");
		
		LinkedHashSet<Emp> setOfEmps = new LinkedHashSet<Emp>();
		setOfEmps.add(e1);
		setOfEmps.add(e2);
		setOfEmps.add(e3);
		setOfEmps.add(e4);
		setOfEmps.add(e5);
		setOfEmps.add(e6);
		setOfEmps.add(e7);
		setOfEmps.add(e8);
		setOfEmps.add(e9);
		setOfEmps.add(e12);
		setOfEmps.add(e10);
		setOfEmps.add(e11);
	//	ExcelUtility.excleWrite(setOfEmps);
		//System.out.println(setOfEmps);
		List<Emp> emps = ExcelUtility.excleRead();
		System.out.println(emps);
		}

}
class Emp{
	private int empId;
	private String empName;
	private int empAge;
	private String empAddress;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
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
		Emp other = (Emp) obj;
		if (empId != other.empId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\n Emp [empId=" + empId + ", empName=" + empName + ", empAge="
				+ empAge + ", empAddress=" + empAddress + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Emp(int empId, String empName, int empAge, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empAddress = empAddress;
	}
	
	public Emp(){
		
	}
}