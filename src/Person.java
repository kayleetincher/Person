import java.util.Objects;


public class Person
{
    private static int IDSeed;
    private String IDNum;
    private String firstName;
    private String lastName;

    private String title;
    private int YOB;
    private String fullName;

    private String formalName;

    private String getAge;

    public String getAge(int year) {
        return null;
    }

    public static void setIDseed(int IDseed) {
        Person.IDseed = IDseed;
    }

    public static int getIDseed() {
        return IDseed;
    }

    static private int IDseed = 1;
    
    public static  void setIDSeed(int IDSeed){Person.IDSeed = IDSeed; }
    public static int getIDSeed(){return IDseed;}

    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    public Person(String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    public String getIDNum() {
        return IDNum;
    }

    private String genIDNum()
    {
        String newID = "" + IDseed;
        while(newID.length() < 8) {
            newID = "0" + newID;
        }

        IDseed++;
        return newID;
    }


    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }
    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = firstName + lastName;
    }
    public String getFormalName(){
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = title + " " + fullName;
    }

    public String getGetAge() {
        return getAge;
    }

    public void setGetAge(String getAge) {
        this.getAge = getAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && IDNum.equals(person.IDNum) && firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ",";
        retString += DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "YOB"  + DQ + ":" + this.YOB + "}";

        return retString;
    }

    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Person>" + "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<YOB>" + this.YOB + "</YOB></Person>";

        return retString;
    }
    public String toCSVRecord() {
        return  this.IDNum + ", " + this.firstName + "," + this.lastName + "," + YOB;
    }


}


