package _VP2.KedelidzeKrutyakov.subjects_loader.batch;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.BlacklistSubject;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.DetailInfoResponse;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.Info;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.Theme;
import org.springframework.batch.item.ItemProcessor;

public class BlacklistProcessor implements
        ItemProcessor<DetailInfoResponse, BlacklistSubject> {

    @Override
    public BlacklistSubject process(DetailInfoResponse detailInfoResponse)
            throws Exception {
        if (detailInfoResponse.getInfo() == null || detailInfoResponse.getInfo().isEmpty()) {
            return null; // защита от пустых объектов
        }

        Info info = detailInfoResponse.getInfo().get(0);
        Theme theme = detailInfoResponse.getSigns().get(0);

        BlacklistSubject subject = new BlacklistSubject();
        subject.setId(info.getId());
        subject.setName(info.getNameOrg());
        subject.setTaxNumber(info.getInn());
        subject.setAddress(info.getAddr());
        subject.setComment(info.getComment());
        subject.setBlacklist(theme.getSignRus());
        subject.setSubjectType("ЮЛ");
        subject.setPublished(false);

        // Поля без соответствия заполняются null или не трогаются (birthdate, passportSeries, passportNumber)

        return subject;
    }

}
