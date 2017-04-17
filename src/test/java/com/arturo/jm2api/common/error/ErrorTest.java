package com.arturo.jm2api.common.error;

import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVELOPMENT)
public class ErrorTest {

    private Error error;
    private Integer code = HttpStatus.BAD_REQUEST.value();
    private String message = "MESSAGE";
    private Long timestamp = System.currentTimeMillis();

    @Before
    public void setUp() throws Exception {
        error = new Error();
        error.setCode(code);
        error.setMessage(message);
        error.setTimestamp(timestamp);
    }

    @Test
    public void errorGeneric() throws Exception {
        Error expected = new Error();
        expected.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        expected.setMessage("ErrorMessage.GENERIC");
        expected.setTimestamp(System.currentTimeMillis());

        assertEquals(expected, Error.errorGeneric());
    }

    @Test
    public void getCode() throws Exception {
        assertEquals(code, error.getCode());
    }

    @Test
    public void setCode() throws Exception {
        Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        error.setCode(code);

        assertEquals(code, error.getCode());
    }

    @Test
    public void getErrorMessage() throws Exception {
        assertEquals(message, error.getMessage());
    }

    @Test
    public void setMessage() throws Exception {
        String message = "NEW_MESSAGE";
        error.setMessage(message);

        assertEquals(message, error.getMessage());
    }

    @Test
    public void getTimestamp() throws Exception {
        assertEquals(timestamp, error.getTimestamp());
    }

    @Test
    public void setTimestamp() throws Exception {
        error.setTimestamp(System.currentTimeMillis());

        assertNotNull(error.getTimestamp());
    }

    @Test
    public void testEquals() throws Exception {
        Error error1 = new Error();
        error1.setCode(code);
        error1.setMessage(message);
        Error error2 = new Error();
        error2.setCode(code);
        error2.setMessage(message);

        assertEquals(error1, error1);
        assertNotEquals(error1, "error1");
        assertNotEquals(error1, null);

        assertEquals(error1, error2);
    }

    @Test
    public void testHashCode() throws Exception {
        Error error1 = new Error();
        error1.setCode(code);
        error1.setMessage(message);
        Error error2 = new Error();
        error2.setCode(code);
        error2.setMessage(message);

        int hashcode1 = error1.hashCode();
        int hashcode2 = error2.hashCode();

        assertEquals(hashcode1, hashcode2);
    }

}