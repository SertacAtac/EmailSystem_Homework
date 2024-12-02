/*************************************/
/*                                   */
/*         This file defines         */
/*          the Email class          */
/*      for the mail application.    */
/*            30.10.2024             */
/*                                   */
/*************************************/
public class Email {
    private String subject;
    private int id;
    private String message;
    private long time;
    public String whereAmI;
    public boolean isRead;
    

    /*  Class Constructor */
    public Email(String subject, int id, String message, long time) {
        this.subject = subject;
        this.id = id;
        this.message = message;
        this.time = time;
        this.isRead = false;
        this.whereAmI = "undefined";
    }

    /***************/
    /*             */
    /*   Methods   */
    /*             */
    /***************/

    /* Subject getter */ 
    public String getSubject() {
        return subject;
    }

    /* ID getter */
    public int getId() {
        return id;
    }

    /* Message getter */
    public String getMessage() {
        return message;
    }

    /* Time getter */
    public long getTime() {
        return time;
    }

    /* Read status getter */
    public boolean isRead() {
        return isRead;
    }

    /* Read status changer */
    public void markAsRead() {
        this.isRead = true;
    }

    /* Location changer */
    public void setLocation(String loc) {
        this.whereAmI = loc;
    }

    /* Detail printer for mails*/
    public String showDetails() {
        return "Email ID: " + id + "\nSubject: " + subject + "\nMessage: " + message + "\nTime received: " + time + "\nStatus: " + (isRead ? "Sent Read" : "Sent not read");
    }

    /* Location getter */
    public String findLocation() {
        return whereAmI;
    }
}