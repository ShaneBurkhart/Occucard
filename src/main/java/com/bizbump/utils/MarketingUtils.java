package com.bizbump.utils;

/**
 * Created by Shane on 8/13/13.
 */
public class MarketingUtils {

    public static final String APP_NAME = "BizBump";
    public static final String APP_URL = "https://play.google.com/store/apps/details?id=com.theplanviewer.donkka";

    public static String getSMSText(String name){
        return name + " has invited you to join " + APP_NAME + ". Download in the google play app store. " + APP_URL;
    }

}
