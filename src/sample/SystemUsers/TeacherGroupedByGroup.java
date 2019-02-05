package sample.SystemUsers;

public class TeacherGroupedByGroup extends Classmate {

    private String subject;

    public TeacherGroupedByGroup(String name, String emailAddress,String subject) {
        super(name, emailAddress);
        this.subject=subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
