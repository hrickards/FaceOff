package org.reverseshazam.faceoff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ResultsActivity extends Activity {
    public static final String IMAGE_FILENAME = "image_filename";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String fileUri = getIntent().getStringExtra(IMAGE_FILENAME);
        FetchResultsTask fetchResultsTask = new FetchResultsTask(this);
        fetchResultsTask.execute(fileUri);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.results, menu);
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

    // Fetch results from server
    public class FetchResultsTask extends AsyncTask<String, Void, String> {
        Context mContext;

        public FetchResultsTask(Context context) {
            mContext = context;
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO: Post HTTP Multipart to server and get result
            return "You're ugly as fuck";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView resultView = (TextView) findViewById(R.id.result);
            resultView.setText(result);
        }
    }
}
