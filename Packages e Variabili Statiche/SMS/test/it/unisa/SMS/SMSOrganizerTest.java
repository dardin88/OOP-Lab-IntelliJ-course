package it.unisa.SMS;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class SMSOrganizerTest {

    @Test
    public void testListByDate() {
        SMSOrganizer smsOrganizer = new SMSOrganizer();
        SMS sms1 = new SMS("Dario", new GregorianCalendar(2022, Calendar.OCTOBER, 16, 15, 1), "Ciao");
        SMS sms2 = new SMS("Anna", new GregorianCalendar(2022, Calendar.OCTOBER, 16, 15, 2), "Ciao");
        smsOrganizer.addSMSToOrganizer(sms1);
        smsOrganizer.addSMSToOrganizer(sms2);
        List<SMS> messages = smsOrganizer.getListByDate();
        Assert.assertEquals("Dario", messages.get(0).getSender());
        Assert.assertEquals("Anna", messages.get(1).getSender());
    }

    @Test
    public void testListBySender() {
        SMSOrganizer smsOrganizer = new SMSOrganizer();
        SMS sms1 = new SMS("Dario", new GregorianCalendar(2022, Calendar.OCTOBER, 16, 15, 1), "Ciao");
        SMS sms2 = new SMS("Anna", new GregorianCalendar(2022, Calendar.OCTOBER, 16, 15, 2), "Ciao");
        smsOrganizer.addSMSToOrganizer(sms1);
        smsOrganizer.addSMSToOrganizer(sms2);
        List<SMS> messages = smsOrganizer.getListBySender();
        Assert.assertEquals("Anna", messages.get(0).getSender());
        Assert.assertEquals("Dario", messages.get(1).getSender());
    }

}
