package cccc.vlm.repository;

import cccc.vlm.entity.EquipmentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentLogRepository extends JpaRepository<EquipmentLog, String> {
}
