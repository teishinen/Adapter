package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SimpleAdapter adapter;       //简单适配器
    //绑定需要的文字
    String[]title = new String[]{"package", "training", "flower", "music",
            "brain", "eating", "dating","drinking"};
    //绑定需要的图片
    int[]images = new int[]{R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        //map键值对
        //将文字和图片匹配好，放入list中
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i=0; i<title.length; i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name",title[i]);
            map.put("image",images[i]);
            list.add(map);
        }
        //设置适配器
        adapter = new SimpleAdapter(MainActivity.this,
                list, R.layout.item, new String[]{"name","image"}, new int[]{R.id.textView, R.id.imageView});
        //把适配器写完后全部放到listview里
        listView.setAdapter(adapter);
        //单机某一项显示该项事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this, "您选择了：" + title[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}