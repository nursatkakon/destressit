package auw.imta.destressit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class Record extends AppCompatActivity {


    Button  btnGet;
    JSONParser jParser=new JSONParser();
    URL url = new URL();
    int val;
    String msg;
    JSONArray  pro;
    String dbData;
    ArrayList<String> dataSet = new ArrayList<String>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        btnGet = (Button)findViewById(R.id.button);
        lv=(ListView) findViewById(R.id.record);

        btnGet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                new DataRcv().execute();
            }
        });

    }

    public class DataRcv extends AsyncTask<String, String, String>
    {

        ProgressDialog dialog = new ProgressDialog(Record.this);
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            dialog.setMessage("Please wait...");
            dialog.setCancelable(false);
            dialog.show();

        }

        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            try {
                List<NameValuePair> pair = new ArrayList<NameValuePair>();

                pair.add(new BasicNameValuePair("id", "1"));


                JSONObject jsonObject = jParser.makeHttpRequest(url.RECIEVE_LINK,"POST", pair);


                val = jsonObject.getInt("val");
                msg = jsonObject.getString("msg");
                pro = jsonObject.getJSONArray("information");



                for(int i = 0; i<pro.length();i++){
                    JSONObject jo = pro.getJSONObject(i);

                    String id = jo.getString("id");
                    String name = jo.getString("name");
                    String mobile = jo.getString("mobile");

                    dbData = id+"   "+name+"   "+mobile+"\n";

                    dataSet.add(dbData);
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            dialog.dismiss();
            if(val==1){
                ArrayAdapter adapter = new ArrayAdapter(Record.this,android.R.layout.simple_list_item_1,dataSet);
                lv.setAdapter(adapter);
                //Toast.makeText(getApplicationContext(),msg+""+ pro, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),msg , Toast.LENGTH_LONG).show();
            }
        }

    }
}
