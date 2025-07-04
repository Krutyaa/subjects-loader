package _VP2.KedelidzeKrutyakov.subjects_loader.batch;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.BlacklistSubject;
import org.springframework.batch.item.ItemProcessor;

public class BlacklistProcessor implements
        ItemProcessor<BlacklistSubject, BlacklistSubject> {

    @Override
    public BlacklistSubject process(BlacklistSubject blacklistSubject) throws Exception {
        return null;
    }

}
