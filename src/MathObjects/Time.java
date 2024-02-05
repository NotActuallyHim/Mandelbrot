package MathObjects;
public class Time {
    private int totalSeconds;
    private final int SECONDS_IN_HOUR = 3600;
    private final int SECONDS_IN_MINUTE = 60;
    private final int SECONDS_IN_DAY = 60*60*24;

    // constructors
    public Time() {
        this.totalSeconds = 0;
    }

    public Time(int hours, int minutes, int seconds) {
        this.totalSeconds = hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds;
    }

    public Time(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    // setters
    public void setHours(int hours) {
        if (hours >= 0 && hours <= 23)
            this.totalSeconds = hours * SECONDS_IN_HOUR + getMinutes() * SECONDS_IN_MINUTE + getSeconds();
        else
            throw new IllegalArgumentException("Invalid Hour: " + hours);
    }

    public void setMinutes(int minutes) {
        if (minutes <= 60 && minutes >= 0)
            this.totalSeconds = getHours() * SECONDS_IN_HOUR + getSeconds() + minutes * SECONDS_IN_MINUTE;
        else
            throw new IllegalArgumentException("Invalid Minutes: " + minutes);
    }

    public void setSeconds(int seconds) {
        if( seconds <= 60 && seconds >= 0)
        this.totalSeconds = getHours() * SECONDS_IN_HOUR + getMinutes() * SECONDS_IN_MINUTE + seconds;
        else throw new IllegalArgumentException("Invalid Seconds: "+ seconds);
    }

    // getters
    public int getHours() {
        return this.totalSeconds / SECONDS_IN_HOUR;
    }

    public int getMinutes() {
        return (this.totalSeconds / SECONDS_IN_MINUTE) % SECONDS_IN_MINUTE;
    }

    public int getSeconds() {
        return totalSeconds % SECONDS_IN_MINUTE;
    }

    
    public boolean equals(Time that) {
        return this.totalSeconds == that.totalSeconds;
    }

    // compare
    public int compareTo(Time that) {
        return Integer.compare(this.totalSeconds, that.totalSeconds);
    }

    // add
    public Time add(Time that) {
        return new Time((this.totalSeconds+that.totalSeconds)%SECONDS_IN_DAY);
    }

    // subtract
    public Time subtract(Time that) {
        return new Time((this.totalSeconds - that.totalSeconds)%SECONDS_IN_DAY);
    }

    // toString
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
    }
}
