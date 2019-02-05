//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Group {
    private StringProperty gradeYearName = new SimpleStringProperty("gradeYearName");
    private Teacher[] teachers;
    private ArrayList<Student> students;

    public Group(StringProperty gradeYearName, Teacher[] teachers, ArrayList<Student> students) {
        this.gradeYearName = gradeYearName;
        this.teachers = teachers;
        this.students = students;
    }

    public String getGradeYearName() {
        return (String)this.gradeYearName.get();
    }

    public StringProperty gradeYearNameProperty() {
        return this.gradeYearName;
    }

    public void setGradeYearName(String gradeYearName) {
        this.gradeYearName.set(gradeYearName);
    }

    public Teacher[] getTeachers() {
        return this.teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
