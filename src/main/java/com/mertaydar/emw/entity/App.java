package com.mertaydar.emw.entity;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	// loads configuration and mappings
        Configuration configuration = new Configuration().configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
         
        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
//        User user = new User();
//        user.setName("Mert");
//        user.setEmail("denem");
//        user.setPassword("asd");
//        byte[] a = hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d");
//        user.setPhoto(a);
//        user.setUsername("zbrave");
//        user.setEnabled(false);
        
        
//        UserRole ur = new UserRole();
//        ur.setRole("ADMIN");
//        ur.setUser(user);
//        
//        List<UserRole> urList = new ArrayList<UserRole>();
//        urList.add(ur);
//        user.setRoles(urList);
//        session.save(user);
        
//        Message msg = new Message();
//        msg.setDescription("açıklama");
//        msg.setToUser((User) session.get(User.class, 8));
//        msg.setUser((User) session.get(User.class, 8));
//        msg.setDate(new Date());
//        session.save(msg);
        
        User usr = (User) session.get(User.class, 8);
//        
//        System.out.println("Outbox: "+usr.getOutbox().get(0).getDescription());
//        System.out.println("Inbox: "+usr.getInbox().get(0).getDescription());
//        ForgotPassword frg = new ForgotPassword();
//        frg.setCode("123");
//        frg.setDate(new Date());
//        frg.setUser(usr);
//        usr.setForgotPassword(frg);
//        RegisterActivation reg = new RegisterActivation(null, usr, "12");
//        reg.setDate(new Date());
//        usr.setRegisterActivation(reg);
//        BanHistory ban = new BanHistory();
//        ban.setBanTime(new Date());
//        ban.setEndTime(new Date());
//        ban.setExplanation("asd");
//        ban.setUser(usr);
//        List<BanHistory> l = new ArrayList<BanHistory>();
//        l.add(ban);
//        usr.setBanHistory(l);
//        House h = new House();
//        h.setEnabled(false);
//        h.setTotal(1.2f);
//        h.setUser(usr);
//        List<House> l = new ArrayList<House>();
//        l.add(h);
//        usr.setHouses(l);
//        Account acc = new Account();
//        acc.setDate(new Date());
//        acc.setEnabled(false);
//        acc.setHouse(usr.getHouses().get(0));
//        acc.setUser(usr);
//        acc.setTotal(0f);
//        List<Account> l = new ArrayList<Account>();
//        l.add(acc);
//        usr.setAccounts(l);
//        Type t = new Type();
//        t.setName("asddd");
//        session.save(t);
//        Item i = new Item();
//        i.setAccount(usr.getAccounts().get(0));
//        i.setDate(new Date());
//        i.setName("asd");
//        i.setType(t);
//        i.setValue(0f);
//        List<Item> l = new ArrayList<Item>();
//        l.add(i);
//        usr.getAccounts().get(0).setItems(l);
        Withdraw w = new Withdraw();
        w.setAccept(false);
        w.setDate(new Date());
        w.setFromAccount(usr.getAccounts().get(0));
        w.setToAccount(usr.getAccounts().get(0));
        w.setValue(0f);
        List<Withdraw> l = new ArrayList<Withdraw>();
        l.add(w);
        usr.getAccounts().get(0).setIncoming(l);
        session.getTransaction().commit();
        session.close();      
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
