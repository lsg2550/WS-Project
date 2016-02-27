package WeeklyScheduler;

/**
 * @author MQ0162246
 */
public class TimeInterval {

    private int time_from;
    private int time_to; // assume 24 hours

    private String[] timeTicksStrings;
    private int timeIncrement;

    public TimeInterval() {
        time_from = 8;  // 8 am
        time_to = 22; // 10 pm
    }

    public TimeInterval(int timeIncrement) {
        this.timeIncrement = timeIncrement;
        time_from = 8;
        time_to = 22;
    }

    public TimeInterval(int time_from, int time_to, int timeIncrement) {
        this.time_from = time_from;
        this.time_to = time_to;
        this.timeIncrement = timeIncrement;
    }

    public String[] generateTicks() {
        int offset_hour, offset_subHour;
        int no_ofTicks = time_to - time_from; // 8 am to 10 pm would be 8 to 22
        int sub_ticks;
        String am_pm;

        if (timeIncrement != 0) {
            sub_ticks = (60 / timeIncrement);
        } else {
            sub_ticks = 1;
        }

        int totalTicks = no_ofTicks * sub_ticks + 1;
        timeTicksStrings = new String[totalTicks];

        for (int i = 0; i < totalTicks; i++) {
            offset_hour = i / (sub_ticks) + time_from;
            am_pm = (offset_hour < 12 ? "AM" : "PM");

            offset_hour = offset_hour % 12;
            if (offset_hour == 0) {
                offset_hour = 12;
            }

            offset_subHour = (i % sub_ticks) * timeIncrement;
            String formatted_offset_hour = String.format("%02d", offset_hour);
            String formatted_offset_subHour = String.format("%02d", offset_subHour);

            timeTicksStrings[i] = formatted_offset_hour + ":" + formatted_offset_subHour + " " +am_pm;
        }
        return timeTicksStrings;
    }

    public void printTicks() {
        for (int i = 0; i < timeTicksStrings.length; i++) {
            System.out.println(timeTicksStrings[i]);
        }
    }

    public int getTime_from() {
        return time_from;
    }

    public void setTime_from(int time_from) {
        this.time_from = time_from;
    }

    public int getTime_to() {
        return time_to;
    }

    public void setTime_to(int time_to) {
        this.time_to = time_to;
    }

    public int getTimeIncrement() {
        return timeIncrement;
    }

    public void setTimeIncrement(int timeIncrement) {
        this.timeIncrement = timeIncrement;
    }

    public String[] getTimeTicksStrings() {
        return timeTicksStrings;
    }

    public void setTimeTicksStrings(String[] timeTicksStrings) {
        this.timeTicksStrings = timeTicksStrings;
    }
}
