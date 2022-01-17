package com.example.farmtask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //CUSTOMER CONSTANTS
    public static final String CUSTOMER = "CUSTOMER";
    public static final String COLUMN_CUSTOMER_NAME = "NAME";
    public static final String COLUMN_CUSTOMER_MOBILE = "MOBILE";
    public static final String COLUMN_CUSTOMER_ID_TYPE = "ID_TYPE";
    public static final String COLUMN_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String COLUMN_CUSTOMER_PASSWORD = "PASSWORD";

    //PAYMENT CONSTANTS
    public static final String PAYMENT = "PAYMENT";
    public static final String COLUMN_CARD = "CARD";
    public static final String COLUMN_CVC = "CVC";
    public static final String COLUMN_BILL = "BILL";
    public static final String COLUMN_DATE = "DATE";

    //FARM CONSTANTS
    public static final String CUSTOMER_FARM = "CUSTOMER_FARM";
    public static final String COLUMN_FARM_TYPE = "FARM_TYPE";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_CULTIVATE = "CULTIVATE";
    public static final String COLUMN_FARM_SIZE = "FARM_SIZE";
    public static final String COLUMN_PAY_WITH = "PAY_WITH";

    //ID
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "farm.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Customer
        String createCustomerStatement = "CREATE TABLE " + CUSTOMER + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CUSTOMER_NAME + " TEXT, " +
                COLUMN_CUSTOMER_MOBILE + " TEXT, " +
                COLUMN_CUSTOMER_ID_TYPE + " TEXT, " +
                COLUMN_CUSTOMER_ID + " TEXT, " +
                COLUMN_CUSTOMER_PASSWORD + " TEXT)";
        db.execSQL(createCustomerStatement);

        //Create Payment
        String createPaymentStatement = "CREATE TABLE " + PAYMENT + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CARD + " TEXT, " +
                COLUMN_CVC + " TEXT, " +
                COLUMN_BILL + " TEXT, " +
                COLUMN_DATE + " TEXT)";
        db.execSQL(createPaymentStatement);

        //Create Farm
        String createTableStatement = "CREATE TABLE " + CUSTOMER_FARM + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FARM_TYPE + " TEXT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_CULTIVATE + " TEXT, " +
                COLUMN_FARM_SIZE + " TEXT, " +
                COLUMN_PAY_WITH + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //CUSTOMER CREATE OPERATION
    public boolean addCustomer(Customer customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME, customer.getName());
        cv.put(COLUMN_CUSTOMER_MOBILE, customer.getMobile());
        cv.put(COLUMN_CUSTOMER_ID_TYPE, customer.getId_type());
        cv.put(COLUMN_CUSTOMER_ID, customer.getCustomer_id());
        cv.put(COLUMN_CUSTOMER_PASSWORD, customer.getPassword());
        long insert = db.insert(CUSTOMER, null, cv);
        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }

    //CUSTOMER READ OPERATION

    List<Customer> getCustomers(){
        List<Customer> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + CUSTOMER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String customerName = cursor.getString(1);
                String customerMobile = cursor.getString(2);
                String customerIDType = cursor.getString(3);
                String customerID = cursor.getString(4);
                String customerPassword = cursor.getString(5);

                Customer customer = new Customer(id, customerName, customerMobile, customerIDType, customerID, customerPassword);
                returnList.add(customer);
            } while (cursor.moveToNext());
        } else {

        }

        cursor.close();
        db.close();
        return returnList;

    }

    //PAYMENT CREATE OPERATION
    public boolean addPayment(Payment payment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CARD, payment.getCard());
        cv.put(COLUMN_CVC, payment.getCvc());
        cv.put(COLUMN_BILL, payment.getBill());
        cv.put(COLUMN_DATE, payment.getDate());
        long insert = db.insert(PAYMENT, null, cv);
        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }

    //FARM CREATE OPERATION
    public boolean addFarm(Farm farm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FARM_TYPE, farm.getFarm_type());
        cv.put(COLUMN_CATEGORY, farm.getCategory());
        cv.put(COLUMN_CULTIVATE, farm.getCultivate());
        cv.put(COLUMN_FARM_SIZE, farm.getFarm_size());
        cv.put(COLUMN_PAY_WITH, farm.getPay_with());
        long insert = db.insert(CUSTOMER_FARM, null, cv);
        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }
}
