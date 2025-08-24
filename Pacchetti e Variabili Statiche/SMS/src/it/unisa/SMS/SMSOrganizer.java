package it.unisa.SMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SMSOrganizer {
    final private List<SMS> messages;

    public SMSOrganizer() {
        messages = new ArrayList<>();
    }

    public void addSMSToOrganizer(SMS sms) {
        this.messages.add(sms);
    }

    public List<SMS> getListByDate() {
        this.messages.sort(new Comparator<>() {
            @Override
            public int compare(SMS sms1, SMS sms2) {
                return sms1.getDate().compareTo(sms2.getDate());
            }
        });
        return this.messages;
    }

    public List<SMS> getListBySender() {
        this.messages.sort(new Comparator<>() {
            @Override
            public int compare(SMS sms1, SMS sms2) {
                return sms1.getSender().compareTo(sms2.getSender());
            }
        });
        return this.messages;
    }
}
