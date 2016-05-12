package com.example.athi.assignment7domain.services.management.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.management.TenantManagementRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.management.TenantManagementTypeRepository;
import com.example.athi.assignment7domain.services.management.TenantManagementUpdateService;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantManagementUpdateServiceImpl extends IntentService implements TenantManagementUpdateService {

    private final TenantManagementTypeRepository repository;
    private static TenantManagementUpdateServiceImpl service = null;

    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.management.Impl.action.Update";
    private static final String EXTRA_UPDATE = "package com.example.athi.assignment7domain.services.management.Impl.extra.ADD";


    public TenantManagementUpdateServiceImpl() {
        super("TenantManagementUpdateServiceImpl");
        repository = new TenantManagementRepositoryImpl(App.getAppContext());

    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void updateManagement(Context context, TenantManagement employee) {
        Intent intent = new Intent(context,TenantManagementUpdateServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, employee);
        context.startService(intent);
    }
}
