package passposs2.kr.hs.emirim.gridcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr="";
    TextView textResult;
    //    int[] ids={R.id.but_0,R.id.but_1,R.id.but_2,R.id.but_3, R.id.but_4,
//            R.id.but_5,R.id.but_6,R.id.but_7,R.id.but_8,R.id.but_9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);
        textResult=(TextView)findViewById(R.id.text_result);

        for(int i=0;i<butNums.length;i++){
            butNums[i]=(Button)findViewById(R.id.but0+i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for(int i=0;i<butOps.length;i++){
            butOps[i]=(Button)findViewById(R.id.op1+i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }

    View.OnClickListener butNumHandler=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button but=(Button)view;
            numStr+=but.getText();
            switch (selectEdit) {
                case SELECT_EDIT1:
                    edit1.setText(numStr);
                    break;
                case SELECT_EDIT2:
                    edit2.setText(numStr);
                    break;
            }
        }
    };
    View.OnClickListener butOpHandler=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int num1=Integer.parseInt(edit1.getText().toString());
            int num2=Integer.parseInt(edit2.getText().toString());
            double result=0;
            switch (view.getId()){
                case R.id.op1:
                    result=num1+num2;
                    break;
                case R.id.op2:
                    result=num1-num2;
                    break;
                case R.id.op3:
                    result=num1*num2;
                    break;
                case R.id.op4:
                    result=(double)num1/num2;
                    break;
            }   //end switch
            textResult.setText(result+"");
        }
    };

    View.OnTouchListener editHandler=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            numStr="";
            switch (view.getId()){
                case R.id.edit1:
                    selectEdit=SELECT_EDIT1;
                    break;
                case R.id.edit2:
                    selectEdit=SELECT_EDIT2;
                    break;
            }
            return true;
        }
    };
}
