package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        Map<String, String> addresses = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;

            String family = reader.readLine();

            if (family.isEmpty()) break;

            addresses.put(city, family);
        }

        // Read the house number
        String houseNumber = reader.readLine();

        if (addresses.containsKey(houseNumber)) {
            String familyName = addresses.get(houseNumber);
            System.out.println(familyName);
        }
    }
}
