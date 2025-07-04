package _VP2.KedelidzeKrutyakov.subjects_loader.persistence.repository;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.BlacklistSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistSubjectRepository extends
        JpaRepository<BlacklistSubject, Long> {
}
