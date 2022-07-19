package Bicycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;


public class Bicycle {
   ///Atributtes
   public String UniqueCode;
   public String color;
   public Boolean isAccessible;
   public String bikeType;

    public String getUniqueCode() {
        return UniqueCode;
    }

    public String getColor() {
        return color;
    }

    public Boolean getAccessible() {
        return isAccessible;
    }

    public String getBikeType() {
        return bikeType;
    }

    public Bicycle(String uniqueCode, String bikeType , String color, Boolean isAccessible) throws FileNotFoundException {
        UniqueCode = uniqueCode;
        this.color = color;
        this.isAccessible = isAccessible;
        this.bikeType = bikeType;
    }

    public void setAccessible() {
        this.isAccessible = false;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "UniqueCode='" + UniqueCode + '\'' +
                ", color='" + color + '\'' +
                ", isAccessible=" + isAccessible +
                ", bikeType='" + bikeType + '\'' +
                '}';
    }
}








