package com.example.dell.th_maytinhtt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Float fsothunhat, fsothuhai;
    String spheptinh, sxuatmanhinh = "";
    EditText edtketqua;
    Button btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtketqua = (EditText) findViewById(R.id.edt_ketqua);
        btndelete = (Button) findViewById(R.id.btn_delete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtketqua.setText("");
            }
        });

        int[] idButton = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6,
                R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_bang, R.id.btn_cong, R.id.btn_chia, R.id.btn_nhan, R.id.btn_tru};

        for (int id : idButton) {
        // button là phân lớp con của View lên ta có thể find thông qua id cho mảng idButton.
            View v = (View) findViewById(id);
            //sét sự kiện lắng nghe setonclicklistenner
            v.setOnClickListener(this);
        }

    }

    private void ToanTu() {
        fsothunhat = Float.parseFloat(edtketqua.getText().toString());
        sxuatmanhinh = "0";
        edtketqua.setText("0");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btn_cong:
                spheptinh = "+";
                ToanTu();
                break;
            case R.id.btn_tru:
                spheptinh = "-";
                ToanTu();
                break;
            case R.id.btn_nhan:
                spheptinh = "*";
                ToanTu();
                break;
            case R.id.btn_chia:
                spheptinh = "/";
                ToanTu();
                break;
            case R.id.btn_bang:

                Float ketqua = null;
                fsothuhai = Float.parseFloat(edtketqua.getText().toString());
                if (spheptinh == "+") {
                    ketqua = fsothunhat + fsothuhai;
                }
                if (spheptinh == "-") {
                    ketqua = fsothunhat - fsothuhai;
                }
                if (spheptinh == "*") {
                    ketqua = fsothunhat * fsothuhai;
                }
                if (spheptinh == "/") {
                    ketqua = fsothunhat / fsothuhai;
                }
                edtketqua.setText(String.valueOf(ketqua));
                fsothunhat = 0.0f;
                fsothuhai = 0.0f;
                sxuatmanhinh = "0";


//               fsothuhai = Float.parseFloat(edtketqua.getText().toString()) ;
//                Float ketqua = fsothunhat + fsothuhai ;


                break;
            default:
                if (sxuatmanhinh.equals("0")) {
                    sxuatmanhinh = "";

                }
                //ép kiểu button view
                sxuatmanhinh += ((Button) v).getText().toString();

                edtketqua.setText(sxuatmanhinh);


        }
    }
}
