
package com.core.banking.model;

public enum Role {

    TELLER(100), LEADER(200), MANAGER(300);

    int level;

    Role(int level){
        this.level = level;
    }

}