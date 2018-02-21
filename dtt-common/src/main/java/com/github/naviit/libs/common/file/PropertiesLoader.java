/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   11/02/2018
 */
public class PropertiesLoader {

  private final static String EXT = ".properties";

  public static Properties load(Class<?> clazz, String dir, String name) {
    Properties prop = new Properties();
    try {
      if(dir.charAt(0) != File.separatorChar) dir = File.separator + dir;
      URL url = clazz.getResource(dir);
      if(url == null) throw new FileNotFoundException("The configuration file is not found in the gate config folder! " + dir);
      File folder = new File(url.toURI());

      return load(folder, name);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return prop;
  }

  public static Properties load(File folder, String name) {
    Properties prop = new Properties();
    try {
      if(name.charAt(0) != File.separatorChar) name = File.separator + name;
      if(!name.endsWith(EXT)) name = name + EXT;

      try (InputStream input = new FileInputStream(folder.getAbsolutePath() + name)){
        prop.load(input);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return prop;
  }

}
