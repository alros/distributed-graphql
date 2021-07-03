package alros.demo.distributedgraphql.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

public class RemoteServerCallback<D extends Operation.Data, T> extends ApolloCall.Callback<D> {

	private static final Logger LOG = LoggerFactory.getLogger(RemoteServerCallback.class);

	private final CompletableFuture<T> value = new CompletableFuture<>();
	private final Function<D, T> mapper;

	public RemoteServerCallback(Function<D, T> mapper) {
		this.mapper = mapper;
	}

	@Override
	public void onResponse(@NotNull Response<D> response) {
		value.complete(mapper.apply(response.getData()));
	}

	@Override
	public void onFailure(@NotNull ApolloException e) {
		value.cancel(true);
		LOG.error("error in server callback", e);
	}

	public Future<T> getResult() {
		return value;
	}

}
