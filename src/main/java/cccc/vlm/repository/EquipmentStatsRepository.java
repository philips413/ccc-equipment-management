package cccc.vlm.repository;

import cccc.vlm.entity.EquipmentStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStatsRepository extends JpaRepository<EquipmentStats, String> {
}
