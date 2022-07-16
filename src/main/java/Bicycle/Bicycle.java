package Bicycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;


public class Bicycle {
    public static List<Bicycle> bicis = new ArrayList<>();
   ///Atributtes
   public String UniqueCode;
   public String color;
   public Boolean isAccessible;
   public String bikeType;

    public Bicycle(String uniqueCode,  String bikeType ,String color, Boolean isAccessible) throws FileNotFoundException {
        UniqueCode = uniqueCode;
        this.color = color;
        this.isAccessible = isAccessible;
        this.bikeType = bikeType;
    }





}

