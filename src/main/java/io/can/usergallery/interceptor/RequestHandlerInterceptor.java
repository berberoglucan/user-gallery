package io.can.usergallery.interceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.can.usergallery.service.RequestStatisticsService;

@Component
public class RequestHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private RequestStatisticsService requestStatisticsService;
	
	// QUESTION 6
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		Map<String, Map<AtomicInteger, AtomicInteger>> requestStatistics = requestStatisticsService.getRequestStatistics();
		
		String requestUri = request.getRequestURI();
		
		if(requestUri.contains("?")) {
			requestUri = requestUri.substring(0, requestUri.indexOf('?'));
		} 
			
		String lastEndpointValue = requestUri.substring(requestUri.lastIndexOf('/') + 1);
		
		if(StringUtils.isNumeric(lastEndpointValue)) {
			requestUri = requestUri.substring(0, requestUri.lastIndexOf('/'));
		}
		
		String requestStatisticsKey = request.getMethod() + " " + requestUri;
		
		AtomicInteger countPerTenSec;
		AtomicInteger countTotal;
		
		if(!requestStatistics.containsKey(requestStatisticsKey)) {
			countPerTenSec = new AtomicInteger(1);
			countTotal = new AtomicInteger(1);
			Map<AtomicInteger, AtomicInteger> map = new ConcurrentHashMap<>();
			map.put(countPerTenSec, countTotal);
			requestStatistics.put(requestStatisticsKey, map);
		} else {
			Map<AtomicInteger, AtomicInteger> map = requestStatistics.get(requestStatisticsKey);
			countPerTenSec = map.keySet().stream().findFirst().get();
			countTotal = map.get(countPerTenSec);
			map.remove(countPerTenSec);
			countPerTenSec.incrementAndGet();
			countTotal.incrementAndGet();
			map.put(countPerTenSec, countTotal);
		}
		
		
	}

}
