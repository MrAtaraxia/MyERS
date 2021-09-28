package project.service;

import java.util.List;

import project.dao.ERS_REIMBURSEMENTDao;
import project.model.ERS_REIMBURSEMENT;
import project.model.REIMBURSEMENT_STATUS;
import project.model.REIMBURSEMENT_TYPE;

public class ReimbursementServices implements ReimbursementService{
	
	private ERS_REIMBURSEMENTDao reiDao;
	
	public ReimbursementServices() {
		this.reiDao=new ERS_REIMBURSEMENTDao();
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementServices(ERS_REIMBURSEMENTDao reiDao) {
		this.reiDao = reiDao;
	}
	
	@Override
	public ERS_REIMBURSEMENT retrieveReimbursement(Integer id) {
		return reiDao.selectERS_REIMBURSEMENT(id);
	}

	@Override
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursements() {
		return reiDao.selectAll();
	}

	@Override
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByType(REIMBURSEMENT_TYPE type) {
		return reiDao.selectByREIMB_TYPE(type);
	}

	@Override
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByStatus(REIMBURSEMENT_STATUS status) {
		System.out.println("RETRIEVE BY STATUS START:" + status);
		return reiDao.selectByStatusQuery(status);	
	}

	@Override
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByStatusAndUserID(REIMBURSEMENT_STATUS status, Integer id) {
		System.out.println("RETRIEVE BY STATUS AND ID START:" + status + "ID:" + id);
		return reiDao.selectByStatusAndIDQuery(status, id);	
	}
	
	@Override
	public List<ERS_REIMBURSEMENT> retrieveAllReimbursementsByAuthorID(Integer AuthorID) {
		return reiDao.selectByAuthorID(AuthorID);
	}

	@Override
	public Boolean createReimbursement(ERS_REIMBURSEMENT bursment) {
		return reiDao.insert(bursment);
	}

	@Override
	public Boolean updateReimbursement(ERS_REIMBURSEMENT bursment) {
		return reiDao.update(bursment);
	}

	@Override
	public Boolean deleteReimbursement(ERS_REIMBURSEMENT bursment) {
		return reiDao.delete(bursment);
	}

	public ERS_REIMBURSEMENTDao getEriDao() {
		return reiDao;
	}

	public void setEriDao(ERS_REIMBURSEMENTDao reiDao) {
		this.reiDao = reiDao;
	}

	
}
