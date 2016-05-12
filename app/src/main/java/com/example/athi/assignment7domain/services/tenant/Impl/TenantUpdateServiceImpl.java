package com.example.athi.assignment7domain.services.tenant.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;
import com.example.athi.assignment7domain.services.management.TenantManagementUpdateService;
import com.example.athi.assignment7domain.services.tenant.TenantUpdateService;

/**
 * Created by 212160923 on 5/11/2016.
 */
public class TenantUpdateServiceImpl extends IntentService implements TenantUpdateService {

    private final TenantTypeRepository repository;
    private static TenantUpdateServiceImpl service = null;

    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.tenant.Impl.action.Update";
    private static final String EXTRA_UPDATE = "package com.example.athi.assignment7domain.services.tenant.Impl.extra.ADD";


    public TenantUpdateServiceImpl() {
        super("TenantUpdateServiceImp");
        repository = new TenantRepositoryImpl(App.getAppContext());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void updateTenant(Context context, Tenant tenant) {
        Intent intent = new Intent(context,TenantUpdateServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, tenant);
        context.startService(intent);
    }


}
