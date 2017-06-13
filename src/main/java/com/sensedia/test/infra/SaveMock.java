package com.sensedia.test.infra;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class SaveMock<T> implements Answer<T> { 
	@Override
	public T answer(InvocationOnMock invocation) throws Throwable {
		return (T) invocation.getArgumentAt(0, Object.class);
	}
}