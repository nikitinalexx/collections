package com.alex.nikitin.mvc;

import com.alex.nikitin.mvc.entities.Singer;
import com.alex.nikitin.mvc.entities.Singers;
import com.alex.nikitin.mvc.services.SingerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingerControllerTest {
    private final List<Singer> singers = new ArrayList<>();

    @Before
    public void initSingers() {
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singers.add(singer);
    }

    @Test
    public void testList() throws Exception {
        SingerService singerService = mock(SingerService.class);
        when(singerService.findAll()).thenReturn(singers);

        SingerController singerController = new SingerController();

        ReflectionTestUtils.setField(singerController, "singerService", singerService);

        Singers modelSingers = singerController.listData();

        assertEquals(1, modelSingers.getSingers().size());
    }

    @Test
    public void testCreate() {
        final Singer newSinger = new Singer();
        newSinger.setId(999L);
        newSinger.setFirstName("BB");
        newSinger.setLastName("King");

        SingerService singerService = mock(SingerService.class);

        when(singerService.save(newSinger)).thenAnswer(new Answer<Singer>() {
            @Override
            public Singer answer(InvocationOnMock invocationOnMock) throws Throwable {
                singers.add(newSinger);
                return newSinger;
            }
        });

        SingerController singerController = new SingerController();
        ReflectionTestUtils.setField(singerController, "singerService", singerService);

        Singer singer = singerController.create(newSinger);

        assertEquals(Long.valueOf(999), singer.getId());
        assertEquals("BB", singer.getFirstName());
        assertEquals("King", singer.getLastName());
        assertEquals(2, singers.size());
    }

}

