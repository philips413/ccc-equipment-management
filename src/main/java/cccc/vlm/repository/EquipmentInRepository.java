package cccc.vlm.repository;

import cccc.vlm.entity.EquipmentIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentInRepository extends JpaRepository<EquipmentIn, Integer> {
}
