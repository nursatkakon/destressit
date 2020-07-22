package auw.imta.destressit;

import android.support.v7.app.AppCompatActivity;

import android.view.SearchEvent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.SearchEvent;
import android.app.ProgressDialog;
import android.os.AsyncTask;
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

public class LogIn extends AppCompatActivity {
    EditText name, password;
    String uname, upass;
    Button login;
    int val;
    String msg;
    JSONParser jsonParser = new JSONParser();
    URL url = new URL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        name = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = name.getText().toString();
                upass = password.getText().toString();
                new test2().execute();
            }
        });
    }

    public class test2 extends AsyncTask<String,String,String>{

        ProgressDialog progressDialog=new ProgressDialog(LogIn.this);

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

                pairList.add(new BasicNameValuePair("name", uname));
                pairList.add(new BasicNameValuePair("password", upass));

                JSONObject jsonObject = jsonParser.makeHttpRequest(url.RECIEVE_LINK, "POST", pairList);

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
               // Toast.makeText(LogIn.this, "Failed to insert", Toast.LENGTH_SHORT).show();
            }
            else{
                //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Toast.makeText(LogIn.this, msg, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(LogIn.this,HomePage.class);
                startActivity(intent);
                //Toast.makeText(LogIn.this, "Successful", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
