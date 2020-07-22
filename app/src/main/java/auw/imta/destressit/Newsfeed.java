package auw.imta.destressit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Newsfeed extends AppCompatActivity {

    //Button btnGet;
    //TextView update1;
    JSONParser jParser=new JSONParser();
    URL url = new URL();
    int val,status2;
    String msg, status;
    JSONArray pro;
    String dbData,post;
    ArrayList<String> dataSet = new ArrayList<String>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        lv = (ListView) findViewById(R.id.status);

        //post=status.getText().toString();
        //status.setText(post);
        new DataRcv().execute();
    }

    public class DataRcv extends AsyncTask<String, String, String>
    {

        ProgressDialog dialog = new ProgressDialog(Newsfeed.this);
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
                pair.add(new BasicNameValuePair("post_id", "1"));
                JSONObject jsonObject = jParser.makeHttpRequest(url.STATUS_LINK,"POST", pair);


                val = jsonObject.getInt("val");
                msg = jsonObject.getString("msg");
                pro = jsonObject.getJSONArray("information");


                for(int i = 0; i<pro.length();i++){
                    JSONObject jo = pro.getJSONObject(i);
                    //String name = jo.getString("name");
                    status = jo.getString("post_data");
                    status = "Anonymous:\n"+ status;
                    dataSet.add(status);



                    //dbData = name+"\n"+status+"\n";
                    //dbData = status;


                    //dataSet.add(dbData);

                    //dbData = status + " \n";
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
                ArrayAdapter adapter = new ArrayAdapter(Newsfeed.this,android.R.layout.simple_list_item_1,dataSet);

                lv.setAdapter(adapter);
               // Toast.makeText(getApplicationContext(),msg+"  "+dbData, Toast.LENGTH_LONG).show();
                //update1.setText(status);

            }else{
                Toast.makeText(getApplicationContext(),msg , Toast.LENGTH_LONG).show();
            }
        }

    }
}
