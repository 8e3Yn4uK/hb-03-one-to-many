package hibernate.demo;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();
        // create a session
        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("InstructorDetail: " + instructorDetail);
            System.out.println("The associated Instructor: " + instructorDetail.getInstructor());
            session.delete(instructorDetail);



            // commit transaction
            session.getTransaction().commit();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
