package com.example.athi.assignment7domain.services.tenant.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;
import com.example.athi.assignment7domain.services.tenant.TenantService;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantServiceImpl extends IntentService implements TenantService{

    private final TenantTypeRepository repository;
    private static  TenantServiceImpl service = null;


    private static final String ACTION_ADD ="package com.example.athi.assignment7domain.services.tenant.Impl.action.ADD";
    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.tenant.Impl.action.Update";

    private static final String EXTRA_ADD = "package com.example.athi.assignment7domain.services.tenant.Impl.extra.ADD";


    public TenantServiceImpl() {
        super("TenantServiceImpl");
        repository = new TenantRepositoryImpl(App.getAppContext());
    }

    private static TenantServiceImpl getInstance(){
        if(service == null)
            service = new TenantServiceImpl();
        return service;
    }



    @Override
    public void addTenant(Context context, Tenant tenant) {
        Intent intent = new Intent(context,TenantServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,tenant);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Tenant tenantResources = (Tenant)intent.getSerializableExtra(EXTRA_ADD);
        Tenant tenant = new Tenant.Builder()
                .idNumber(tenantResources.getIdNumber())
                .fullName(tenantResources.getFullName())
                .id(tenantResources.getId())
                .account(tenantResources.getAccount())
                .build();
        repository.save(tenant);
        Toast.makeText(getApplicationContext(),"Tenant has been added",Toast.LENGTH_LONG).show();

    }

}
