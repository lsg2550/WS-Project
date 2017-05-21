package user;

/**
 *
 * @author Luis
 */
public class Classes {

    //Class 
    private Boolean monday, tuesday, wednesday, thursday, friday, saturday, sunday;

    //Class Time
    private int timeFromHour, timeFromMinute;
    private int timeToHour, timeToMinute;

    //Class Information
    private String classID, className;
    private String classLocation;
    
    public Classes(boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, int timeFromHour, int timeFromMinute, int timeToHour, int timeToMinute, String classID, String className, String classLocation, String semester) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.timeFromHour = timeFromHour;
        this.timeFromMinute = timeFromMinute;
        this.timeToHour = timeToHour;
        this.timeToMinute = timeToMinute;
        this.classID = classID;
        this.className = className;
        this.classLocation = classLocation;
    }
    
    public boolean isMonday() {
        return monday;
    }
    
    public void setMonday(boolean monday) {
        this.monday = monday;
    }
    
    public boolean isTuesday() {
        return tuesday;
    }
    
    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }
    
    public boolean isWednesday() {
        return wednesday;
    }
    
    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }
    
    public boolean isThursday() {
        return thursday;
    }
    
    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }
    
    public boolean isFriday() {
        return friday;
    }
    
    public void setFriday(boolean friday) {
        this.friday = friday;
    }
    
    public boolean isSaturday() {
        return saturday;
    }
    
    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }
    
    public boolean isSunday() {
        return sunday;
    }
    
    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }
    
    public int getTimeFromHour() {
        return timeFromHour;
    }
    
    public void setTimeFromHour(int timeFromHour) {
        this.timeFromHour = timeFromHour;
    }
    
    public int getTimeFromMinute() {
        return timeFromMinute;
    }
    
    public void setTimeFromMinute(int timeFromMinute) {
        this.timeFromMinute = timeFromMinute;
    }
    
    public int getTimeToHour() {
        return timeToHour;
    }
    
    public void setTimeToHour(int timeToHour) {
        this.timeToHour = timeToHour;
    }
    
    public int getTimeToMinute() {
        return timeToMinute;
    }
    
    public void setTimeToMinute(int timeToMinute) {
        this.timeToMinute = timeToMinute;
    }
    
    public String getClassID() {
        return classID;
    }
    
    public void setClassID(String classID) {
        this.classID = classID;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getClassLocation() {
        return classLocation;
    }
    
    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }
    
    @Override
    public String toString() {
        String classInfo = classID
                + "\n" + className
                + "\n" + classLocation
                + "\n" + monday.toString()
                + "\n" + tuesday.toString()
                + "\n" + wednesday.toString()
                + "\n" + thursday.toString()
                + "\n" + friday.toString()
                + "\n" + saturday.toString()
                + "\n" + sunday.toString()
                + "\n" + Integer.toString(timeFromHour)
                + "\n" + Integer.toString(timeFromMinute)
                + "\n" + Integer.toString(timeToHour)
                + "\n" + Integer.toString(timeToMinute);
        return classInfo;
    }
    
}
