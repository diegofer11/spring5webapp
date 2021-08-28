package guru.springframework.spring5webapp.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer maxTotalConnection;
    private final Integer maxPerRoute;
    private final Integer connectionRqTimeout;
    private final Integer socketTimeout;

    public BlockingRestTemplateCustomizer(@Value("${cfg.maxtotalconnections}") Integer maxTotalConnection,
                                          @Value("${cfg.maxperroute}") Integer maxPerRoute,
                                          @Value("${cfg.conecctionrqtimeout}") Integer connectionRqTimeout,
                                          @Value("${cfg.sockettimeout}") Integer socketTimeout) {

        this.maxTotalConnection = maxTotalConnection;
        this.maxPerRoute = maxPerRoute;
        this.connectionRqTimeout = connectionRqTimeout;
        this.socketTimeout = socketTimeout;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnection);
        connectionManager.setDefaultMaxPerRoute(maxPerRoute);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectionRqTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }

}
