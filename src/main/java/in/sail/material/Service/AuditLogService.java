package in.sail.material.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.sail.material.Entity.AuditLog; 
import in.sail.material.Repository.AuditLogRepositiory;
@Service
public class AuditLogService {
	@Autowired
	private AuditLogRepositiory auditLogRepositiory;

	public List<AuditLog> fetchAllLogs() {
		// TODO Auto-generated method stub
		return auditLogRepositiory.findAll();
	}

}
