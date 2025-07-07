package _VP2.KedelidzeKrutyakov.subjects_loader.batch;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.DetailInfoResponse;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.repository.BlacklistSubjectRepository;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.repository.DownloadHistoryRepository;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableBatchProcessing
public class BlacklistBatchConfig {

    private JobBuilder jobBuilder;

    private StepBuilder stepBuilder;

    private BlacklistSubjectRepository blacklistRepository;
    private DownloadHistoryRepository downloadRepository;

}
