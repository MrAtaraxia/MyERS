package project.service;

import java.util.List;

import project.model.ERS_REIMBURSEMENT;
import project.model.ERS_USERS;
import project.model.REIMBURSEMENT_STATUS;
import project.model.REIMBURSEMENT_TYPE;

public interface ReimbursementService {
	/*
	 * Retrieve a Reimbursement by ID.
	 */
	public ERS_REIMBURSEMENT retrieveReimbursement(Integer id);
	/*
	 * Retrieve All Reimbursements.
	 */
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursements();
	/*
	 * Retrieve All Reimbursements by type.
	 */
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByType(REIMBURSEMENT_TYPE type);
	/*
	 * Retrieve All Reimbursements by type.
	 */
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByStatus(REIMBURSEMENT_STATUS status);
	/*
	 * Retrieve Reimbursements by type for a given user.
	 */
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByStatusAndUserID(REIMBURSEMENT_STATUS status, Integer id);
	/*
	 * Retrieve All Reimbursements by type.
	 */
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByAuthorID(Integer AuthorID);
	/*
	 * Create a Reimbursement.
	 */
	public Boolean createReimbursement(ERS_REIMBURSEMENT bursment);
	/*
	 * Update a Reimbursement.
	 */
	public Boolean updateReimbursement(ERS_REIMBURSEMENT bursment);
	/*
	 * Delete a Reimbursement.
	 */
	public Boolean deleteReimbursement(ERS_REIMBURSEMENT bursment);
}
