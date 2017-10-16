package de.ganddev.oboobs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import de.ganddev.oboobs.data.Boobs;
import de.ganddev.oboobs.data.BoobsRemoteDataSource;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.mock.BehaviorDelegate;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by bjornahlfeld on 10.10.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityViewModelTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBoobs() throws Exception {

    }

    @Test
    public void onResponse() throws Exception {

    }

    @Test
    public void onFailure() throws Exception {

    }

    @Test
    public void loadNext() throws Exception {

    }

    @Test
    public void test_swipedToRight_should_Rate() throws Exception {
        int position = 1;

        MainActivityViewModel sut = new MainActivityViewModel(mockedBoobsRemoteDataSource);


        sut.swipedToRight(position);

        verify(mockedBoobsRemoteDataSource.rateNoisePositiv(anyInt()),times(1));
    }

    @Test
    public void swipedToLeft() throws Exception {

    }

    private final class MockedService implements BoobsRemoteDataSource {

        private final BehaviorDelegate<BoobsRemoteDataSource> delegate;

        public MockedService(BehaviorDelegate<BoobsRemoteDataSource> delegate) {
            this.delegate = delegate;

            // Seed some mock data.
            addBoobs("square", "retrofit", "John Doe", 12);
            addBoobs("square", "retrofit", "Bob Smith", 2);
            addBoobs("square", "retrofit", "Big Bird", 40);
        }

        private void addBoobs(String square, String retrofit, String s, int i) {

        }

        @Override
        public Call<Boobs> getBoobById(@Path("id") int id) {
            return null;
        }

        @Override
        public Call<List<Boobs>> getRandomBoobs(@Path("number_od_elements") int count) {
            List<Boobs> response = Collections.emptyList();

            return delegate.returningResponse(response).getRandomBoobs(3);
        }

        @Override
        public Call<List<Boobs>> getBoobsByModel(@Path("name") String name) {
            return null;
        }

        @Override
        public Call<List<Boobs>> getBoobsByAuthor(@Path("name") String name) {
            return null;
        }

        @Override
        public Call<Boobs> rateNoiseNegativ(@Path("id") int id) {
            return null;
        }

        @Override
        public Call<Boobs> rateNoisePositiv(@Path("id") int id) {
            return null;
        }
    }
}