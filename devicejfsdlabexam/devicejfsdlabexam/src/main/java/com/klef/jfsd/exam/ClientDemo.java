package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Device.class)
                .addAnnotatedClass(Smartphone.class)
                .addAnnotatedClass(Tablet.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Device device = new Device();
            device.setBrand("Generic");
            device.setModel("BasicModel");
            device.setPrice(199.99);

            Smartphone smartphone = new Smartphone();
            smartphone.setBrand("Samsung");
            smartphone.setModel("Galaxy S21");
            smartphone.setPrice(999.99);
            smartphone.setOperatingSystem("Android");
            smartphone.setCameraResolution(108);

            Tablet tablet = new Tablet();
            tablet.setBrand("Apple");
            tablet.setModel("iPad Pro");
            tablet.setPrice(799.99);
            tablet.setScreenSize(12.9);
            tablet.setBatteryLife(10);

            session.beginTransaction();

            session.save(device);
            session.save(smartphone);
            session.save(tablet);

            session.getTransaction().commit();

            System.out.println("Objects saved!");

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("\nFetching all devices...");
            List<Device> devices = session.createQuery("from Device", Device.class).getResultList();
            for (Device dev : devices) {
                System.out.println(dev);
            }

            System.out.println("\nFetching all smartphones...");
            List<Smartphone> smartphones = session.createQuery("from Smartphone", Smartphone.class).getResultList();
            for (Smartphone phone : smartphones) {
                System.out.println(phone);
            }

            System.out.println("\nFetching all tablets...");
            List<Tablet> tablets = session.createQuery("from Tablet", Tablet.class).getResultList();
            for (Tablet tab : tablets) {
                System.out.println(tab);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
