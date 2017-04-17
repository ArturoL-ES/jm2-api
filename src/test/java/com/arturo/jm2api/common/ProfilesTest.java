package com.arturo.jm2api.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVELOPMENT)
public class ProfilesTest {

    @Test(expected = InvocationTargetException.class)
    public void constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Profiles> constructor = Profiles.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(Boolean.TRUE);
        Profiles profiles = constructor.newInstance();
    }
}