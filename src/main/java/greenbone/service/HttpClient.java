package greenbone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("prototype")
public class HttpClient<T, R> {
    private final String url;

    private final HttpHeaders headers;

    public HttpClient(final String url) {
        this.url = url;
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public ResponseEntity<R> doRequest(HttpMethod httpMethod, T object, Class<R> responseType) {
        HttpEntity<T> entity = new HttpEntity<>(object, headers);
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        return restTemplate.exchange(url, httpMethod, entity, responseType);
    }

    public void setContentType(MediaType contentType) {
        headers.setContentType(contentType);
    }
}
