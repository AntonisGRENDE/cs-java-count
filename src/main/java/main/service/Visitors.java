package main.service;

import main.exception.ApplicationException;
import main.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Visitors {
    /** readFile and return unique visitors */
    public static Object readFileReturnVisitors(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line, la[];
            Map <String, Set<String>> stringSetHashMap = new HashMap<>();   //email and phoneSet
            br.readLine();                      // first line has the name of the columns, so it is being omitted
            while ((line = br.readLine()) != null) {
                la = line.split(",");
                if (la.length != 3)             // in case its seperated with ";" instead of ","
                    la = line.split(";");
                if (la.length == 3
                        && la[0] != null && la[1] != null && la[2] != null
                        && !la[0].isBlank() && !la[1].isBlank() && !la[2].isBlank()) {
                    if (!stringSetHashMap.containsKey(la[0])) {
                        Set <String> temp = new HashSet<>();
                        temp.add(la[1]);
                        stringSetHashMap.put(la[0], temp);
                    }
                    else if (!stringSetHashMap.get(la[0]).contains(la[1])) {
                        stringSetHashMap.get(la[0]).add(la[1]);
                    } else {
                        System.out.println("Duplicate item: " + la[0] + " " + la[1]);
                    }
                }
            }
            if (!stringSetHashMap.isEmpty())
                return stringSetHashMap;
            else
                return "There were no visitors";
        }
        catch (FileNotFoundException ex) {
            throw new ApplicationException(HttpStatus.BAD_REQUEST, "The file path could not be found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
