package io.can.usergallery.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("requestStatisticsService")
public class RequestStatisticsService {

	Logger logger = LoggerFactory.getLogger(RequestStatisticsService.class);

	private static Map<String, Map<AtomicInteger, AtomicInteger>> requestStatistics = new ConcurrentHashMap<>();

	public Map<String, Map<AtomicInteger, AtomicInteger>> getRequestStatistics() {
		return requestStatistics;
	}

	@Scheduled(fixedDelay = 10000)
	public void printRequestStatisticsOnConsole() {
		if (requestStatistics.keySet().isEmpty()) {
			return;
		}

		for (String key : requestStatistics.keySet()) {
			Map<AtomicInteger, AtomicInteger> map = requestStatistics.get(key);
			AtomicInteger countRequestPerTenSec = map.keySet().stream().findFirst().get();
			AtomicInteger countTotal = map.get(countRequestPerTenSec);
			logger.info("[Service: {}] [Request Count Per 10 Second: {}] [Request Total Count: {}]", key,
					countRequestPerTenSec.get(), countTotal.get());
			map.remove(countRequestPerTenSec);
			countRequestPerTenSec.set(0);
			map.put(countRequestPerTenSec, countTotal);
		}

	}

}
