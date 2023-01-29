//appointment.java
//Evan Spaulding
//01/26/2023
//Program that displays an appointment.

package edu.fscj.cop2805c.appointment;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class appointment {
    private static Contact contact;
    static String title = "Dentist Appointment";
    static String description = "Six month checkup and cleaning";

    static ZoneId zone = ZoneId.of("US/Eastern");

    static ZonedDateTime appTime = ZonedDateTime.of(2023, 9, 25,
            14, 00, 00, 00, zone);

    static ZonedDateTime remTime = appTime.minusDays(3).minusHours(2);

    public static void main(String[] args) {
        Contact contact = new Contact("Ketchum", "Ash", "aKetchum1008@gmail.com", "904-555-XXXX",
                Reminder.TEXT, zone.of("US/Eastern"));
        System.out.println("Appt:");
        System.out.println("\tTitle: " + title);
        System.out.println("\tDesc: " + description);
        System.out.println("\tContact: " + contact.getEmail() + ", (" + contact.getName() +
                "), " + contact.getPhoneNum() + ", " + contact.getReminder() + ", " +
                contact.getZone());
        System.out.println("\tAppt Date/Time: " + appTime);
        System.out.println("\tReminder: " + remTime);
    }
}

class Contact {
    private StringBuilder name;
    private String email;
    private String phoneNum;
    private Reminder reminder;
    private ZoneId zone;

    public Contact(String lName, String fName, String email, String phoneNum,
                   Reminder reminder, ZoneId zone) {
        this.name = new StringBuilder();
        this.name.append(lName).append(", ").append(fName);
        this.email = email;
        this.phoneNum = phoneNum;
        this.reminder = reminder;
        this.zone = zone;
    }

    public StringBuilder getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public ZoneId getZone() {
        return zone;
    }

    public Reminder getReminder() {
        return reminder;
    }
}

enum Reminder { NONE, TEXT, EMAIL }
