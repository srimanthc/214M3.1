package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    // test that the default constructor starts at zero and no overflows
    @Test
    void defaultConstructorInitializesZero() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    // test custom constructor with a valid starting value
    @Test
    void customConstructorValidValue() {
        GroceryCounter counter = new GroceryCounter(1234);
        assertEquals("$12.34", counter.total());
        assertEquals(0, counter.overflows());
    }

    // test custom constructor with invalid start resets to zero
    @Test
    void customConstructorInvalidValueResetsToZero() {
        GroceryCounter counter = new GroceryCounter(10000);
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    // test tens method adds $10.00
    @Test
    void tensIncrementsProperly() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();
        assertEquals("$10.00", counter.total());
    }

    // test ones method adds $1.00
    @Test
    void onesIncrementsProperly() {
        GroceryCounter counter = new GroceryCounter();
        counter.ones();
        assertEquals("$1.00", counter.total());
    }

    // test tenths method adds $0.10
    @Test
    void tenthsIncrementsProperly() {
        GroceryCounter counter = new GroceryCounter();
        counter.tenths();
        assertEquals("$0.10", counter.total());
    }

    // test hundreths method adds $0.01
    @Test
    void hundrethsIncrementsProperly() {
        GroceryCounter counter = new GroceryCounter();
        counter.hundreths();
        assertEquals("$0.01", counter.total());
    }

    // test combination of all increments gives $11.11
    @Test
    void combinedIncrementsProduceCorrectTotal() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();      // +1000
        counter.ones();      // +100
        counter.tenths();    // +10
        counter.hundreths(); // +1
        assertEquals("$11.11", counter.total());
    }

    // test overflow when starting at max and adding one hundredth
    @Test
    void overflowOnExceedingMax() {
        GroceryCounter counter = new GroceryCounter(9999);
        counter.hundreths();
        assertEquals("$0.00", counter.total());
        assertEquals(1, counter.overflows());
    }

    // test clear resets both count and overflows
    @Test
    void clearResetsCounterAndOverflows() {
        GroceryCounter counter = new GroceryCounter(5555);
        counter.clear();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    // test decrement hundreths underflows back to $99.99
    @Test
    void decrementHundrethsUnderflowsCorrectly() {
        GroceryCounter counter = new GroceryCounter();
        counter.decrementHundreths();
        assertEquals("$99.99", counter.total());
    }

    // test decrement tenths underflows back to $99.90
    @Test
    void decrementTenthsUnderflowsCorrectly() {
        GroceryCounter counter = new GroceryCounter();
        counter.decrementTenths();
        assertEquals("$99.90", counter.total());
    }

    // test decrement ones underflows back to $99.00
    @Test
    void decrementOnesUnderflowsCorrectly() {
        GroceryCounter counter = new GroceryCounter();
        counter.decrementOnes();
        assertEquals("$99.00", counter.total());
    }

    // test decrement tens underflows back to $90.00
    @Test
    void decrementTensUnderflowsCorrectly() {
        GroceryCounter counter = new GroceryCounter();
        counter.decrementTens();
        assertEquals("$90.00", counter.total());
    }
}
