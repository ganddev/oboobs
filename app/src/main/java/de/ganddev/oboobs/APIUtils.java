package de.ganddev.oboobs;

import de.ganddev.oboobs.data.BoobsRemoteDataSource;
import de.ganddev.oboobs.data.RetrofitClient;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public class APIUtils {
    private static final String ENDPOINT = "http://api.oboobs.ru";

    public static BoobsRemoteDataSource getBoobsService() {
        return RetrofitClient.getClient(ENDPOINT).create(BoobsRemoteDataSource.class);
    }
}