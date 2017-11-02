package com.example.testlistview;

import com.example.testlistview.model.Animal;
//[7]
import java.util.ArrayList;

/**
 * Created by Wirasinee on 29-Oct-17.
 */

public class AnimalData {

    private  static AnimalData sInstance;

    public ArrayList<Animal> animalList;//ตัวแปลที่เก็บเป็นโกโบลเช่น i

//วิธีอซิงโครตัน จะเป็นรูปแบบที่คลาสคลาสนึงจะnewได้แค่1ครั้งเท่านั้น
    public static AnimalData getInstance(){
        if(sInstance==null){
            sInstance = new AnimalData();
        }
        return sInstance;

    }


}

