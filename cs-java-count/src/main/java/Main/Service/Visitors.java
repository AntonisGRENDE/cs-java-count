package Main.Service;

import Main.model.User;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Visitors {
    /** readFile and return unique visitors */
    public static List<User> readFileRetVi(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line, la[];
            List<User> usersList = new LinkedList<>();
            Set <String> emailsAndPhonesSet = new HashSet<>();
            br.readLine();                      // first line has the name of the columns, so it is ommited
            while ((line = br.readLine()) != null) {
                la = line.split(",");
                if (la.length != 3)             // in case its seperated with ";" instead of ","
                    la = line.split(";");
                if (la.length == 3 && check(la[0]) && check(la[1]) && check(la[2])) {
                    if (Visitors.isUnique(emailsAndPhonesSet, la[0],la[1])) {
                        usersList.add(new User(la[0], la[1], la[2]));
                        emailsAndPhonesSet.add(la[0]);
                        emailsAndPhonesSet.add(la[1]);
                    }
                }
            }
            br.close();
            if (!usersList.isEmpty())
                return usersList;
        }

        catch (FileNotFoundException ex) {
            System.err.println("The file in path " + path + " wasn't found");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean isUnique(Set <String> emailsAndPhonesSet, String email, String phone){
        if (Objects.isNull(emailsAndPhonesSet)
                || (!emailsAndPhonesSet.contains(email) && !emailsAndPhonesSet.contains(phone))){
            return true;
        }
        return false;
    }

    /**is not null or empty or blank
     * @return boolean
     */
    public static boolean check(@NotNull String str){
        if (str.isEmpty() || str.isBlank())
            return false;
        return true;
    }
}
