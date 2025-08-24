package it.unisa.SMS;

import java.util.ArrayList;
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
        this.messages.sort(SMS.dateComparator);
        return this.messages;
    }

    public List<SMS> getListBySender() {
        this.messages.sort(SMS.senderComparator);
        return this.messages;
    }
}
