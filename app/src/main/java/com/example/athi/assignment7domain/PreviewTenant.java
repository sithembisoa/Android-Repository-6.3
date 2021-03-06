package com.example.athi.assignment7domain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.athi.assignment7domain.domain.account.Account;
import com.example.athi.assignment7domain.domain.bills.ElectricityBill;
import com.example.athi.assignment7domain.domain.bills.ParkingBill;
import com.example.athi.assignment7domain.domain.bills.WaterBill;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;

public class PreviewTenant extends AppCompatActivity {

    private WaterBill water;
    private ElectricityBill elec;
    private ParkingBill park;

    private TextView fName;
    private TextView lName;
    private TextView personIDT;
    private TextView accountT;
    private TextView balanceT;

    String fname;
    String lname;
    String num;
    String acc;
    String bal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_tenant);

        fName =(TextView)findViewById(R.id.F_Name);
        lName =(TextView)findViewById(R.id.L_Name);
        personIDT =(TextView)findViewById(R.id.Person_ID);
        accountT =(TextView)findViewById(R.id.Account_No);
        balanceT =(TextView)findViewById(R.id.Ballance);

        Intent i = getIntent();

        Bundle b = i.getExtras();

        if(b!=null)
        {
            fname = (String)b.get("firstName");
            fName.setText(fname);

            lname =(String)b.get("lastName");
            lName.setText(lname);

             num = (String)b.get("personID");
            personIDT.setText(num);

            acc = (String)b.get("account");
            accountT.setText(acc);

            bal = (String)b.get("balance");
            balanceT.setText(bal);

        }

    }

    public void btnSubmit(View view) throws InterruptedException {

        TenantTypeRepository repo = new TenantRepositoryImpl(this.getApplicationContext());

        Account accnt = new Account.Builder().accNo(acc)
                                           .balance(Double.parseDouble(bal))
                                           .electricityBill(elec)
                                           .parking(park)
                                           .waterBill(water)
                                           .build();

        Tenant createEntity = new Tenant.Builder()
                .idNumber(num)
                .account(accnt)
                .fullName(fname+" "+lname)
                .build();

        Tenant inserted = repo.save(createEntity);

        Intent intent = new Intent(this, DisplayAddedTenant.class);

        startActivity(intent);
    }
}
