package in.sail.material.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sail.material.Entity.AuditLog;
import in.sail.material.Service.AuditLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/audit-log")
@Tag(name = "Audit Log", description = "all the Logs can be checked here")
public class AuditLogController {
	@Autowired
	private AuditLogService auditLogService;
	@GetMapping
	@Operation(summary = "Get all the logs from here")
	public ResponseEntity<List<AuditLog>> getAllLogs(){
		List<AuditLog> logs= auditLogService.fetchAllLogs();
		return ResponseEntity.ok(logs);
	}

}
