package io.can.usergallery.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service("bootstrapDataUtil")
public class BootstrapDataUtil {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapperUtils objectMapperUtils;

	Logger logger = LoggerFactory.getLogger(BootstrapDataUtil.class);

	public <S, D> List<D> fetchDatasWithHttpGetMethodGivenUrlForBootstrapDb(String url, Class<S> sourceType,
			Class<D> destinationType) {

		List<S> sourceTypeList = null;

		try {
			ResponseEntity<List<S>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<S>>() {
					});
			sourceTypeList = response.getBody();
		} catch (RestClientException e) {
			logger.error(e.getMessage(), " returning empty list");
			sourceTypeList = new ArrayList<>();
		}

		return objectMapperUtils.mapAll(sourceTypeList, destinationType);
	}

	public <S, D> Optional<D> fetchSingleDataWithHttpGetMethodGivenUrlForBootstrapDb(String url, Class<S> sourceType,
			Class<D> destinationType) {

		S sourceData = null;
		D destinationData = null;
		try {
			ResponseEntity<S> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<S>() {
					});
			sourceData = response.getBody();
			destinationData = objectMapperUtils.map(sourceData, destinationType);
			return Optional.of(destinationData);
		} catch (RestClientException e) {
			logger.error(e.getMessage());
			return Optional.empty();
		}

	}

}
