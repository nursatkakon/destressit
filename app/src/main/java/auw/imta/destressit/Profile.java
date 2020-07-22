package auw.imta.destressit;

import android.content.Intent;
import android.view.SearchEvent;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    EditText status;
    String ustatus;
    Button upload, logout;
    int val;
    String msg;
    JSONParser jsonParser = new JSONParser();
    URL url = new URL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        status = (EditText) findViewById(R.id.status);
        upload = (Button) findViewById(R.id.upload);
        logout = (Button) findViewById(R.id.logout);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ustatus = status.getText().toString();
                new profile().execute();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,Start.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public class profile extends AsyncTask<String,String,String>{

        ProgressDialog progressDialog=new ProgressDialog(Profile.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                List<NameValuePair> pairList= new ArrayList<NameValuePair>();

                pairList.add(new BasicNameValuePair("post_data", ustatus));


                //cmd
                //JSONObject jsonObject = jsonParser.makeHttpRequest();
                JSONObject jsonObject = jsonParser.makeHttpRequest(url.NEWS_LINK, "POST", pairList);

                //Log.e("json", jsonObject+ "" + pairList);

                val = jsonObject.getInt("val");
                msg = jsonObject.getString("msg");

            }catch (Exception e){

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if(val == 0){
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                //Toast.makeText(ExternalDB.this, "Failed to insert", Toast.LENGTH_SHORT).show();
            }
            else{
                //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Toast.makeText(Profile.this, msg, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Profile.this,Newsfeed.class);
                startActivity(intent);
                //Toast.makeText(ExternalDB.this, "Successful", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
