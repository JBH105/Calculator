package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class calculator extends AppCompatActivity {
//    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
//            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDivision ,
//            buttonMul , button10 , buttonC , buttonEqual ;
//
//    EditText edt1 ;
//
//    float mValueOne , mValueTwo ;
//
//    boolean mAddition , mSubtract ,mMultiplication ,mDivision ;
 Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btncl,btnpa,btndi,btnx,btnsu,btnadd,btnans,btnbr,btndo;
 TextView tvinput,tvoutput;
 String process;
 boolean checkBracket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnadd=findViewById(R.id.btnadd);
        btnsu=findViewById(R.id.btnsu);
        btnx=findViewById(R.id.btnx);
        btndi=findViewById(R.id.btndi);
        btnpa=findViewById(R.id.btnpa);
        btnbr=findViewById(R.id.btnbr);
        btnans=findViewById(R.id.btnans);
        btncl=findViewById(R.id.btncl);
        btndo=findViewById(R.id.btndo);

        tvinput=findViewById(R.id.tvinput);
        tvoutput=findViewById(R.id.tvoutput);

        btncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvinput.setText("");
                tvoutput.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"9");
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"+");
            }
        });
        btnsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"-");
            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"x");
            }
        });
        btndi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"/");
            }
        });
        btnpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+"%");
            }
        });
        btndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvinput.getText().toString();
                tvinput.setText(process+".");
            }
        });
        btnbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    process=tvinput.getText().toString();
                    tvinput.setText(process+")");
                    checkBracket=false;
                }else {

                    process=tvinput.getText().toString();
                    tvinput.setText(process+"(");
                    checkBracket=true;
                }

            }
        });
        btnans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process=tvinput.getText().toString();

                process=process.replaceAll("x","*");
                process=process.replaceAll("%","/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";
                try {

                    Scriptable scriptable =rhino.initStandardObjects();
                    finalResult=rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }
                tvoutput.setText(finalResult);
            }
        });

//
//        button0 = (Button) findViewById(R.id.button0);
//        button1 = (Button) findViewById(R.id.button1);
//        button2 = (Button) findViewById(R.id.button2);
//        button3 = (Button) findViewById(R.id.button3);
//        button4 = (Button) findViewById(R.id.button4);
//        button5 = (Button) findViewById(R.id.button5);
//        button6 = (Button) findViewById(R.id.button6);
//        button7 = (Button) findViewById(R.id.button7);
//        button8 = (Button) findViewById(R.id.button8);
//        button9 = (Button) findViewById(R.id.button9);
//        button10 = (Button) findViewById(R.id.button10);
//        buttonAdd = (Button) findViewById(R.id.buttonadd);
//        buttonSub = (Button) findViewById(R.id.buttonsub);
//        buttonMul = (Button) findViewById(R.id.buttonmul);
//        buttonDivision = (Button) findViewById(R.id.buttondiv);
//        buttonC = (Button) findViewById(R.id.buttonC);
//        buttonEqual = (Button) findViewById(R.id.buttoneql);
//        edt1 = (EditText) findViewById(R.id.edt1);
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"1");
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"2");
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"3");
//            }
//        });
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"4");
//            }
//        });
//
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"5");
//            }
//        });
//
//        button6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"6");
//            }
//        });
//
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"7");
//            }
//        });
//
//        button8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"8");
//            }
//        });
//
//        button9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"9");
//            }
//        });
//
//        button0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+"0");
//            }
//        });
//
//        buttonAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (edt1 == null){
//                    edt1.setText("enter values");
//                }else {
//                    mValueOne = Float.parseFloat(edt1.getText() + "");
//                    mAddition = true;
//                    edt1.setText(null);
//                }
//            }
//        });
//
//        buttonSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueOne = Float.parseFloat(edt1.getText() + "");
//                mSubtract = true ;
//                edt1.setText(null);
//            }
//        });
//
//        buttonMul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueOne = Float.parseFloat(edt1.getText() + "");
//                mMultiplication = true ;
//                edt1.setText(null);
//            }
//        });
//
//        buttonDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueOne = Float.parseFloat(edt1.getText()+"");
//                mDivision = true ;
//                edt1.setText(null);
//            }
//        });
//        buttonEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueTwo = Float.parseFloat(edt1.getText() + "");
//
//                if (mAddition == true){
//
//                    edt1.setText(mValueOne + mValueTwo +"");
//                    mAddition=false;
//                }
//
//
//                if (mSubtract == true){
//                    edt1.setText(mValueOne - mValueTwo+"");
//                    mSubtract=false;
//                }
//
//                if (mMultiplication == true){
//                    edt1.setText(mValueOne * mValueTwo+"");
//                    mMultiplication=false;
//                }
//
//                if (mDivision == true){
//                    edt1.setText(mValueOne / mValueTwo+"");
//                    mDivision=false;
//                }
//            }
//        });
//        buttonC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText("");
//            }
//        });
//
//        button10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt1.setText(edt1.getText()+".");
//            }
//        });
    }
}