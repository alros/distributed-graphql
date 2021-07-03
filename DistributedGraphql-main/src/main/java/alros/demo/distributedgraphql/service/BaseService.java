package alros.demo.distributedgraphql.service;

import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.Query;

public abstract class BaseService {

	private ApolloClient apolloClient;
	private String serverUrl;

	public BaseService(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	@PostConstruct
	public void init() {
		apolloClient = ApolloClient.builder().serverUrl(serverUrl).build();
	}

	protected <R, D extends Operation.Data, V extends Operation.Variables, Q extends Query<D, D, V>> R performQuery(
			RemoteServerCallback<D, R> callback, Q query) {
		apolloClient.query(query).enqueue(callback);
		return getResult(callback);
	}

	private <R, D extends Operation.Data> R getResult(RemoteServerCallback<D, R> callback) {
		try {
			return callback.getResult().get();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
