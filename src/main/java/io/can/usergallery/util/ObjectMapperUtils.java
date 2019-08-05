package io.can.usergallery.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("objectMapperUtils")
public class ObjectMapperUtils {

	@Autowired
	private ModelMapper modelMapper;

	public <D> D map(Object source, Class<D> destinationType) {
		return modelMapper.map(source, destinationType);
	}

	public <D, T> List<D> mapAll(Collection<T> sourceCollection, Class<D> destinationType) {
		return sourceCollection.stream().map(entity -> map(entity, destinationType)).collect(Collectors.toList());
	}
}
