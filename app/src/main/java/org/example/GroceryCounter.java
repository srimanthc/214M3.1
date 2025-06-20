package org.example;

public class GroceryCounter {
    private int counter;
    private int overflowCount;
    private final int MAX = 9999;

    // Constructor with default starting value (0000)
    public GroceryCounter() {
        this.counter = 0;
        this.overflowCount = 0;
    }

    // Constructor with custom starting value
    public GroceryCounter(int startingValue) {
        if (startingValue >= 0 && startingValue <= MAX) {
            this.counter = startingValue;
        } else {
            this.counter = 0;
        }
        this.overflowCount = 0;
    }

    public void tens() {
        incrementBy(1000);
    }

    public void ones() {
        incrementBy(100);
    }

    public void tenths() {
        incrementBy(10);
    }

    public void hundreths() {
        incrementBy(1);
    }

    public void decrementTens() {
        decrementBy(1000);
    }

    public void decrementOnes() {
        decrementBy(100);
    }

    public void decrementTenths() {
        decrementBy(10);
    }

    public void decrementHundreths() {
        decrementBy(1);
    }

    private void incrementBy(int amount) {
        counter += amount;
        if (counter > MAX) {
            counter = counter % (MAX + 1);
            overflowCount++;
        }
    }

    private void decrementBy(int amount) {
        counter -= amount;
        if (counter < 0) {
            counter = (MAX + 1 + counter) % (MAX + 1); // wrap underflow
        }
    }

    public String total() {
        int dollars = counter / 100;
        int cents = counter % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    public int overflows() {
        return overflowCount;
    }

    public void clear() {
        counter = 0;
        overflowCount = 0;
    }
}
