import java.sql.Timestamp;

public class User {

    private String firstName = new String();
    private String lastName;
    private int age;
    private String email;
    private Status status;
    private long timestamp;

    //adding a non-default constructor
    public  User(String firstName,
                 String lastName,
                 int age,
                 String email,
                 Status status)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setEmail(email);
        setStatus(status);
        this.timestamp = System.currentTimeMillis();
    }

    //getters and setters
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String newFirstName){
        if(newFirstName == "")
            throw new IllegalArgumentException();
        this.firstName = newFirstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String newLastName){
        if(newLastName == "")
            throw new IllegalArgumentException();
        this.lastName = newLastName;
    }

    public int getAge(){
        return this.age;
    }
    public void setAge(int newAge){
        if(newAge < 0){
            throw new IllegalArgumentException("Age must be positive");
        }
        if(newAge > 120){
            throw new IllegalArgumentException("A human can't live more than 120 years");
        }
        this.age = newAge;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String newEmail){
        //add some functionality - check if this is an real email
        if(newEmail == "")
            throw new IllegalArgumentException();
        if(!newEmail.contains("@"))
            throw new IllegalArgumentException();
        this.email = newEmail;
    }

    public Status getStatus(){
        return this.status;
    }
    public void setStatus(Status newStatus){
        this.status = newStatus;
    }

    public long getTimeStamp(){
        return this.timestamp;
    }
    public void setTimeStamp(long timeStamp){
        /*
         *User time is set only once - at registration time in instance constructor
         */
    }

    /*
    * Overwrite toString() method
    */
    @Override
    public String toString(){
        return String.format(firstName +" "+lastName+", "+age+ " years, "+"email: "+email+", status: "+status);
    }
}
