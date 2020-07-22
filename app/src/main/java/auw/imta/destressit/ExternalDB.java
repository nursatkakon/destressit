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

public class ExternalDB extends AppCompatActivity {

    EditText name, email, password;
    String uname, uemail, upass;
    Button signup;
    int val;
    String msg;
    JSONParser jsonParser = new JSONParser();
    URL url = new URL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        name = (EditText) findViewById(R.id.user_name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = name.getText().toString();
                uemail = email.getText().toString();
                upass = password.getText().toString();
                new destressit_signup().execute();
            }
        });
    }

    public class destressit_signup extends AsyncTask<String,String,String>{

        ProgressDialog progressDialog=new ProgressDialog(ExternalDB.this);

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
                pairList.add(new BasicNameValuePair("email", uemail));
                pairList.add(new BasicNameValuePair("password", upass));


                //cmd
                //JSONObject jsonObject = jsonParser.makeHttpRequest();
                JSONObject jsonObject = jsonParser.makeHttpRequest(url.INSERT_LINK, "POST", pairList);

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
                Toast.makeText(ExternalDB.this, msg, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(ExternalDB.this,HomePage.class);
                startActivity(intent);
                //Toast.makeText(ExternalDB.this, "Successful", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
