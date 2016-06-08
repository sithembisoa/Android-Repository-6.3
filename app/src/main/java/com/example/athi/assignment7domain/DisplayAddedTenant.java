package com.example.athi.assignment7domain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DisplayAddedTenant extends AppCompatActivity {

    private Set<Tenant> tenantSet;
    private ArrayAdapter adapter;
    private ListView listView;
    private String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_added_tenant);

        TenantRepositoryImpl personRepository = new TenantRepositoryImpl(this.getApplicationContext());

        tenantSet = new HashSet<>();

        tenantSet = personRepository.findAll();

        Iterator<Tenant> itPerson = tenantSet.iterator();

        if(tenantSet.size() > 0) {

            names = new String[tenantSet.size()];
            // id = new String[personSet.size()];
            int i = 0;

            while(itPerson.hasNext()) {
                // id[i]= String.valueOf(itPerson.next().getId());
                names[i] = itPerson.next().getFullName();

                i++;
            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
            //adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,id);

            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
            //listView.setAdapter(adapter1);
        }
        else{
            Toast.makeText(DisplayAddedTenant.this, "No Data", Toast.LENGTH_SHORT).show();
        }


    }

    public void returntoHome(View view) {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

}
