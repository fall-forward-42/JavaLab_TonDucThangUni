package org;
public class HibernateExample {
    public static void main(String[] args) {
        // Obtain a session factory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Begin a transaction
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Create a new instance of Phone and set its properties
            Phone newPhone = new Phone();
            newPhone.setModel("Galaxy S10");
            newPhone.setManufacturerId(1L); // This would be a foreign key to an existing Manufacturer

            // Save the phone object to the database
            session.save(newPhone);

            tx.commit(); // Commit the transaction
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
