package com.sensedia.test.infra;

import org.springframework.http.ResponseEntity;

import com.sensedia.api.infra.RestClient.Limit;
import com.sensedia.api.infra.RestClient.Offset;
import com.sensedia.api.infra.RestClient.PagedOperation;
import com.sensedia.api.infra.RestClient.ResponseHandler;

public class RestClientMock {
	public static <T> PagedOperation<T> pagedOperation(ResponseEntity<T> response) {
		return new PagedOperationMock<>(response);
	}

	static class PagedOperationMock<R> extends PagedOperation<R> {
		private ResponseEntity<R> response;

		public PagedOperationMock(ResponseEntity<R> response) {
			super("mock://test", Limit.of(1), Offset.of(1));
			this.response = response;
		}

		@Override
		public PagedOperation<R> onResponse(ResponseHandler<R> handler, Class<R> type) {
			handler.onResponse(this.response);
			return this;
		}
	}
}