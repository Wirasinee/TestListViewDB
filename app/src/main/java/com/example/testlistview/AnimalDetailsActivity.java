package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlistview.model.Animal;
//[6]
public class AnimalDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        //(1)
        ImageView animalImageView = (ImageView) findViewById(R.id.animal_image_view);
        TextView nameTextView = (TextView) findViewById(R.id.name_text_view);

        Intent intent = getIntent();//getอินเทนที่ส่งมาจากหน้าก่อนหน้านี
/*(2)    String name = intent.getStringExtra("name");
        int picture = intent.getIntExtra("picture",0);*/

/*(20จากmain)*/
        int position = intent.getIntExtra("position",0);
        //AnimalData animalData = AnimalData.getInstance();

        //Animal animal = animalData.animalList.get(position);
        Animal animal = AnimalData.animalList.get(position);



        //setลงในวิวต่างๆ(3) getString(R.string.details_cat)
        nameTextView.setText(animal.detail);
        animalImageView.setImageResource(animal.picture);

        getSupportActionBar().setTitle(animal.name);//setชื่อ title ข้างบนสุด
    }
}
