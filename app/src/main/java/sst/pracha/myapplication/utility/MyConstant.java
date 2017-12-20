package sst.pracha.myapplication.utility;

/**
 * Created by pracha on 20/12/2560.
 */

public class MyConstant {
//    about URL
private  String urlPostUserString = "http://androidthai.in.th/sst/addDataBee.php";
private  String urlGetUserString = "http://androidthai.in.th/sst/getAllDataBee.php";

//About Array

    private String[] userColumnStrings = new String[]{"id", "Name", "User", "Password"};

    public String[] getUserColumnStrings() {
        return userColumnStrings;
    }

    public String getUrlGetUserString() {
        return urlGetUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
}//Main Class
