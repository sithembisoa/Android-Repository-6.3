package com.example.athi.assignment7domain.services.tenant.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;
import com.example.athi.assignment7domain.services.tenant.TenantDeleteService;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantDeleteServiceImpl extends IntentService implements TenantDeleteService {

    private final TenantTypeRepository repository;
    private static  TenantDeleteServiceImpl service = null;


    private static final String ACTION_ADD ="package com.example.athi.assignment7domain.services.tenant.Impl.action.ADD";
    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.tenant.Impl.action.Update";

    private static final String EXTRA_ADD = "package com.example.athi.assignment7domain.services.tenant.Impl.extra.ADD";


    public TenantDeleteServiceImpl() {
        super("TenantServiceImpl");
        repository = new TenantRepositoryImpl(App.getAppContext());
    }

    private static TenantDeleteServiceImpl getInstance(){
        if(service == null)
            service = new TenantDeleteServiceImpl();
        return service;
    }



    @Override
    public void deleteTenant(Context context, Tenant tenant) {
        Intent intent = new Intent(context,TenantDeleteServiceImpl.class);
        intent.putExtra(EXTRA_ADD,tenant);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Tenant tenantResources = (Tenant)intent.getSerializableExtra(EXTRA_ADD);
        repository.delete(tenantResources);
        Toast.makeText(getApplicationContext(),"Tenant removed",Toast.LENGTH_LONG).show();
    }
}
