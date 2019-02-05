package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.nashorn.internal.runtime.Version;
import sample.SystemUsers.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnections {

    public static void connect() {
        try {
            String url = "jdbc:mysql://den1.mysql3.gear.host:3306/projectcourse2";
            Connection connection = DriverManager.getConnection(url, "projectcourse2", "Cg25k9o3?!3l");
            statement = connection.createStatement();
            st = connection.createStatement();
        } catch (SQLException var2) {
            System.out.println("Connection failed.");
            var2.printStackTrace();
        }
    }

    public static ArrayList<String> getLoginID() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT loginid FROM persons");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static ArrayList<String> getPassword() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT password FROM persons");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static ArrayList<String> getSSN() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT ssn FROM persons");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static boolean isAdmin(String SSN) {
        boolean result = false;

        try {
            for(ResultSet resultSet = statement.executeQuery("SELECT id FROM admins, persons WHERE admins.ssn = persons.ssn AND persons.ssn = '" + SSN + "'"); resultSet.next(); result = true) {
                ;
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static boolean isStaff(String SSN) {
        boolean result = false;

        try {
            for(ResultSet resultSet = statement.executeQuery("SELECT id FROM staff, persons WHERE staff.ssn = persons.ssn AND persons.ssn = '" + SSN + "'"); resultSet.next(); result = true) {
                ;
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static boolean isStudent(String SSN) {
        boolean result = false;

        try {
            for(ResultSet resultSet = statement.executeQuery("SELECT studentid FROM students, persons WHERE students.ssn = persons.ssn AND persons.ssn = '" + SSN + "'"); resultSet.next(); result = true) {
                ;
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static boolean isTeacher(String SSN) {
        boolean result = false;

        try {
            for(ResultSet resultSet = statement.executeQuery("SELECT teacherid FROM teachers, persons WHERE teachers.ssn = persons.ssn AND persons.ssn = '" + SSN + "'"); resultSet.next(); result = true) {

            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Teacher> getTeacherInfo() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT persons.ssn, firstname, lastname, dateofbirth, address, phonenumber, emailadress, subject, loginid, password FROM persons, teachers WHERE persons.ssn = teachers.ssn ORDER BY teacherid");

            while(resultSet.next()) {
                Teacher teacher = new Teacher();

                teacher.setSSN(resultSet.getString(1));
                teacher.setName(resultSet.getString(2));
                teacher.setSurname(resultSet.getString(3));
                teacher.setDateOfBirth(resultSet.getString(4));
                teacher.setHomeAddress(resultSet.getString(5));
                teacher.setPhoneNum(resultSet.getString(6));
                teacher.setEmailAddress(resultSet.getString(7));
                teacher.setTeachingField(resultSet.getString(8));
                teacher.setUserName(resultSet.getString(9));
                teacher.setPassWord(resultSet.getString(10));

                result.add(teacher);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Staff> getStaffInfo() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT persons.ssn, firstname, lastname, dateofbirth, address, phonenumber, emailadress, job, loginid, password FROM persons, staff WHERE persons.ssn = staff.ssn");

            while (resultSet.next()) {
                Staff staff = new Staff();

                staff.setSSN(resultSet.getString(1));
                staff.setName(resultSet.getString(2));
                staff.setSurname(resultSet.getString(3));
                staff.setDateOfBirth(resultSet.getString(4));
                staff.setHomeAddress(resultSet.getString(5));
                staff.setPhoneNum(resultSet.getString(6));
                staff.setEmailAddress(resultSet.getString(7));
                staff.setPosition(resultSet.getString(8));
                staff.setUserName(resultSet.getString(9));
                staff.setPassword(resultSet.getString(10));

                result.add(staff);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return result;
    }

    private static final String URL="jdbc:mysql://den1.mysql3.gear.host:3306/projectcourse2";

    public static ObservableList<Student> getStudentInfo(String selectedGroup){
        ObservableList result = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT persons.SSN, firstname, lastname, dateofbirth, emailadress, phonenumber, address, loginid, password FROM persons, students, groups WHERE persons.ssn = students.ssn AND students.groupid = groups.groupid AND groups.groupid = '" + selectedGroup + "'");

            while(resultSet.next()) {
                Student student = new Student();
                student.setSSN(resultSet.getString(1));
                student.setName(resultSet.getString(2));
                student.setSurname(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getString(4));
                student.setEmailAddress(resultSet.getString(5));
                student.setHomeAddress(resultSet.getString(7));
                student.setUsername(resultSet.getString(8));
                student.setPassword(resultSet.getString(9));
                student.setPhoneNumber(resultSet.getString(6));
                result.add(student);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Teacher> getTeacherInfoGroup(String selectedGroup) {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT subject, firstname, lastname, emailadress, phonenumber, persons.ssn FROM persons, teachers, groups, groups_teachers WHERE persons.ssn = teachers.ssn AND teachers.teacherid = groups_teachers.teacherid AND groups_teachers.groupid = groups.groupid AND groups.groupid = '" + selectedGroup + "'");

            while(resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeachingField(resultSet.getString(1));
                teacher.setName(resultSet.getString(2));
                teacher.setSurname(resultSet.getString(3));
                teacher.setEmailAddress(resultSet.getString(4));
                teacher.setPhoneNum(resultSet.getString(5));
                teacher.setSSN(resultSet.getString(6));
                result.add(teacher);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Teacher> getTeacherInfoNotGroup(String selectedGroup) {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("select persons.ssn, subject, firstname, lastname from persons, teachers where persons.ssn = teachers.ssn and teacherid NOT IN (select teachers.teacherid from teachers, groups_teachers where teachers.teacherid = groups_teachers.teacherid and groups_teachers.groupid = "+selectedGroup+")");

            while(resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setSSN(resultSet.getString(1));
                teacher.setTeachingField(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setSurname(resultSet.getString(4));
                result.add(teacher);
            }
        }catch (SQLException var4){
            var4.printStackTrace();
        }

        return result;
    }

    public static void addTeacher(Teacher newTeacher) {
        try {
            statement.execute("" +
                    "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                    "VALUES ('" +
                    newTeacher.getSSN() + "','" +
                    newTeacher.getName() + "','" +
                    newTeacher.getSurname() + "','" +
                    newTeacher.getDateOfBirth() + "','" +
                    newTeacher.getHomeAddress() + "','" +
                    newTeacher.getPhoneNum() + "','" +
                    newTeacher.getUserName() + "','" +
                    newTeacher.getPassWord() + "','" +
                    newTeacher.getEmailAddress() + "')");

            statement.execute("INSERT INTO teachers (ssn, subject)" +
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newTeacher.getSSN() + "'),'" + newTeacher.getTeachingField() +"');");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void editTeacher(ObservableList<Teacher> editedList) {
        try {
            ArrayList list = getTeacherID(editedList);
                    for(int i = 0; i < editedList.size(); i++) {
                        statement.execute("" +
                                "UPDATE persons " +
                                "SET firstname = '" + editedList.get(i).getName() + "', lastname = '" +
                                editedList.get(i).getSurname() + "', dateofbirth = '" +
                                editedList.get(i).getDateOfBirth() + "', address = '" +
                                editedList.get(i).getHomeAddress() + "', phonenumber = '" +
                                editedList.get(i).getPhoneNum() + "', loginid = '" +
                                editedList.get(i).getUserName() + "', password = '" +
                                editedList.get(i).getPassWord() + "', emailadress = '" +
                                editedList.get(i).getEmailAddress() + "'" +
                                "WHERE SSN = '" + editedList.get(i).getSSN() + "'");

                        statement.execute("" +
                                "UPDATE teachers " +
                                "SET subject = '" + editedList.get(i).getTeachingField() +
                                "' WHERE teacherid = " + list.get(i));
                    }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public static void deleteTeacher(Teacher teacher) {
        try {
            String teacherid = getSingleTeacherID(teacher);
            statement.execute("DELETE FROM groups_teachers where teacherid = '" + teacherid + "'");
            statement.execute("DELETE FROM grades where teacherid = '" + teacherid + "'");
            statement.execute("DELETE FROM teachers where teacherid = '" + teacherid + "'");
            statement.execute("DELETE FROM persons where ssn = '" + teacher.getSSN() + "'");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public static ArrayList<String> getTeacherID(ObservableList<Teacher> editedList) {
        ArrayList<String> result = new ArrayList<>();

        try {
            for(int i = 0; i < editedList.size(); i++) {
                ResultSet resultSet = statement.executeQuery("SELECT teacherid FROM teachers WHERE ssn = '" + editedList.get(i).getSSN() + "'");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static String getSingleTeacherID(Teacher teacher) {
        String string = "";
        try {
                ResultSet resultSet = statement.executeQuery("SELECT teacherid FROM teachers WHERE ssn = '" + teacher.getSSN() + "'");

                while(resultSet.next()) {
                    string = resultSet.getString(1);
                }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return string;

    }

    public static void addStaff(Staff newStaff) {
        try {
            statement.execute("" +
                    "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                    "VALUES ('" +
                    newStaff.getSSN() + "','" +
                    newStaff.getName() + "','" +
                    newStaff.getSurname() + "','" +
                    newStaff.getDateOfBirth() + "','" +
                    newStaff.getHomeAddress() + "','" +
                    newStaff.getPhoneNum() + "','" +
                    newStaff.getUserName() + "','" +
                    newStaff.getPassword() + "','" +
                    newStaff.getEmailAddress() + "')");

            statement.execute("INSERT INTO staff (ssn, job)" +
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newStaff.getSSN() + "'),'" + newStaff.getPosition() +"');");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void editStaff(ObservableList<Staff> editedList) {
        try {
            ArrayList list = getStaffID(editedList);
            for(int i = 0; i < editedList.size(); i++) {
                statement.execute("" +
                        "UPDATE persons " +
                        "SET firstname = '" + editedList.get(i).getName() + "', lastname = '" +
                        editedList.get(i).getSurname() + "', dateofbirth = '" +
                        editedList.get(i).getDateOfBirth() + "', address = '" +
                        editedList.get(i).getHomeAddress() + "', phonenumber = '" +
                        editedList.get(i).getPhoneNum() + "', loginid = '" +
                        editedList.get(i).getUserName() + "', password = '" +
                        editedList.get(i).getPassword() + "', emailadress = '" +
                        editedList.get(i).getEmailAddress() + "'" +
                        "WHERE SSN = '" + editedList.get(i).getSSN() + "'");

                statement.execute("" +
                        "UPDATE teachers " +
                        "SET subject = '" + editedList.get(i).getPosition() +
                        "' WHERE teacherid = " + list.get(i));
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public static ArrayList<String> getStaffID(ObservableList<Staff> editedList) {
        ArrayList<String> result = new ArrayList<>();

        try {
            for(int i = 0; i < editedList.size(); i++) {
                ResultSet resultSet = statement.executeQuery("SELECT id FROM staff WHERE ssn = '" + editedList.get(i).getSSN() + "'");

                while(resultSet.next()) {
                    result.add(resultSet.getString(1));
                }
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static void deleteStaff(Staff staff) {
        try {
            String staffid = getSingleStaffID(staff);
            statement.execute("DELETE FROM staff WHERE id = '" + staffid + "'");
            statement.execute("DELETE FROM persons where ssn = '" + staff.getSSN() + "'");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public static String getSingleStaffID(Staff staff) {
        String string = "";
        try {
            ResultSet resultSet = statement.executeQuery("SELECT id FROM staff WHERE ssn = '" + staff.getSSN() + "'");
            while(resultSet.next()) {
                string = resultSet.getString(1);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return string;

    }

    public static String getFirstName(String username) {
        String string = "";
        try {
            ResultSet resultSet = statement.executeQuery("SELECT firstname FROM persons WHERE loginid = '" + username + "'");
            while(resultSet.next()) {
                string = resultSet.getString(1);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return string;
    }


    public static void addStudent(Student newStudent) {
        try {
            statement.execute("" +
                    "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                    "VALUES ('" +
                    newStudent.getSSN() + "','" +
                    newStudent.getName() + "','" +
                    newStudent.getSurname() + "','" +
                    newStudent.getDateOfBirth() + "','" +
                    newStudent.getHomeAddress() + "','" +
                    newStudent.getPhoneNumber() + "','" +
                    newStudent.getUsername() + "','" +
                    newStudent.getPassword() + "','" +
                    newStudent.getEmailAddress() + "')");

            statement.execute("INSERT INTO students (ssn, groupid) " +
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newStudent.getSSN() + "'),(SELECT groupid FROM groups WHERE groupid = '" + newStudent.getGradeYear() +"'))");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void addAdmin(AdminMember newAdmin) {
        try {
            statement.execute("" +
                    "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                    "VALUES ('" +
                    newAdmin.getSSN() + "','" +
                    newAdmin.getName() + "','" +
                    newAdmin.getSurname() + "','" +
                    newAdmin.getDateOfBirth() + "','" +
                    newAdmin.getHomeAddress() + "','" +
                    newAdmin.getPhoneNum() + "','" +
                    newAdmin.getUserName() + "','" +
                    newAdmin.getPassWord() + "','" +
                    newAdmin.getEmailAddress() + "')");

            statement.execute("INSERT INTO admins (ssn, position) " +
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newAdmin.getSSN() + "'),'" + newAdmin.getPosition() +"')");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void editStudents(ObservableList<Student> editedList) {
        try {
            for(int i = 0; i < editedList.size(); i++) {
                statement.execute("" +
                        "UPDATE persons " +
                        "SET firstname = '" + editedList.get(i).getName() + "', lastname = '" +
                        editedList.get(i).getSurname() + "', dateofbirth = '" +
                        editedList.get(i).getDateOfBirth() + "', address = '" +
                        editedList.get(i).getHomeAddress() + "', phonenumber = '" +
                        editedList.get(i).getPhoneNumber() + "', loginid = '" +
                        editedList.get(i).getUsername() + "', password = '" +
                        editedList.get(i).getPassword() + "', emailadress = '" +
                        editedList.get(i).getEmailAddress() + "'" +
                        "WHERE SSN = '" + editedList.get(i).getSSN() + "'");
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public static ArrayList<String> getGradeID(String studentId) {
        ArrayList<String> result = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT gradeid FROM grades WHERE studentid = '" + studentId + "'");
            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static void deleteStudent(Student student) {
        try {
            String studentid = getSingleStudentID(student);

            for (String item : getGradeID(studentid)) {
                statement.execute("DELETE FROM grades WHERE gradeid = '" + item + "'");
            }
            statement.execute("DELETE FROM students WHERE studentid = '" + studentid + "'");
            statement.execute("DELETE FROM persons where ssn = '" + student.getSSN() + "'");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public static String getSingleStudentID(Student student) {
        String string = "";
        try {
            ResultSet resultSet = statement.executeQuery("SELECT studentid FROM students WHERE ssn = '" + student.getSSN() + "'");
            while(resultSet.next()) {
                string = resultSet.getString(1);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return string;

    }

    public static void addTeacherToGroup(Teacher addedTeacher, String currentGroup) {
        try {
            statement.execute("" +
                    "INSERT INTO groups_teachers (teacherid, groupid) VALUES ('" + DBConnections.getSingleTeacherID(addedTeacher) + "','" + currentGroup + "')");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void removeTeacherFromGroup(Teacher removedTeacher, String currentGroup) {
        try {
            statement.execute("" +
                    "DELETE FROM groups_teachers WHERE teacherid = '" + DBConnections.getSingleTeacherID(removedTeacher) + "' AND groupid = '" + currentGroup + "'");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void addNewsItem(String title, String category, String text) {
        try {
            statement.execute("" +
                    "INSERT INTO news (newstext, title, category, date)" +
                    "VALUES ('" + text + "','" + title + "','" + category +
                    "','')");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static ArrayList<String> getNews() {
        ArrayList<String> result = new ArrayList<>();

        try {
                ResultSet resultSet = statement.executeQuery("SELECT title, category, newstext FROM news ORDER BY newsid");

                while(resultSet.next()) {
                    result.add(resultSet.getString(1));
                    result.add(resultSet.getString(2));
                    result.add(resultSet.getString(3));
                }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    //This is where Stephan's part starts
    private static final String url="jdbc:mysql://den1.mysql3.gear.host:3306/projectcourse2";
    private static Statement st = null;
    private static ResultSet rs = null;

    public ObservableList<Classmate> getGroupParticipant(String groupID){
        ObservableList<Classmate>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName,EmailAdress FROM persons,students WHERE persons.SSN=students.SSN AND students.GroupID = '" + groupID + "';");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                String email= rs.getString(3);

                Classmate classmate=new Classmate(name,email);
                classmatesArray.add(classmate);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public ObservableList<String> ClassmatesName(String groupID){
        ObservableList<String>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,students WHERE persons.SSN = students.SSN AND students.GroupID = '" + groupID + "';");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                classmatesArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public  String getStudentGroup(String loginID){
        String groupID=null;
        try {
            rs = st.executeQuery("SELECT GroupID FROM students,persons WHERE persons.LoginID = '"+loginID+"' AND persons.SSN = students.SSN;");
            while (rs.next()) {
                groupID = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return groupID;
    }


    public  String getStudentfisrtName(String loginID){
        String firstname=null;
        try {
            rs = st.executeQuery("SELECT DISTINCT firstName FROM persons,students WHERE persons.LoginID = '"+loginID+"';");
            while (rs.next()) {
                firstname = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }return firstname;
    }

    public  String getStudentFullName(String loginID){
        String name = null;
        try {
            rs = st.executeQuery("SELECT DISTINCT firstName, LastName FROM persons,students WHERE persons.LoginID = '"+loginID+"';");
            while (rs.next()) {
                name = rs.getString(1)+"  "+rs.getString(2);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }return name;
    }

    public String getReceiverEmailAdddress(String recieverName){
        String emailAddress=null;
        try {
            rs = st.executeQuery("SELECT EmailAdress FROM persons Where '"+recieverName+"' = (SELECT CONCAT(CONCAT (FirstName,'  '),LastName));");
            while (rs.next()) {
                emailAddress = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }return emailAddress;

    }

    public ObservableList<TeacherGroupedByGroup> getTeacher(String loginID){
        ObservableList<TeacherGroupedByGroup>teachersArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT firstName,lastName,emailAdress,subject FROM persons,students," +
                            "groups,groups_teachers,teachers WHERE persons.SSN = teachers.SSN AND " +
                            "teachers.teacherID=groups_teachers.teacherID AND groups_teachers.groupID = " +
                            "groups.groupID AND groups.groupID = students.groupID AND students.SSN = " +
                            "(SELECT SSN FROM persons WHERE loginID = '"+loginID+"')");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                String email= rs.getString(3);
                String subject= rs.getString(4);

                TeacherGroupedByGroup teacher=new TeacherGroupedByGroup(name,email,subject);

                teachersArray.add(teacher);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return teachersArray;
    }

    public ObservableList<String> groupTeacher(String loginID){
        ObservableList<String>teachersArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT firstName,lastName,emailAdress,subject FROM persons,students," +
                            "groups,groups_teachers,teachers WHERE persons.SSN = teachers.SSN AND " +
                            "teachers.teacherID=groups_teachers.teacherID AND groups_teachers.groupID = " +
                            "groups.groupID AND groups.groupID = students.groupID AND students.SSN = " +
                            "(SELECT SSN FROM persons WHERE loginID = '"+loginID+"')");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);

                teachersArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return teachersArray;
    }

    public double getfirstSemesterGrades(String loginID,String subject){
        double grade =0;
        try {
            rs =st.executeQuery(
                    "SELECT gradeOne FROM grades,teachers,students,persons " +
                            "WHERE persons.SSN = students.SSN AND grades.studentID = students.studentID " +
                            "AND persons.loginID = '"+loginID+"' AND grades.teacherID = teachers.teacherID " +
                            "AND teachers.subject = '"+subject+"'"
            );
            while (rs.next()){
                grade = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return grade;
    }


    public double getSecondSemesterGrades(String loginID,String subject){
        double grade =0;
        try {
            rs =st.executeQuery(
                    "SELECT gradeTwo FROM grades,teachers,students,persons " +
                            "WHERE persons.SSN = students.SSN AND grades.studentID = students.studentID " +
                            "AND persons.loginID = '"+loginID+"' AND grades.teacherID = teachers.teacherID " +
                            "AND teachers.subject = '"+subject+"'"
            );
            while (rs.next()){
                grade = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return grade;
    }

    public String getCurrentUserEmail(String loginID){
        String email=null;
        try {
            rs =st.executeQuery(
                    "select EmailAdress from persons where loginID ='"+loginID+"';"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public String getCurrentUserPassword(String loginID){
        String pass=null;
        try {
            rs =st.executeQuery(
                    "select Password from persons where loginID ='"+loginID+"';"
            );
            while (rs.next()){
                pass = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pass;
    }

    public String principalsName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName, LastName FROM persons, admins WHERE persons.SSN = admins.SSN AND admins.Position = '" + position + "'"
            );
            while (rs.next()){
                name = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }
    public String getprincipalEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getprincipalTel(String position){
        String tel=null;
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }




    public String getITmanagerlName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                name = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String getITmanagerEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getITmanagerTel(String position){
        String tel=null;
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }




    public String getSecretaryName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+" '"
            );
            while (rs.next()){
                name = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String getSecretaryEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getSecretaryTel(String position){
        String tel=null;
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }



    public String getHRmanagerName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                name = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String getHRmanagerEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getHRmanagerTel(String position){
        String tel="";
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }

    public String recoveredPassword(String ssn, String email){
        String password = null;
        try {
            System.out.println("Getting password...");
            rs =st.executeQuery(
                    "SELECT password FROM persons WHERE ssn = '" + ssn + "' AND emailadress = '" + email + "'"
            );
            while (rs.next()){
                System.out.println("Found password!");
                password = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return password;
    }


    public ObservableList<String> teachersName(){
        ObservableList<String>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,teachers WHERE persons.SSN = teachers.SSN");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                classmatesArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public ObservableList<String> adminsName(){
        ObservableList<String>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                classmatesArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public  ObservableList<String> studentNamesByGroup(String groupID){
        ObservableList<String>studentNames = FXCollections.observableArrayList();
        try {
            rs = st.executeQuery("SELECT FirstName,LastName FROM persons,students WHERE persons.SSN = students.SSN AND students.GroupID = '"+groupID+"'");
            while (rs.next()) {
                String name = rs.getString(1)+"  "+rs.getString(2);
                studentNames.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return studentNames;
    }


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

    private static Statement statement;
    public static String sub = null;
    private static String tid = null;

    public static ObservableList<Teacher> getTeacherInfo2() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress, phonenumber, address, subject FROM persons, teachers WHERE persons.ssn = teachers.ssn");

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(resultSet.getString(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setEmailAddress(resultSet.getString(3));
                teacher.setPhoneNum(resultSet.getString(4));
                teacher.setHomeAddress(resultSet.getString(5));
                teacher.setTeachingField(resultSet.getString(6));
                result.add(teacher);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    /**
     * This method will return the grades in the ObservableList.
     * @return ObservableList
     */
    public static ObservableList<Grades> getGradeInfo(String year, String user) {

        System.out.println("Getting grades.");

        ObservableList result = FXCollections.observableArrayList();
        result.clear();
        String gradeyear = year;
        System.out.println("Gradeyear: " + gradeyear);

        try {
            //updated query
            //now resultSet will hold 7 columns values
            //gradeId and LoginID are new attribute in this query

            if(isGroupTeacher(user, year)) {

                ResultSet resultSet = statement.executeQuery("SELECT DISTINCT persons.ssn, firstname, lastname, emailadress, gradeone, gradetwo, gradeid " +
                        "FROM persons, students, grades, groups " +
                        "WHERE persons.ssn = students.ssn " +
                        "AND students.groupid = '" + gradeyear + "' " +
                        "AND grades.studentid = students.studentid " +
                        "AND subject = (select subject from teachers, persons where teachers.ssn = persons.ssn and persons.loginid = '" + user + "')");

                while (resultSet.next()) {
                    Grades staff = new Grades();
                    staff.setSSN(resultSet.getString(1));
                    staff.setName(resultSet.getString(2) + " " + resultSet.getString(3));
                    staff.setEmailAdress(resultSet.getString(4));
                    staff.setMgrade1(resultSet.getDouble(5));
                    staff.setMgrade2(resultSet.getDouble(6));
                    staff.setGid(resultSet.getInt(7));
                    result.add(staff);
                }

            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static boolean isGroupTeacher(String loginid, String group) {
        boolean result = false;

        try {
            for(ResultSet resultSet = statement.executeQuery("SELECT groups_teachers.teacherid FROM groups_teachers, teachers, persons WHERE teachers.ssn = persons.ssn AND persons.loginid = '" + loginid + "' AND groups_teachers.groupid = '" + group + "' AND groups_teachers.teacherid = teachers.teacherid"); resultSet.next(); result = true) {

            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static String openfilegrade() {
        String fileName = "grade.txt";

        // This will reference one line at a time
        String line = null;
        String username = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Wraps FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    System.out.println(line);
                    username = line;
                    break;
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

            // ex.printStackTrace();
        }
        return username;
    }

    public static ArrayList<String> getAdminInfo() {
        ArrayList<String> Admininfo = new ArrayList<String>();
        try {
            ResultSet resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'Principal');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
            resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'IT Manager');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
            resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'General Secretary');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
            resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'Human Resources Manager');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return Admininfo;
    }

    public static boolean updatePass(String login, String newpass, String oldpass) {
        try {
            int i = statement.executeUpdate("" +
                    "UPDATE persons " +
                    "SET Password = '" + newpass + "' " +
                    "WHERE LoginID= '" + login + "' and Password = '" + oldpass + "'");
            if (i > 0) {

                return true;
            } else {
                return false;
            }
        } catch (SQLException var4) {

            var4.printStackTrace();
            return false;
        }


    }

    /**
     * This method will search the persons data from database.
     * if any data is found then it will return the string with data
     * else it will return the empty string
     * @param name
     * @return String
     */

    public static ObservableList<Person> getSearchResult(String name){
        ObservableList<Person> list = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = statement.executeQuery("select ssn,FirstName,LastName,PhoneNumber,EmailAdress " +
                    "from persons where FirstName LIKE '"+name+"%'");

            while (resultSet.next()) {
                Person person = new Person();
                person.setSSN(resultSet.getString(1));
                person.setName(resultSet.getString(2));
                person.setSurname(resultSet.getString(3));
                person.setEmailAddress(resultSet.getString(5));
                list.add(person);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return list;
    }

    /**
     * There are four parameters .
     * first is table param.It is used to update the specific table from database
     * Second is Column param.It is a column Name that is already defined in the database.
     * Third is Value Param.It is a column value that we update the column in the DB.
     * Last is id. It is unique attribute that is already defined in the db
     * If table is persons then its id Name is LoginID
     * else it is GradeID
     * This method is used to update the grades and persons table .
     *
     * @param table
     * @param column
     * @param value
     * @param id
     * @return int
     */
    public static int updateGradeTable(String table,String column,String value,String id){
        int i=0;
        try {
            if(table.equals("persons")){
                i = statement.executeUpdate("UPDATE "+table+" SET "+column+" ='"+value+"' WHERE LoginID = '"+id+"' ");
            }else if(table.equals("grades")){
                i = statement.executeUpdate("UPDATE "+table+" SET "+column+" ='"+value+"' WHERE GradeID = "+id+" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}



