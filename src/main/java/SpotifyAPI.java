package main.java;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.CurrentUserRequest;
import com.wrapper.spotify.methods.RelatedArtistsRequest;
import com.wrapper.spotify.methods.TopTracksRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;
import com.wrapper.spotify.models.Image;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Track;
import com.wrapper.spotify.models.User;

public abstract class SpotifyAPI {
	public static String clientId = "8f526368adb74b40851687a5e02a6903";
	public static String clientSecret = "fd3bf08af0da4c2a974d37a16b2e2237";
	public static String redirectUri = "http://localhost:8080/ITRevolutionContest/";

	public static String getUserAccessToken(String code) {
		String accessToken = "";
		final Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectUri).build();
		// api =
		// Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectUri).build();

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

	public static List<Artist> getArtists(String searchRequest, String accessToken) {
		final Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectUri)
				.accessToken(accessToken).build();
		ArtistSearchRequest request = api.searchArtists(searchRequest).market("US").limit(10).build();
		List<Artist> artists = null;
		try {
			final Page<Artist> artistSearchResult = request.get();
			artists = artistSearchResult.getItems();

			System.out.println(
					"I've found " + artistSearchResult.getTotal() + " artists! Search request: " + searchRequest);

			if (artistSearchResult.getTotal() == 0)
				return null;

		} catch (Exception e) {
			System.out.println("Something went wrong!" + e.getMessage());
		}
		return artists;
	}

    public static Artist getArtistInfo(String artistsNameBase62, String accessToken) {
        final Api api = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectURI(redirectUri).accessToken(accessToken)
                .build();
        //final Artist request = api.getArtist(artistsNameBase62).build();
        final ArtistRequest request = api.getArtist(artistsNameBase62).build();

        try {
            final Artist artist = request.get();

            System.out.println("This artist's name is " + artist.getName());

            // Print URLs to the artist's images
            final List<Image> images = artist.getImages();
           /* for (Image image : images) {
                System.out.println(image.getUrl());
            }*/
            List<String> genres = artist.getGenres();
            for (String genre : genres) {
                System.out.println(genre);
            }

            return artist;

        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
        return null;
    }

    public static List<Track> getTopTracks(String accessToken, String artistId)
    {
        final Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectUri)
                .accessToken(accessToken).build();
        final TopTracksRequest request = api.getTopTracksForArtist(artistId, "US").build();
        List<Track> trackSearchResult = null;
        try {
            trackSearchResult = request.get();
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
        return trackSearchResult;
    }

    public static List<Artist> getRelatedArtists(String artistsNameBase62, String accessToken) {
        final Api api = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectURI(redirectUri).accessToken(accessToken)
                .build();
        final RelatedArtistsRequest request = api.getArtistRelatedArtists(artistsNameBase62).build();

        try {

            final List<Artist> artists = request.get();

            if (artists.isEmpty()) {
                System.out.println("Didn't find any similar artists!");
            } else {
                System.out.println("The related artists are:");
                for (Artist artist : artists) {
                    System.out.println(artist.getName());
                }
            }
            return artists;
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
        return null;
    }

    public static User getCurrentUser(String accessToken){ 
    	final Api api = Api.builder()
            .clientId(clientId)
            .clientSecret(clientSecret)
            .redirectURI(redirectUri).accessToken(accessToken)
            .build();
    	final CurrentUserRequest request = api.getMe().build();
    	  
    	try {
    	   final User user = request.get();
    	   return user;
    	
    	} catch (Exception e) {
    	   System.out.println("Something went wrong!" + e.getMessage());
    	}
    	return null;
    }
}
