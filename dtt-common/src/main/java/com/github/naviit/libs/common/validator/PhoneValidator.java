/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.validator;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   28/12/2017
 */
public class PhoneValidator {

  public final static String MOBILE_PREFIX[] = {
      "0120","0121","0122","0123","0124","0125","0126","0127","0128","0129",
      "0162","0163","0164","0165","0166","0167","0168","0169",
      "0186", "0188","018",//018 hoa binh
      "0868", "088", "089",
      "0199","019",//019 ha giang, 0199 gmobile
      "090", "091", "092", "093", "094", "096", "097", "098", "099",
  };

  public final static String PHONE_PREFIX[] = {
      "020","0210","0211","0218","0219","022","0230","0231","0240","0241","025","026","027","0280","0281","029",
      "030","031","0320","0321","033","0350","0351","036","037","038","039",
      "04",
      "0500","0501","0510","0511","052","053","054","055","056","057","058","059",
      "060","061","062","063","064","0650","0651","066","067","068","069",
      "070","0710","0711","072","073","074","075","076","077","0780","0781","079",
      "080","082","083","085","0862","0863","0866","0868","0871","0873","088","089",
      "084",// co dinh VTC
      "0120","0121","0122","0123","0124","0125","0126","0127","0128","0129",
      "0162","0163","0164","0165","0166","0167","0168","0169",
      "0186", "0188","018",//018 hoa binh
      "0199","019",//019 ha giang, 0199 gmobile
      "090", "091", "092", "093", "094", "096", "097", "098", "099",
      //"095",
      "0220", "0221", "0222", "0223", "0224", "0246", "0247", "0248", "0249",
      "0445", "0450",
      "0540", "0541", "0542", "0543", "0544",
      "0625", "0626", "0627", "0628", "0629", "0633", "0664", "0665", "0666", "0667", "0668", "0669",

      // 63 tinh moi 1.3.2015
      "0296", "0254", "0204", "0209", "0291", "0222", "0256", "0274", "0271", "0252", "0290", "0292",
      "0206", "0236", "0262", "0261", "0215", "0251", "0277", "0269", "0219", "0226", "024", "0239", "0220",
      "0225", "0293", "0218", "028", "0221", "0258", "0297", "0260", "0213", "0263", "0205", "0214", "0272",
      "0228", "0238", "0229", "0259", "0210", "0257", "0232", "0235", "0255", "0203", "0233", "0299", "0212",
      "0276", "0227", "0208", "0237", "0234", "0273", "0294", "0207", "0270", "0211", "0216"

  };

  public static String validPhoneNumber(String phone) {
    phone = phone.trim();
    if(phone.length() < 10) return null;
    if(phone.length() > 11) {
      if(phone.startsWith("+84")) {
        phone = phone.substring(3);
      }
    }
    if(phone.charAt(0) != '0') phone = "0" + phone;
    if(phone.length() > 11) return null;
    if(phone.length() == 10 || phone.length() == 11) {
      if(validPrefix(phone)) return phone;
      return null;
    }
    return null;
  }

  public static boolean validPrefix(String phone) {
    for(int i = 0; i < PHONE_PREFIX.length; i++) {
      if(phone.startsWith(PHONE_PREFIX[i])) return true;
    }
    return false;
  }

}