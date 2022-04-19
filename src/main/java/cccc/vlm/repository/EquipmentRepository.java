package cccc.vlm.repository;

import cccc.vlm.entity.Equipment;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@DynamicInsert
public interface EquipmentRepository extends CrudRepository<Equipment, Long> { }
