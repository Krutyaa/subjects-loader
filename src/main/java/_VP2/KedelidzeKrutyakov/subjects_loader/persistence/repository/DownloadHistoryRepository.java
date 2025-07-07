package _VP2.KedelidzeKrutyakov.subjects_loader.persistence.repository;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.Download;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadHistoryRepository extends
        JpaRepository<Download, Long> {
}
