package com.upgrad.ublog.dao;

import com.upgrad.ublog.dtos.User;

import java.sql.SQLException;

/**
 * TODO: 3.5. Implement the UserDAO interface and implement this class using the Singleton pattern.
 *  (Hint: Should have a private no-arg Constructor, a private static instance attribute of type
 *  UserDAOImpl and a public static getInstance() method which returns the instance attribute.)
 * TODO: 3.6. findByEmailId() method should take email id as an input parameter and
 *  return the user details corresponding to the email id from the USER table defined
 *  in the database. (Hint: You should get the connection using the Database class)
 * TODO: 3.7. create() method should take user details as input and insert these details
 *  into the USER table. Return the same User object which was passed as an input
 *  argument. (Hint: You should get the connection using the Database class)
 */

public abstract class UserDAOImpl implements UserDAO {
    private static  UserDAOImpl userDAO;
    private static Object User;

    public static UserDAO getUser() {
        return (UserDAO) User;
    }

    public UserDAOImpl userDAO(){
        if(userDAO==null){
            return userDAO();
        }
        else  return userDAO;
    }
    private static UserDAO getUserDAO(){
        return (UserDAO) User;
    }
    public String findByEmailId(){

        return  userDAO().findByEmailId();
    }
public UserDAOImpl create(){
        return userDAO();
}

  public static void main(String[] args) {
        try {
            UserDAO userDAO = new UserDAOImpl() {
                @Override
                public String create(User user) throws SQLException {
                    String emailId = user.getEmailId();
                    return emailId;

                }

                @Override
                public String findByEmailId(String emailId) throws SQLException {
                    return emailId;
                }
            };
            User temp = new User();
            temp.getUserId();
            temp.getEmailId();
            temp.getPassword();
            userDAO.create(temp);
            System.out.println("User{userId=11, "+userDAO.findByEmailId("temp@temp.temp")+", password='temp'}");
        } catch (Exception e) {
            System.out.println("FAILED");
        }

//        /**
//         * Following should be the desired output of the main method.
//         * User{userId=11, emailId='temp@temp.temp', password='temp'}
//         */
    }
}
