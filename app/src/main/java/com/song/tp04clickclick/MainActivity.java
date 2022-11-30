package com.song.tp04clickclick;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView desk;
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12;
    ImageView[] imageV=new ImageView[]{iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12};
    int[] ids=new int[]{
            R.id.iv01,R.id.iv02,R.id.iv03,R.id.iv04,
            R.id.iv05,R.id.iv06,R.id.iv07,R.id.iv08,
            R.id.iv09,R.id.iv10,R.id.iv11,R.id.iv12
    };
    int count=0;
    int m;
    int[][] q=new int[][]{
            new int[]{
                    R.drawable.num01,R.drawable.num02, R.drawable.num03,R.drawable.num04,
                    R.drawable.num05,R.drawable.num06, R.drawable.num07,R.drawable.num08,
                    R.drawable.num09,R.drawable.num10, R.drawable.num11,R.drawable.num12
            },
            new int[]{
                    R.drawable.alpa01,R.drawable.alpa02, R.drawable.alpa03,R.drawable.alpa04,
                    R.drawable.alpa05,R.drawable.alpa06, R.drawable.alpa07,R.drawable.alpa08,
                    R.drawable.alpa09,R.drawable.alpa10, R.drawable.alpa11,R.drawable.alpa12

            },
            new int[]{R.drawable.cha01,R.drawable.cha02, R.drawable.cha03,R.drawable.cha04,
                    R.drawable.cha05,R.drawable.cha06, R.drawable.cha07,R.drawable.cha08,
                    R.drawable.cha09,R.drawable.cha10, R.drawable.cha11,R.drawable.cha12
            }};

    int[] arr=new int[12];
    Random rnd=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desk=findViewById(R.id.ib_desk);
        for(int k=0;k<ids.length;k++){
            imageV[k]=(ImageView)findViewById(ids[k]);
            imageV[k].setOnClickListener(listener);
        }
        next();
    }
    public void next(){
        desk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>2){
                    startActivity(new Intent(MainActivity.this,DoneActivity.class));
                    finish();
                }
                else{
                    desk.setImageResource(R.drawable.ing);
                    for(int i=0;i<ids.length;i++){
                        arr[i]=rnd.nextInt(ids.length);
                        for(int j=0;j<i;j++){
                            if(arr[i]==arr[j]) i--;
                        }
                    }
                    for(int k=0;k<ids.length;k++){
                        imageV[k].setImageResource(q[count][arr[k]]);
                        imageV[k].setVisibility(View.VISIBLE);
                        imageV[k].setTag(arr[k]);
                        m=0;
                    }
                }

            }
        });
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = view.getTag().toString();
            int n = Integer.parseInt(s);
            if (n == m) {
                view.setVisibility(View.INVISIBLE);
                m++;
            }
            if(m>=12){
                count++;
                next();
                Toast.makeText(MainActivity.this, "\"ING\"를 눌러주세요", Toast.LENGTH_SHORT).show();
            }
        }
    };
}

