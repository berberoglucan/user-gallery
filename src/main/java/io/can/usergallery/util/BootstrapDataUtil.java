package io.can.usergallery.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("bootstrapDataUtil")
public class BootstrapDataUtil {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapperUtils objectMapperUtils;

	public <S, D> List<D> fetchDataWithHttpGetMethodGivenUrlForBootstrapDb(String url, S sourceType,
			Class<D> destinationType) {

		ResponseEntity<List<S>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<S>>(){});
		List<S> sourceTypeList = response.getBody();
		return objectMapperUtils.mapAll(sourceTypeList, destinationType);

	}

}
