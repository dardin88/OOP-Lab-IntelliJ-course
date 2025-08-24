package it.unisa.SMS;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class SMS {
    private final String sender;
    private final GregorianCalendar date;
    private final int id;
    private static int totalNumberSMS;
    private final String text;

    public SMS(String sender, GregorianCalendar date, String text) {
        this.sender = sender;
        this.date = date;
        this.text = text;
        this.id = totalNumberSMS;
        totalNumberSMS++;
    }

    public String getSender() {
        return sender;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public static int getTotalNumberSMS() {
        return totalNumberSMS;
    }

    public String getText() {
        return text;
    }

    public static final Comparator<SMS> dateComparator = new Comparator<>() {
        @Override
        public int compare(SMS sms1, SMS sms2) {
            return sms1.getDate().compareTo(sms2.getDate());
        }
    };

    public static final Comparator<SMS> senderComparator = new Comparator<>() {
        @Override
        public int compare(SMS sms1, SMS sms2) {
            return sms1.getSender().compareTo(sms2.getSender());
        }
    };

}