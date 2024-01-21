package com.example.do_an_qlcudannhatroanbinh_app_md13.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.example.do_an_qlcudannhatroanbinh_app_md13.R;

import java.util.ArrayList;
import java.util.List;

public class BillView extends AppCompatActivity {
    private EditText editTextApartment;
    private DatePicker datePicker;
    private Button btnSearch;
    private ListView listViewBills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_view);
        editTextApartment = findViewById(R.id.editTextApartment);
        datePicker = findViewById(R.id.datePicker);
        btnSearch = findViewById(R.id.btnSearch);
        listViewBills = findViewById(R.id.listViewBills);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ EditText và DatePicker
                String apartmentNumber = editTextApartment.getText().toString();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // Tháng bắt đầu từ 0
                int year = datePicker.getYear();

                // Gọi hàm hoặc API để lấy danh sách hóa đơn theo căn hộ và thời gian
                List<String> billList = getBillList(apartmentNumber, day, month, year);

                // Hiển thị kết quả trên ListView
                displayBills(billList);
            }
        });
    }

    private List<String> getBillList(String apartmentNumber, int day, int month, int year) {
        // Thực hiện logic để lấy danh sách hóa đơn từ máy chủ hoặc database
        // Trả về danh sách hóa đơn ở đây làm ví dụ
        List<String> bills = new ArrayList<>();
        bills.add("bill 1");
        bills.add("bill 2");
        bills.add("bill 3");
        return bills;
    }

    private void displayBills(List<String> billList) {
        // Hiển thị danh sách hóa đơn trên ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, billList);
        listViewBills.setAdapter(adapter);
    }
}