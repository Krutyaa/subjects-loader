package _VP2.KedelidzeKrutyakov.subjects_loader.batch;

import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.DetailInfoResponse;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.SearchData;
import _VP2.KedelidzeKrutyakov.subjects_loader.persistence.entity.SearchResponse;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Iterator;

public class CbrApiReader implements ItemReader<DetailInfoResponse> {

    private final RestTemplate restTemplate;
    private final String searchUrl;
    private final String detailInfoUrl;

    private final int thema;
    private final String dateFrom;
    private final String dateTo;
    private int currentPage = 0;
    private Iterator<SearchData> currentItems = Collections.emptyIterator();
    private boolean noMorePages = false;

    public CbrApiReader(
            String searchUrl, String detailInfoUrl,
            int thema ,String dateFrom, String dateTo) {
        restTemplate = new RestTemplate();

        this.searchUrl = searchUrl;
        this.detailInfoUrl = detailInfoUrl;
        this.thema = thema;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public DetailInfoResponse read() throws
            Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        while (!currentItems.hasNext() && !noMorePages) {
            loadNextPage();
        }

        if (!currentItems.hasNext()) {
            return null;
        }

        SearchData item = currentItems.next();

        String detailUrl = detailInfoUrl + item.getId();
        ResponseEntity<DetailInfoResponse> detailResponse =
                restTemplate.getForEntity(detailUrl, DetailInfoResponse.class);

        return detailResponse.getBody();
    }

    private void loadNextPage() {
        String url = String.format("%s?thema=%s&page=%d&dateFrom=%s&dateTo=%s",
                searchUrl, thema, currentPage, dateFrom, dateTo);

        ResponseEntity<SearchResponse> response =
                restTemplate.getForEntity(url, SearchResponse.class);

        SearchResponse body = response.getBody();

        if (body == null || body.getData().isEmpty()) {
            noMorePages = true;
            currentItems = Collections.emptyIterator();
        } else {
            currentItems = body.getData().iterator();
            currentPage++;
        }
    }
}
