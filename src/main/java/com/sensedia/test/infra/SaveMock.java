package com.sensedia.test.infra;

import java.lang.reflect.Field;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class SaveMock<T> implements Answer<T> { 
	private final String idColumnName;
	
	private final Object value;
	
	public SaveMock(String idColumnName, Object value) {
		this.idColumnName = idColumnName;
		this.value = value;
	}
	
	public SaveMock() {
		this.idColumnName = "id";
		this.value = 1L;
	}

	@Override
	public T answer(InvocationOnMock invocation) throws Throwable {
		Object result = invocation.getArgumentAt(0, Object.class);
		
		Field id = result.getClass().getDeclaredField(this.idColumnName);
		id.setAccessible(true);
		id.set(result, this.value);
				
		return (T) result;
	}
}