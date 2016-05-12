package com.example.athi.assignment7domain.services.management.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.management.TenantManagementRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.management.TenantManagementTypeRepository;
import com.example.athi.assignment7domain.services.management.TenantManagementDeleteService;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantManagementDeleteServiceImpl extends IntentService implements TenantManagementDeleteService{

    private final TenantManagementTypeRepository repository;
    private static  TenantManagementDeleteServiceImpl service = null;


    private static final String ACTION_ADD ="package com.example.athi.assignment7domain.services.management.Impl.action.ADD";
    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.management.Impl.action.Update";

    private static final String EXTRA_ADD = "package com.example.athi.assignment7domain.services.management.Impl.extra.ADD";


    public TenantManagementDeleteServiceImpl() {
        super("TenantManagementDeleteServiceImpl");
        repository = new TenantManagementRepositoryImpl(App.getAppContext());
    }

    private static TenantManagementDeleteServiceImpl getInstance(){
        if(service == null)
            service = new TenantManagementDeleteServiceImpl();
        return service;
    }



    @Override
    public void deleteManagement(Context context, TenantManagement tenantManagement) {
        Intent intent = new Intent(context,TenantManagementDeleteServiceImpl.class);
        intent.putExtra(EXTRA_ADD,tenantManagement);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        TenantManagement tenantResources = (TenantManagement)intent.getSerializableExtra(EXTRA_ADD);
        repository.delete(tenantResources);
        Toast.makeText(getApplicationContext(),"Management removed",Toast.LENGTH_LONG).show();
    }
}
