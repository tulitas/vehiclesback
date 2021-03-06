package back.repositories;

import back.models.MLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MLoanRepository extends JpaRepository<MLoan, Long> {

    @Query(value = "select MAX(account_no) from m_loan ", nativeQuery = true)
    Integer getLastId();

    @Query(value = "SELECT loan_id, amount FROM m_loan_transaction where amount > 1000", nativeQuery = true)
    List getUnits();


}
