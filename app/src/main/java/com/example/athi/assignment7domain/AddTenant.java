package com.example.athi.assignment7domain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;

public class AddTenant extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText personID;
    private EditText account;
    private EditText balance;


    private Button previewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tenant);

        firstName =(EditText)findViewById(R.id.First_Name_EditText);
        lastName = (EditText)findViewById(R.id.Last_Name_EditText);
        personID = (EditText)findViewById(R.id.Person_ID_Edit_Text);
        account = (EditText)findViewById(R.id.Acc_no_Edit_Text);
        balance = (EditText)findViewById(R.id.Ballance_Edit_Text);

        previewButton = (Button)findViewById(R.id.preview_button);

        previewButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), PreviewTenant.class);
                i.putExtra("firstName",firstName.getText().toString());
                i.putExtra("lastName",lastName.getText().toString());
                i.putExtra("personID",personID.getText().toString());
                i.putExtra("account",account.getText().toString());
                i.putExtra("balance",balance.getText().toString());
                startActivity(i);

            }
        });
    }

}
