package hibernate.entity;


import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "title")
private String title;

@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                      CascadeType.DETACH, CascadeType.REFRESH})
@JoinColumn(name = "instructor_id")
private Instructor myInstructor;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getMyInstructor() {
        return myInstructor;
    }

    public void setMyInstructor(Instructor myInstructor) {
        this.myInstructor = myInstructor;
    }

    @Override
    public String toString() {
        return "Course [" +
                "id=" + id +
                ", title='" + title + ']';
    }
}
