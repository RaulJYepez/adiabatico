package rauljyepez.adiabatico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton mono,dia;
    EditText pa,pb,ta,tb,va,vb,wab,uab;
    Button calcular,clear;
    TextView CV;
    float fg,fe,fcv;
    double dpa,dpb,dta,dtb,dva,dvb,dwab,duab,x;
    String spa,spb,sta,stb,sva,svb,swab,suab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mono = (RadioButton) findViewById(R.id.radioButtonMonoatomico);
        dia = (RadioButton) findViewById(R.id.radioButtonDiatomico);
        pa=(EditText)findViewById(R.id.editTextPa);
        pb=(EditText)findViewById(R.id.editTextPb);
        va=(EditText)findViewById(R.id.editTextVa);
        vb=(EditText)findViewById(R.id.editTextVb);
        ta=(EditText)findViewById(R.id.editTextTa);
        tb=(EditText)findViewById(R.id.editTextTb);
        wab=(EditText)findViewById(R.id.editTextWab);
        uab=(EditText)findViewById(R.id.editTextUab);
        calcular=(Button) findViewById(R.id.button);
        clear=(Button)findViewById(R.id.buttonClear);
        CV=(TextView) findViewById(R.id.textViewCV);



        mono.setOnClickListener(this);
        dia.setOnClickListener(this);
        calcular.setOnClickListener(this);
        clear.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.radioButtonMonoatomico:
                fg=(float) 5/3;
                fe=(float) 3/5;
                fcv=(float) 3/2;
                CV.setText("5/3");
                break;
            case R.id.radioButtonDiatomico:
                fg=(float) 7/5;
                fe=(float) 5/7;
                fcv=(float) 5/2;
                CV.setText("7/5");
                break;
            case R.id.button:
                obtener();
                PA();
                PB();
                Va();
                Vb();
                WAB();

                break;
            case R.id.buttonClear:
                pa.setText("");
                pb.setText("");
                va.setText("");
                vb.setText("");
                ta.setText("");
                tb.setText("");
                wab.setText("");
                uab.setText("");

                break;


        }

    }

    private void obtener() {


        spa = pa.getText().toString();
        if(spa.compareTo("")==0){ spa="0";}
        dpa=Double.parseDouble(spa);
        spb = pb.getText().toString();
        if(spb.compareTo("")==0){ spb="0";}//imprime '0' porque ambos son iguales
        dpb=Double.parseDouble(spb);
        sva = va.getText().toString();
        if(sva.compareTo("")==0){ sva="0";}
        dva=Double.parseDouble(sva);
        svb = vb.getText().toString();
        if(svb.compareTo("")==0){ svb="0";}
        dvb=Double.parseDouble(svb);
        sta = ta.getText().toString();
        if(sta.compareTo("")==0){ sta="0";}
        dta=Double.parseDouble(sta);
        stb = tb.getText().toString();
        if(stb.compareTo("")==0){ stb="0";}
        dtb=Double.parseDouble(stb);
        swab = wab.getText().toString();
        if(swab.compareTo("")==0){ swab="0";}
        dwab=Double.parseDouble(swab);

    }
    private void PA() {
        if (dpa==0.0 & dpb!=0.0 & dvb!=0.0 & dva!=0.0){
            dpa=(dpb*Math.pow(dvb,fg))/(Math.pow(dva,fg));
            spa=Double.toString(dpa);
            pa.setText(spa);

        }

        if (dpa==0.0 & dpb!=0.0 & dtb!=0.0 & dta!=0.0 ){
            dpa=Math.pow(Math.pow(dpb,(1-fg))*Math.pow(dtb,fg)/Math.pow(dta,fg),-fcv);
            spa=Double.toString(dpa);
            pa.setText(spa);
        }

    }
    public void PB(){

        if (dpb==0.0 & dpa!=0.0 & dva!=0.0 & dvb!=0.0){
            dpb=(dpa*Math.pow(dva,fg))/(Math.pow(dvb,fg));
            spb=Double.toString(dpb);
            pb.setText(spb);

        }

        if (dpb==0.0 & dpa!=0.0 & dta!=0.0 & dtb!=0.0 ){
            dpb=Math.pow(Math.pow(dpa,(1-fg))*Math.pow(dta,fg)/Math.pow(dtb,fg),-fcv);
            spb=Double.toString(dpb);
            pb.setText(spb);
        }


        String X = Double.toString(x);
        uab.setText(X);
    }
    public void Va(){


        if(dva==0.0 & dpb!=0.0 & dvb!=0.0 & dpa!=0.0 ){

            dva=Math.pow(dpb*Math.pow(dvb,fg)/dpa,fe);

            sva=Double.toString(dva);
            va.setText(sva);
        }

        if(dva==0.0 & dtb!=0.0 & dvb!=0.0 & dta!=0.0 ){

            dva=Math.pow(dtb*Math.pow(dvb,(fg-1))/dta,fcv);
            sva=Double.toString(dva);
            va.setText(sva);
        }

    }
    public void Vb(){

        if(dvb==0.0 & dpa!=0.0 & dva!=0.0 & dpb!=0.0 ){

            dvb=Math.pow(dpa*Math.pow(dva,fg)/dpb,fe);

            svb=Double.toString(dvb);
            vb.setText(svb);
        }

        if(dvb==0.0 & dta!=0.0 & dva!=0.0 & dtb!=0.0 ){

            dvb=Math.pow(dta*Math.pow(dva,(fg-1))/dtb,fcv);
            svb=Double.toString(dvb);
            vb.setText(svb);
        }


    }
    private void WAB() {
        if (dwab==0.0 & dpa!=0 & dpb!=0 & dva!=0 & dvb!=0){
            dwab=(dpb*dvb-dpa*dva)/(1-fg);
            swab=Double.toString(dwab);
            wab.setText(swab);

        }
    }





}
