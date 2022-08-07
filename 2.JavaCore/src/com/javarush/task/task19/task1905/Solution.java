package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            String countryName = this.customer.getCountryName();
            String countryCode = "";
            for (String key : countries.keySet()) {
                if (countries.get(key).equals(countryName)) {
                    countryCode = key;
                }
            }
            return countryCode;
        }

        public String getCompany() {
            String company = this.customer.getCompanyName();
            return company;
        }

        public String getContactFirstName() {
            String[] nameArray = this.contact.getName().split(", ");
            String firstName = nameArray[1];
            return firstName;
        }

        public String getContactLastName() {
            String[] nameArray = this.contact.getName().split(", ");
            String lastName = nameArray[0];
            return lastName;
        }

        public String getDialString() {
            String dial = "callto://+";
            char[] phoneNumberArray = this.contact.getPhoneNumber().toCharArray();
            for (int i = 0; i < phoneNumberArray.length; i++) {
                if (phoneNumberArray[i] >= 48 && phoneNumberArray[i] <= 57) {
                    dial = dial + phoneNumberArray[i];
                }
            }
            return dial;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}