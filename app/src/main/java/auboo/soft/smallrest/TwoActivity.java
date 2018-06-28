package auboo.soft.smallrest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by amos on 2018/6/27.
 */

public class TwoActivity extends AppCompatActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, TwoActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

    }


    public void onTest(View view) {
        Toast.makeText(TwoActivity.this, "button点击", Toast.LENGTH_SHORT).show();
    }
}
