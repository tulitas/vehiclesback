package back.repositories;

import back.models.MLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MLoanRepository extends JpaRepository<MLoan, Long> {
}
