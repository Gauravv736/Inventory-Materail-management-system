package in.sail.material.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sail.material.Entity.AuditLog;
@Repository
public interface AuditLogRepositiory extends JpaRepository<AuditLog, Long>{

}
