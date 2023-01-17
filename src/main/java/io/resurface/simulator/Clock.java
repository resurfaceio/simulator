package io.resurface.simulator;

/**
 * Asynchronous virtual clock that can advance faster than the system clock.
 */
public class Clock implements Runnable {

    /**
     * Default constructor.
     */
    public Clock(long skew_days) {
        this.now = System.currentTimeMillis() - (skew_days * 24 * 60 * 60 * 1000);
        this.virtual_tick = (skew_days == 0) ? TICK : TICK * skew_days;
    }

    /**
     * Returns current time in millis. This could be stale a stale read, but that's ok.
     */
    public long now() {
        return now;
    }

    /**
     * Advance clock based on skew.
     */
    public void run() {
        try {
            while (true) {
                Thread.sleep(TICK);
                now += virtual_tick;
            }
        } catch (RuntimeException | InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static final long TICK = 100;
    private long now;
    private final long virtual_tick;

}
