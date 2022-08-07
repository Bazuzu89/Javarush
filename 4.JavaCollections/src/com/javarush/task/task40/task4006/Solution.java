package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            String host = url.getHost();
            String param = url.getPath();

            Socket socket = new Socket(host, 80);

            PrintStream ps = new PrintStream(socket.getOutputStream());
            

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ps.println("GET " + param );
            ps.println();
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}