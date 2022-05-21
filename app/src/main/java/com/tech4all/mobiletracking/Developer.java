package com.tech4all.mobiletracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Developer extends AppCompatActivity {

    ImageView profile;

    public List<Lists> mData = new ArrayList<>();
    public RecyclerView recyclerView;
    public ListAdapters listAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        this.setTitle("Developed By");

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        listAdapters = new ListAdapters(mData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapters);

        String JSON_FILE = "{'error' : '1', " +
                "'0' : {'matric' : 'CS20190200967', 'name' : Bamidele Taiwo N.', 'level' : 'ND2 DPT'}, " +
                "'1' : {'matric' : 'CS20190201626', name : 'Adeleke Oluwaferanmi T.', 'level' : 'ND2 DPT'}, " +
                "'2' : {'matric' : 'CS20190105843', name : 'FOLAMI FUNMILAYO S.', 'level' : 'ND2 FT'}}";

        String matric, name, level;

        try {

            JSONObject object = new JSONObject(JSON_FILE);

            for (int ii = 0; ii < object.length(); ii++) {
                matric = object.getJSONObject(Integer.toString(ii)).getString("matric").toUpperCase();
                name = object.getJSONObject(Integer.toString(ii)).getString("name");
                level = object.getJSONObject(Integer.toString(ii)).getString("level");

                mData.add(new Lists(matric, name + " \n \n" + level, Core.IMG_URL + matric + ".jpg", "0", ""));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}