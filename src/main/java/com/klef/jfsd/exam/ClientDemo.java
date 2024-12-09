package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
      
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert Device Record
        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("DeviceModel");
        device.setPrice(5000);
        session.persist(device);

        // Insert Smartphone Record
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Samsung");
        smartphone.setModel("Galaxy S22");
        smartphone.setPrice(70000);
        smartphone.setOperatingSystem("Android");
        smartphone.setCameraResolution("108 MP");
        session.persist(smartphone);

        // Insert Tablet Record
        Tablet tablet = new Tablet();
        tablet.setBrand("Apple");
        tablet.setModel("iPad Pro");
        tablet.setPrice(85000);
        tablet.setScreenSize("12.9 inches");
        tablet.setBatteryLife("10 hours");
        session.persist(tablet);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("All Records inserted successfully!");
    }
}
