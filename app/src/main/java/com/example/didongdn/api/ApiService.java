package com.example.didongdn.api;

public class ApiService {
    private static String  url = "https://ttd-api.herokuapp.com/";
    public static  DataService getService(){
        return retrofit.getClient(url).create(DataService.class);
    }
}
