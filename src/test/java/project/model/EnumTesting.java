package project.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class EnumTesting {

	@Test
	public void userRoleManager() {
		//USER_ROLES.EMPLOYEE
		assertTrue(USER_ROLES.MANAGER.toString().equals("MANAGER"));
	}
	@Test
	public void userRoleEmployee() {
		//USER_ROLES.EMPLOYEE
		assertEquals(USER_ROLES.EMPLOYEE.toString().equals("EMPLOYEE"),true);
	}
	@Test
	public void statusPending() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_STATUS.PENDING.toString().equals("PENDING"),true);
	}
	@Test
	public void statusApproved() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_STATUS.APPROVED.toString().equals("APPROVED"),true);
	}
	@Test
	public void statusDenied() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_STATUS.DENIED.toString().equals("DENIED"),true);
	}
	@Test
	public void typeFood() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_TYPE.FOOD.toString().equals("FOOD"),true);
	}
	@Test
	public void typeLoding() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_TYPE.LODGING.toString().equals("LODGING"),true);
	}
	@Test
	public void typeTravel() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_TYPE.TRAVEL.toString().equals("TRAVEL"),true);
	}
	@Test
	public void typeOther() {
		//USER_ROLES.EMPLOYEE
		assertEquals(REIMBURSEMENT_TYPE.OTHER.toString().equals("OTHER"),true);
	}
	
}
