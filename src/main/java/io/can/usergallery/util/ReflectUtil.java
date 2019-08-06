package io.can.usergallery.util;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("reflectUtil")
public class ReflectUtil {

	public <T> boolean isClassFieldGivenType(String fieldName, Class<T> classType) {
		Field[] declaredFields = classType.getDeclaredFields();
		return Arrays.stream(declaredFields).anyMatch(field -> fieldName.equals(field.getName()));
	}
	
	public <T> String getClassNameForGivenType(Class<T> classType) {
		return classType.getSimpleName();
	}

}
