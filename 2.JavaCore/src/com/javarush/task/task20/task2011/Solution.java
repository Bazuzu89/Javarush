package com.javarush.task.task20.task2011;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* 
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        public void writeExternal(ObjectOutput ou) {
            try {
                ou.writeObject(address);
                ou.writeInt(year);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        public void readExternal(ObjectInput oi) {
            try {
                address = (String) oi.readObject();
                year = oi.readInt();
            } catch (IOException  ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) {

    }
}
