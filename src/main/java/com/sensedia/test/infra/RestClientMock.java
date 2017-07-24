package com.sensedia.test.infra;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.sensedia.api.infra.RestClient.GetOperation;
import com.sensedia.api.infra.RestClient.Limit;
import com.sensedia.api.infra.RestClient.Offset;
import com.sensedia.api.infra.RestClient.PagedOperation;
import com.sensedia.api.infra.RestClient.ResponseEntityHandler;

public class RestClientMock {
	public static <T> GetOperation<T> getOperation(ResponseEntity<T> response) {
		return new GetOperationMock<>(response);
	}
	
	public static <T> PagedOperation<T> pagedOperation(ResponseEntity<T> response) {
		return new PagedOperationMock<>(response);
	}
	
	static class GetOperationMock<R> extends GetOperation<R> {
		private ResponseEntity<R> response;

		public GetOperationMock(ResponseEntity<R> response) {
			super("mock://test", new HttpHeaders(), new HashMap<>());
			this.response = response;
		}

		@Override
		public void onResponse(ResponseEntityHandler<R> handler, Class<R> type) {
			handler.onResponse(this.response);
		}
	}

	static class PagedOperationMock<R> extends PagedOperation<R> {
		private ResponseEntity<R> response;

		public PagedOperationMock(ResponseEntity<R> response) {
			super("mock://test", new HttpHeaders(), Limit.of(1), Offset.of(1));
			this.response = response;
		}

		@Override
		public void onResponse(ResponseEntityHandler<R> handler, Class<R> type) {
			handler.onResponse(this.response);
		}
	}
}