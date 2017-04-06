package passposs2.kr.hs.emirim.gridcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
//     int[] ids={R.id.but0,R.id.but1,R.id.but2,R.id.but3,R.id.but4,R.id.but5,R.id.but6,R.id.but7,R.id.but8,R.id.but9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<butNums.length;i++){
//            butNums[i]=(Button)findViewById(ids[i]);
            butNums[i]=(Button)findViewById(R.id.but0+i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for(int i=0;i<butOps.length;i++){
            butOps[i]=(Button)findViewById(R.id.but_p+i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }

    View.OnClickListener butNumHandler=new View.OnClickListener() {

        public void onClick(View view) {

        }
    };

    View.OnClickListener butOpHandler=new View.OnClickListener(){

        public void onClick(View view){

        }
    };
}

