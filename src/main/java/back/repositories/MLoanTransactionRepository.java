package back.repositories;

import back.models.MLoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MLoanTransactionRepository extends JpaRepository<MLoanTransaction, Long> {


}
