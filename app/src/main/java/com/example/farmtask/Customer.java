package com.example.farmtask;

public class Customer {
    private Integer id;
    private String name;
    private String mobile;
    private String id_type;
    private String customer_id;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer(Integer id, String name, String mobile, String id_type, String customer_id, String password) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.id_type = id_type;
        this.customer_id = customer_id;
        this.password = password;
    }
}
