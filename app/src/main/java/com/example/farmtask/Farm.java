package com.example.farmtask;

public class Farm {
    private String farm_type;
    private String category;
    private String cultivate;
    private String farm_size;
    private String pay_with;
    private Integer id;

    public Farm(String farm_type, String category, String cultivate, String farm_size, String pay_with, Integer id) {
        this.farm_type = farm_type;
        this.category = category;
        this.cultivate = cultivate;
        this.farm_size = farm_size;
        this.pay_with = pay_with;
        this.id = id;
    }

    //farm type
    public String getFarm_type(){
        return farm_type;
    }

    public void setFarm_type(String value){
        farm_type = value;
    }

    //category
    public String getCategory(){
        return category;
    }

    public void setCategory(String value){
        category = value;
    }

    //cultivate
    public String getCultivate(){
        return cultivate;
    }

    public void setCultivate(String value){
        cultivate = value;
    }

    //farm_size
    public String getFarm_size(){
        return farm_size;
    }

    public void setFarm_size(String value){
        farm_size = value;
    }

    //pay_with
    public String getPay_with(){
        return pay_with;
    }

    public void setPay_with(String value){
        pay_with = value;
    }

    //id
    public Integer getId(){
        return id;
    }

    public void setId(Integer value){
        id = value;
    }
}
