package back.repositories;

import back.models.MLoanRepaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MLoanRepaymentSheduleRepository extends JpaRepository<MLoanRepaymentSchedule, Long> {
}
