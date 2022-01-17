package com.example.farmtask;

public class Payment {
    private Integer id;
    private String card;
    private String cvc;
    private String bill;
    private String date;

    public Payment(Integer id, String card, String cvc, String bill, String date) {
        this.id = id;
        this.card = card;
        this.cvc = cvc;
        this.bill = bill;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
