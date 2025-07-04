package _VP2.KedelidzeKrutyakov.subjects_loader.batch;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.BlacklistSubject;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;

public class CbrApiReader implements ItemReader<BlacklistSubject> {

    private final RestTemplate cbrRequest;

    private final String searchUrl;
    private final String detailInfoUrl;

    public CbrApiReader(String searchUrl, String detailInfoUrl) {
        cbrRequest = new RestTemplate();

        this.searchUrl = searchUrl;
        this.detailInfoUrl = detailInfoUrl;
    }

    @Override
    public BlacklistSubject read() throws
            Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        return null;
    }
}
