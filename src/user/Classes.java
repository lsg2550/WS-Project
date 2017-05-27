package user;

/**
 *
 * @author Luis
 */
public class Classes {

    //Class 
    private Boolean monday, tuesday, wednesday, thursday, friday, saturday, sunday;

    //Class Information
    private String classID, className;
    private String classLocation; //Can Be Null

    //Class Time
    private String timeFromHour, timeFromMinute, timeFromPeriod;
    private String timeToHour, timeToMinute, timeToPeriod;

    public Classes() {

    }

    public Classes(boolean monday, boolean tuesday, boolean wednesday, boolean thursday,
            boolean friday, boolean saturday, boolean sunday, String timeFromHour,
            String timeFromMinute, String timeFromPeriod, String timeToHour,
            String timeToMinute, String timeToPeriod, String classID, String className,
            String classLocation) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.timeFromHour = timeFromHour;
        this.timeFromMinute = timeFromMinute;
        this.timeFromPeriod = timeFromPeriod;
        this.timeToHour = timeToHour;
        this.timeToMinute = timeToMinute;
        this.timeToPeriod = timeToPeriod;
        this.classID = classID;
        this.className = className;
        
        if (classLocation == null || classLocation.equals("")) {
            this.classLocation = "N/A";
        } else {
            this.classLocation = classLocation;
        }
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

    public String getTimeFromHour() {
        return timeFromHour;
    }

    public void setTimeFromHour(String timeFromHour) {
        this.timeFromHour = timeFromHour;
    }

    public String getTimeFromMinute() {
        return timeFromMinute;
    }

    public void setTimeFromMinute(String timeFromMinute) {
        this.timeFromMinute = timeFromMinute;
    }

    public String getTimeFromPeriod() {
        return timeFromPeriod;
    }

    public void setTimeFromPeriod(String timeFromPeriod) {
        this.timeFromPeriod = timeFromPeriod;
    }

    public String getTimeToHour() {
        return timeToHour;
    }

    public void setTimeToHour(String timeToHour) {
        this.timeToHour = timeToHour;
    }

    public String getTimeToMinute() {
        return timeToMinute;
    }

    public void setTimeToMinute(String timeToMinute) {
        this.timeToMinute = timeToMinute;
    }

    public String getTimeToPeriod() {
        return timeToPeriod;
    }

    public void setTimeToPeriod(String timeToPeriod) {
        this.timeToPeriod = timeToPeriod;
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
        StringBuilder classInfo = new StringBuilder();
        classInfo.append(System.lineSeparator());
        classInfo.append("CLASS INFO START");
        classInfo.append(System.lineSeparator());
        classInfo.append("CLASS: ").append(classID).append(":").append(className).append(":").append(classLocation); //Split by : to return ID - Name - Location
        classInfo.append(System.lineSeparator());
        classInfo.append("DAYS: ").append(monday.toString()).append(":")
                .append(tuesday.toString()).append(":")
                .append(wednesday.toString()).append(":")
                .append(thursday.toString()).append(":")
                .append(friday.toString()).append(":")
                .append(saturday.toString()).append(":")
                .append(sunday.toString()); //Split by : to return monday-tuesday-wednesday-thursday-friday-saturday-sunday
        classInfo.append(System.lineSeparator());
        classInfo.append("FROM: ").append(timeFromHour).append(":").append(timeFromMinute).append(":").append(timeFromPeriod); //Split by : to return Hour-Minute-Period
        classInfo.append(System.lineSeparator());
        classInfo.append("TO: ").append(timeToHour).append(":").append(timeToMinute).append(":").append(timeToPeriod); //Split by : to return Hour-Minute-Period
        classInfo.append(System.lineSeparator());
        classInfo.append("CLASS INFO END");
        return classInfo.toString();
    }

}
