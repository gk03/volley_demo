package hits.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import hits.myapplication.app.AppController;

public class MyActivity extends ActionBarActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clk (View v){
        makeStringReq(e1.getText().toString(),e2.getText().toString());
    }

    private void makeStringReq(String s1,String s2) {

        StringRequest strReq = new StringRequest(Method.GET,
                "https://tet-gk03.c9users.io/wines/"+s1+"/"+s2, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getBaseContext(),response,Toast.LENGTH_LONG).show();
                Log.d("abc", response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("abc", error.toString()   );
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, "test");

    }
}
