package com.javarush.task.task20.task2002;



import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            /* User user = new User();
            user.setFirstName("MegaCoder");
            user.setLastName("Gavriloff");
            user.setBirthDate(new Date(545));
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            javaRush.users.add(user); */
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isUsersPresent = users.size() > 0 ? "yes" : "no";
            if (isUsersPresent.equals("yes")) {
                bufferedWriter.write(isUsersPresent + "\n");
            } else if (isUsersPresent.equals("no")) {
                bufferedWriter.write(isUsersPresent + "\n");
            }
            if (users.size() > 0) {
              for (User user : users) {
                  bufferedWriter.write(user.getFirstName() + "\n");
                  bufferedWriter.write(user.getLastName() + "\n");
                  bufferedWriter.write(String.valueOf(user.getBirthDate().getTime()) + "\n");
                  bufferedWriter.write(String.valueOf(user.isMale()) + "\n");
                  bufferedWriter.write(user.getCountry().getDisplayName() + "\n");
              }
            }
            bufferedWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersPresent = reader.readLine();
            if (isUsersPresent.equals("yes")) {
                ArrayList<String> arrayList = new ArrayList<>();
                while (reader.ready()) {

                    User user = new User();
                        String firstName = reader.readLine();
                        String lastName = reader.readLine();
                        String birthDate = reader.readLine();
                        String isMale = reader.readLine();
                        String country = reader.readLine();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        user.setBirthDate(new Date(Long.parseLong(birthDate)));
                        user.setMale(Boolean.parseBoolean(isMale));
                        if (country.equals("Russia")) {
                            user.setCountry(User.Country.RUSSIA);
                        } else if (country.equals("Ukraine")) {
                            user.setCountry(User.Country.UKRAINE);
                        } else if (country.equals("Other")) {
                            user.setCountry(User.Country.OTHER);
                        }
                    this.users.add(user);
                }
            } else if (isUsersPresent.equals("no")) {
                JavaRush javaRush = new JavaRush();
                javaRush.users = new ArrayList<>();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
