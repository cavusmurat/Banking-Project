
package com.core.banking.session;

import com.core.banking.model.User;


public class UserSession {
    
    private static User user;
    
    
    public static void clear(){
        user=null;
    
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserSession.user = user;
    }
    
}
