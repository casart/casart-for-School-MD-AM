import java.lang.String;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        System.out.println("Casimov Artiom application for SchoolMD!");

        /*
        * - create list of users. To create users - use constructor with all parameters.
            You can use array or ArrayList(prefferably).
            Some of the created users should have status as NEW.
        */
        ArrayList<User> usersArray = new ArrayList<User>();

        User User1 = new User("Artiom", "Casimov", 35, "casimov.artiom@gmail.com", Status.NEW);
        User User2 = new User("Alfreds", "Futterkiste", 22, "alfreds.futterkiste@gmail.com", Status.ACTIVE);
        User User3 = new User("Maria", "Anders", 32, "maria.anders@gmail.com", Status.NEW);
        User User4 = new User("Ana", "Trujillo", 21, "ana.trujillo@gmail.com", Status.INACTIVE);
        User User5 = new User("Antonio", "Moreno", 25, "antonio.moreno@gmail.com", Status.BLOCKED);
        User User6 = new User("Thomas", "Hardy", 16, "thomas.hardy@gmail.com", Status.NEW);
        User User7 = new User("Christina", "Berglund", 19, "christina.berglund@gmail.com", Status.ACTIVE);

        usersArray.add(User1);
        usersArray.add(User2);
        usersArray.add(User3);
        usersArray.add(User4);
        usersArray.add(User5);
        usersArray.add(User6);
        usersArray.add(User7);

        /*
        * Print out all users settings
        */
        System.out.println("List of users and their parameters:");
        for (User i : usersArray) {
            System.out.println(i.toString());
        }
        /*
        * Checking for any changes
        */
        for (User i : usersArray) {
            ActivateUser(i);
            BlockUser(i);
        }
    }

/*
- iterate through the list of users and change status to ACTIVE for NEW users
whose timestamp when they were registered in the system is older than yesterday.
You can extract this functionality into a separate method
* */
    static void ActivateUser(User checkUser){
        //oneDayDuration time can be changed for testing application
        long oneDayDuration = 24*60*60*1000;//duration of a day(24 hours) in milli seconds
        long timeWhenCheck = System.currentTimeMillis();

        if(((timeWhenCheck - checkUser.getTimeStamp()) > oneDayDuration) &&
           (checkUser.getStatus() == Status.NEW)){
            checkUser.setStatus(Status.ACTIVE);
            System.out.print("Activate user: ");
            System.out.println(checkUser.toString());
        }
    }
    /*
    - BONUS TASK: write a method that will pick up INACTIVE users that where registered
     more than 1 month ago and set their status to BLOCKED
     */
    static void BlockUser(User checkUser){
        long oneDayDuration = 24*60*60*1000;//duration of a day in milli seconds
        long oneMonthDuration = oneDayDuration*(365/12);//duration of a month in milli seconds
        long timeWhenCheck = System.currentTimeMillis();

        if(((timeWhenCheck - checkUser.getTimeStamp() > oneMonthDuration)) &&
           (checkUser.getStatus() == Status.INACTIVE)){
            checkUser.setStatus(Status.BLOCKED);
            System.out.print("Block user: ");
            System.out.println(checkUser.toString());
        }
    }
}
