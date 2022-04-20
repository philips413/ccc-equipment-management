package cccc.vlm.repository;

import cccc.vlm.entity.Equipment;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@DynamicInsert
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> { }
