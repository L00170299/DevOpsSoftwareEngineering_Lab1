package com.L00170299.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldGetRandomValidHand()
    {
        List<String> givenList = Arrays.asList("R", "P", "S");
        assertTrue( givenList.contains(App.getRandomHand()) );
    }

    @Test
    public void shouldGetCorrentWinner_Draw()
    {
        assertEquals( "Draw" ,App.testWinnerHand("P", "P"));
    }

    @Test
    public void shouldGetCorrentWinner_User()
    {
        assertEquals( "User" ,App.testWinnerHand("P", "R"));
    }

    @Test
    public void shouldGetCorrentWinner_Roshambo()
    {
        assertEquals( "Roshambo" ,App.testWinnerHand("R", "P"));
    }

    @Test
    public void shouldBeTrue()
    {
        assertTrue( true );
    }
}
