package android.getdatarestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ListView lvArtist;
    CustomAdapterArtist adapter;
    ArrayList<Artist>lvData=new ArrayList<>();
    String url = "https://soundiiz.com/data/fileExamples/artistsExport.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvArtist=(ListView) findViewById(R.id.lvArtist);
        getAllData(url);
    }

    public void getAllData (String url)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
       StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               try {
                   parseJsonDataToArrayList(response);
               } catch (JSONException e) {
                   throw new RuntimeException(e);
               }
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(getApplicationContext(),"Error Data!", Toast.LENGTH_SHORT).show();
           }
       });
       queue.add(stringRequest);
    }
    //lấy dữ liệu trong file json response đưa vào lsData
    public  void parseJsonDataToArrayList (String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        for(int i=0;i<jsonArray.length(); i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Artist a = new Artist();
            a.name = jsonObject.getString("name");
            a.numberFans = jsonObject.getString("fans");
            a.pictureLink=jsonObject.getString("picture");
            lvData.add(a);
        }
        //gắn dữ liệu vào listView
        adapter=new CustomAdapterArtist(getApplicationContext(),
                R.layout.layout_item_artist,lvData);
        lvArtist.setAdapter(adapter);
    }
}

