package com.latihanmopro.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

    public class MainActivity extends AppCompatActivity {
        @BindView(R.id.txt_jumlah)
        TextView tvJumlah;
        @BindView(R.id.txt_hasil)
        TextView tvHasil;
        @BindView(R.id.et_name)
        EditText etName;
        @BindView(R.id.cb_jeruk)
        CheckBox cbJeruk;
        @BindView(R.id.cb_melon)
        CheckBox cbMelon;
        @BindView(R.id.cb_mango)
        CheckBox cbMango;
        @BindView(R.id.btn_clear)
        Button btnClear;

        int jumlah;
        String rasa;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            jumlah = 0;
            rasa ="";
        }

        @OnClick(R.id.btn_min)
        public void clickMin(){
            if (jumlah == 1){
                Toast.makeText(getApplicationContext(), "Jumlah tidak boleh nol", Toast.LENGTH_SHORT).show();
            }
            else
                jumlah = jumlah-1;

            tvJumlah.setText(""+jumlah);
        }

        @OnClick(R.id.btn_plus)
        public void clickPlus(){
            jumlah = jumlah+1;
            tvJumlah.setText(""+jumlah);

        }

        @OnClick(R.id.btn_order)
        public void clickOrder(){
            getCheck();
            tvHasil.setText("Name :"+etName.getText().toString()+"\nOrder Amount : "+jumlah+" rasa:"+rasa);
            tvHasil.setVisibility(View.VISIBLE);
            btnClear.setVisibility(View.VISIBLE);
        }

        @OnClick(R.id.btn_clear)
        public void clickClear(){
            tvHasil.setVisibility(View.GONE);
            btnClear.setVisibility(View.GONE);
            rasa = "";
        }

        public void getCheck(){
            if(cbJeruk.isChecked()){
                rasa +=" Orange Flavor";
            }
            if (cbMelon.isChecked()){
                rasa +=" Melon Flavor";
            }
            if (cbMango.isChecked()){
                rasa +=" Mango Flavor";
            }
        }

    }

