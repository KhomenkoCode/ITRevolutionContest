package main.java;

import java.util.concurrent.ExecutionException;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;

public abstract class SpotifyAPI {
	public static String clientId = "8f526368adb74b40851687a5e02a6903";
	public static String clientSecret = "fd3bf08af0da4c2a974d37a16b2e2237";
	public static String redirectUri = "http://localhost:8080/ITRevolutionContest/";
	static Api api = null;
	public static String getUserAccessToken(String code) {
		String accessToken = "";

		api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectUri).build();

		/*
		 * Make a token request. Asynchronous requests are made with the
		 * .getAsync method and synchronous requests are made with the .get
		 * method. This holds for all type of requests.
		 */
		final SettableFuture<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = api
				.authorizationCodeGrant(code).build().getAsync();

		/* Add callbacks to handle success and failure */
		Futures.addCallback(authorizationCodeCredentialsFuture, new FutureCallback<AuthorizationCodeCredentials>() {
			@Override
			public void onSuccess(AuthorizationCodeCredentials authorizationCodeCredentials) {
				/* The tokens were retrieved successfully! */
				System.out.println(
						"Successfully retrieved an access token! " + authorizationCodeCredentials.getAccessToken());
				System.out.println(
						"The access token expires in " + authorizationCodeCredentials.getExpiresIn() + " seconds");
				System.out.println("Luckily, I can refresh it using this refresh token! "
						+ authorizationCodeCredentials.getRefreshToken());
			}

			@Override
			public void onFailure(Throwable throwable) {
				/*
				 * Let's say that the client id is invalid, or the code has been
				 * used more than once, the request will fail. Why it fails is
				 * written in the throwable's message.
				 */
				System.out.println(throwable.getMessage());
			}

		});

		try {
			accessToken = authorizationCodeCredentialsFuture.get().getAccessToken();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return accessToken;
	}
	
	

}
