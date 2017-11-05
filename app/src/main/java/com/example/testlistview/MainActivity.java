package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;
//[2]
public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Animal> aList = AnimalData.animalList; //<4>
    private AnimalListAdapter mAdapter; //ShiFt+F6แก้ชื่อที่เดียว
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list_view);

        //<5>final AnimalData animalData = AnimalData.getInstance();//(18) สร้างobj animalDataแบบอซิงโครตัน
        //<5>animalData.animalList = new ArrayList<>();//(19)animalListตัวแปลแบบโกโบล


//วิธี1
        /*Animal animal = new Animal("แมว (Cat)",R.drawable.cat,getString(R.string.details_cat));
        animalData.animalList.add(animal);
        animalData.animalList.add(new Animal("หมา (Dog)",R.drawable.dog,getString(R.string.details_dog)));
        animalData.animalList.add(new Animal("โลมา (Dolphin)",R.drawable.dolphin,getString(R.string.details_dolphin)));
        animalData.animalList.add(new Animal("โคอาลา (Koala)",R.drawable.koala,getString(R.string.details_koala)));
        animalData.animalList.add(new Animal("สิงโต (Lion)",R.drawable.lion,getString(R.string.details_lion)));
        animalData.animalList.add(new Animal("นกฮูก (Owl)",R.drawable.owl,getString(R.string.details_owl)));
        animalData.animalList.add(new Animal("เพนกวิ้น (Penguin)",R.drawable.penguin,getString(R.string.details_penguin)));
        animalData.animalList.add(new Animal("หมู (Pig)",R.drawable.pig,getString(R.string.details_pig)));
        animalData.animalList.add(new Animal("กระต่าย (Rabbit)",R.drawable.rabbit,getString(R.string.details_rabbit)));
        animalData.animalList.add(new Animal("เสือ (Tiger)",R.drawable.tiger,getString(R.string.details_tiger)));*/
        //จะเอาข้อมูลมาแสดงในListViewต้องใช้ Adapterเชือมโยงรหว่างListViewกับmDate   ที่นีเี่ใช้ ArrayAdaptwe:กรณีข้อมูลเราเป็นarray หรือ arraylist

        //วิธี2<2>
        if(savedInstanceState==null) {
            //aList = new ArrayList<>();
            Animal animal = new Animal("แมว (Cat)", R.drawable.cat, getString(R.string.details_cat));
            aList.add(animal);
            aList.add(new Animal("หมา (Dog)", R.drawable.dog, getString(R.string.details_dog)));
            aList.add(new Animal("โลมา (Dolphin)", R.drawable.dolphin, getString(R.string.details_dolphin)));
            aList.add(new Animal("โคอาลา (Koala)", R.drawable.koala, getString(R.string.details_koala)));
            aList.add(new Animal("สิงโต (Lion)", R.drawable.lion, getString(R.string.details_lion)));
            aList.add(new Animal("นกฮูก (Owl)", R.drawable.owl, getString(R.string.details_owl)));
            aList.add(new Animal("เพนกวิ้น (Penguin)", R.drawable.penguin, getString(R.string.details_penguin)));
            aList.add(new Animal("หมู (Pig)", R.drawable.pig, getString(R.string.details_pig)));
            aList.add(new Animal("กระต่าย (Rabbit)", R.drawable.rabbit, getString(R.string.details_rabbit)));
            aList.add(new Animal("เสือ (Tiger)", R.drawable.tiger, getString(R.string.details_tiger)));
        }

         mAdapter = new AnimalListAdapter(
                this,
                R.layout.item,//คอนเทค เลเอา รูปแบบ
                aList //<3>
        );

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//iคือตำแหน่งลำดับitemนั้น

                Animal animal = aList.get(i);//ชื่อสัตว์ที่ผู้ใช้เลือก <3>
                Toast.makeText(MainActivity.this,animal.name,Toast.LENGTH_LONG).show();


                Intent intent = new Intent(MainActivity.this,AnimalDetailsActivity.class);

                intent.putExtra("position", i);//(19) ใส่แค่ index พอแล้ว แต่เวลาปลายทางเข้าถึงจะเข้าถึงอซิงโครตันก็จะได้animalList
                startActivity(intent);


            }
        });



    }

    //สร้าง ตัว+ <6> CTRL+O เวลาจะสร้างเมนูจะสร้างเมนูหน้าตาไง onCreateO
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); //ตัวที่จะแปลงแทคxmlที่เป็นเมนู มาเป็นjava obj
        inflater.inflate(R.menu.main,menu);
        //สร้างไฟล์ res->new->อันที่3->เลือกtype เป็นเมนู ==>menu->new->res file->ชื่อmainได้[6]
        return super.onCreateOptionsMenu(menu);
    }

    //<7> เมธอดควบคุมการทำงาน CTRL+O+onOptionsI

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        switch ( itemid) {//ตรวจสอบค่าitemidว่าเท่าไหร
            case R.id.action_add:
                addAnimal();
                return true;
            default:
                return super.onOptionsItemSelected(item); //ถ้าไม่ตกเคสไหนเย
        }

    }
//<8>
    private void addAnimal() {
      Animal a = new Animal(
              //CTRL+P
              "งู (Snake)",
              R.mipmap.ic_launcher,
              "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"

      );
      //ยัดใส่ขบวนรถไฟ
        //อ้างถึงตัวอเลลิแต่เราอ้างaListไว้แล้ว
        //aList.add(a); //addต่อท้าย
        aList.add(0,a);//addจากบน
        mAdapter.notifyDataSetChanged();//แจ้งให้อแดปเตอรู้ว่าแหล่งข้อมูลเปลียนละนะ มันก็จะอัพเดธลิสวิวให้อัตโนมัติ
        //บอกวอแดปเตอว่าข้อมูลเปลียน

    }//end addAinmal
}
