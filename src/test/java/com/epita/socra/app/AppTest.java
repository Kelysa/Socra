package com.epita.socra.app;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epita.socra.app.tools.IOAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    Roman roman = new Roman();
    @Test
    public void givenAMock_WhenRunningMain_ThenCheckOuputs() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("TEST");
        App app = new App(mock);
        app.run();

        verify(mock).write("Hello, what's your name ?");
        verify(mock).write(argThat(message -> message.contains("TEST")));

    }
    @Test
    public void testRoman1()
    {
        assertEquals(roman.convertTo(1), "I");
    }
    @Test
    public void testRoman42()
    {
        assertEquals(roman.convertTo(42), "XLII");
    }
    @Test
    public void testRoman10()
    {
        assertEquals(roman.convertTo(10), "X");
    }
    @Test
    public void testRoman83()
    {
        assertEquals(roman.convertTo(83), "LXXXIII");
    }
    @Test
    public void testRoman1903()
    {
        assertEquals(roman.convertTo(1903), "MCMIII");
    }
    @Test
    public void testArabic1()
    {
        assertEquals(roman.convertFrom("I"), 1);
    }
    @Test
    public void testArabic42()
    {
        assertEquals(roman.convertFrom("XLII"), 42);
    }
    @Test
    public void testArabic10()
    {
        assertEquals(roman.convertFrom("X"), 10);
    }
    @Test
    public void testArabic83()
    {
        assertEquals(roman.convertFrom("LXXXIII"), 83);
    }
    @Test
    public void testArabic1903()
    {
        assertEquals(roman.convertFrom("MCMIII"), 1903);
    }

    @Test
    public void testInvalidValue()
    {
        assertEquals(roman.value('A'), -1);
    }
    @Test
    public void testValue5()
    {
        assertEquals(roman.value('V'), 5);
    }
    @Test
    public void testValue500()
    {
        assertEquals(roman.value('D'), 500);
    }
    @Test
    public void testnotvalidinput()
    {
        assertEquals(Roman.valid_input("MCI"), true);
    }
    @Test
    public void testvalidinput()
    {
        assertEquals(Roman.valid_input("500"), false);
    }
}
