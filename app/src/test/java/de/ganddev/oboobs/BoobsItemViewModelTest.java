package de.ganddev.oboobs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import de.ganddev.oboobs.data.Boobs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by bjornahlfeld on 10.10.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class BoobsItemViewModelTest {

    @Mock
    Boobs mockedBoobs;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetImageUrlAddsPrefix() {
        final String expectedPrefix = "http://media.oboobs.ru/";
        final String imagePath = "noise_preview/21912.jpg";
        when(mockedBoobs.getPreview()).thenReturn(imagePath);

        BoobsItemViewModel sut = new BoobsItemViewModel(mockedBoobs);

        assertEquals(expectedPrefix+imagePath,sut.getImageUrl());
    }

    @Test
    public void testSetBoobsChangesBoob(){
        Boobs mockedBoobs2 = mock(Boobs.class);

        BoobsItemViewModel sut = new BoobsItemViewModel(mockedBoobs);
        sut.setBoobs(mockedBoobs2);

        assertEquals(mockedBoobs2,sut.boobs.get());
    }
}