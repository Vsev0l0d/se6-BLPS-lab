package itmo.repositories;

import itmo.model.ImportStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportStatRepository extends JpaRepository<ImportStat, Long> {
    List<ImportStat> findByOwnerMail(String ownerMail);
}
