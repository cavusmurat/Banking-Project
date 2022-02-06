
package com.core.banking.model;

public class Transaction {

    private Long id;
    private String name;
    private String description;
    private String url;
    private boolean isWeb;
    private boolean isAtm;
    private boolean isCounter;
    private boolean isConfirmation;
    private Role confirmationLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isWeb() {
        return isWeb;
    }

    public void setWeb(boolean web) {
        isWeb = web;
    }

    public boolean isAtm() {
        return isAtm;
    }

    public void setAtm(boolean atm) {
        isAtm = atm;
    }

    public boolean isCounter() {
        return isCounter;
    }

    public void setCounter(boolean counter) {
        isCounter = counter;
    }

    public boolean isConfirmation() {
        return isConfirmation;
    }

    public void setConfirmation(boolean confirmation) {
        isConfirmation = confirmation;
    }

    public Role getConfirmationLevel() {
        return confirmationLevel;
    }

    public void setConfirmationLevel(Role confirmationLevel) {
        this.confirmationLevel = confirmationLevel;
    }
}