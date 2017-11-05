package com.example.testlistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlistview.R;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wirasinee on 29-Oct-17.
 */
//[5]
public class AnimalListAdapter extends ArrayAdapter<Animal> {
    private Context mContext; //ใครก็ตามที่เรียกใช้คลาสนี้ต้องส่งcontextมาให้เรา
    private ArrayList<Animal> mAnimalList;//ตัวข้อมูล แหล่งข้อมูล
    private int mLayoutResId; //ตัวเลเอาแต่ละไอเทมที่เราออกแบบไว้

//ต้องส่ง context ,resource อยากให้เลเอาเป็นแบบไหน ,objects แหล่งข้อมูลที่เก็บทั้งหมด
    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Animal> objects) {
        super(context, resource, objects);
        //ALT+INSERT+อันที่5+non

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mAnimalList = objects;
    }

    //CTRL+Oเลือก getView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //ตอนนี้เรากำลังจะสร้างอแดปเตอขึ้นมาเอง
        LayoutInflater inflater = LayoutInflater.from(mContext);//อินเฟคเลเอาโดยใช้LayoutInflater

        //View v = inflater.inflate(mLayoutResId,null);//ถ้าแหล่งข้อมูลเรามีเยอะๆแบบนี้ไม่เหมาะสม มี100ไอเทมมันก็ทำเลย100ครั้งทั้งๆที่จอสถามารถแสดงได้ทีละ7ไแเทม
        //เอาวิวเดิมมาใช้ซ่ำเช่นจอแสดงได้7สายพัน เพนกวิ้นไม่ถูกแสดงพอเลือนลงมาเพนกวิ้นจะถูกแสดงโดยเอาลิสวิวของสัต์ตัวแรกมารียูส(สัตว์ตัวแรกหลุดจากจอตอนเลือน)
        View v = convertView;//ทำให้มีการรียูสริสวิวซึ้งทำให้ประหยัดเวลามากขึ้น
        if(v==null){//ถ้าnull ก็อินเซฟใหม่ ถ้าไม่nullแสดงว่ามันอินเซฟไปแล้ว
            v=inflater.inflate(mLayoutResId,null);
        }

        //ค้นหาตัววิวที่อยู่ภายในv
        ImageView iv = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.textView);

        //ดึงข้อมูลจากแหล้งข้อมูลแล้วยัดข้อมูลลงไป เอาชื่อกับรูปภาพใส่เข้าไป
        Animal animal = mAnimalList.get(position);//ดึงเฉพาะโบกี(ข้อมูลobj)ตำแหน่งนั้นๆ (objนั้นๆ)
        iv.setImageResource(animal.picture);//จะได้รูปภาพไรก็ขึ้นอยู่กับ position ว่าlistViewขอpositionไหนมา
        tv.setText(animal.name);
//ระบุว่าไฟล์เลเอาที่จะอินเฟค คือได้เลเอาที่มีข้อมูลที่เราออกแบบไว้และี้อมูลภายในแต่ยังไม่ได้ใส่ลงListView
        return v;//รีเทินก้อนนั้นๆ
    }
}
