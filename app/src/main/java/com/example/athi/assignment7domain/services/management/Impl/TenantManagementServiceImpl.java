package com.example.athi.assignment7domain.services.management.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.factories.management.TenantManagementFactory;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.management.TenantManagementRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.management.TenantManagementTypeRepository;
import com.example.athi.assignment7domain.services.management.TenantManagementService;

import java.util.ArrayList;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantManagementServiceImpl extends IntentService implements TenantManagementService {

    private final TenantManagementTypeRepository repository;
    private static  TenantManagementServiceImpl service = null;
    private ArrayList<Tenant> list = new ArrayList<>();

    private static final String ACTION_ADD ="package com.example.athi.assignment7domain.services.management.Impl.action.ADD";
    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.management.Impl.action.Update";

    private static final String EXTRA_ADD = "package com.example.athi.assignment7domain.services.management.Impl.extra.ADD";


    public TenantManagementServiceImpl() {
        super("TenantManagementServiceImpl");
        repository = new TenantManagementRepositoryImpl(App.getAppContext());
    }

    private static TenantManagementServiceImpl getInstance(){
        if(service == null)
            service = new TenantManagementServiceImpl();
        return service;
    }



    @Override
    public void addManagement(Context context, TenantManagement tenant) {
        Intent intent = new Intent(context,TenantManagementServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,tenant);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        TenantManagement tenantResources = (TenantManagement)intent.getSerializableExtra(EXTRA_ADD);

        TenantManagement tenant = new TenantManagement.Builder()
                .list(tenantResources.getTenantList())
                .build();
        repository.save(tenant);

        Toast.makeText(getApplicationContext(),"Management has been added",Toast.LENGTH_LONG).show();

    }

}
