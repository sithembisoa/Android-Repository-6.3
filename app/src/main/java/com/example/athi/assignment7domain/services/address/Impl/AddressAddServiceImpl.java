package com.example.athi.assignment7domain.services.address.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.address.FlatAddress;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.address.FlatAddressRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.address.FlatAddressTypeRepository;
import com.example.athi.assignment7domain.services.address.AddressAddService;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class AddressAddServiceImpl extends IntentService implements AddressAddService {

    private final FlatAddressTypeRepository repository;
    private static  AddressAddServiceImpl service = null;


    private static final String ACTION_ADD ="package com.example.athi.assignment7domain.services.address.Impl.action.ADD";
    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.address.Impl.action.Update";

    private static final String EXTRA_ADD = "package com.example.athi.assignment7domain.services.address.Impl.extra.ADD";


    public AddressAddServiceImpl() {
        super("TenantServiceImpl");
        repository = new FlatAddressRepositoryImpl(App.getAppContext());
    }

    private static AddressAddServiceImpl getInstance(){
        if(service == null)
            service = new AddressAddServiceImpl();
        return service;
    }


    @Override
    public void addAddress(Context context, FlatAddress address) {
        Intent intent = new Intent(context,AddressAddServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,address);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        FlatAddress tenantResources = (FlatAddress) intent.getSerializableExtra(EXTRA_ADD);
        FlatAddress address = new FlatAddress.Builder()
                .flatNo(tenantResources.getFlatNo())
                .zip(tenantResources.getZipcode())
                .block(tenantResources.getBlock())
                .build();
        repository.save(address);
        Toast.makeText(getApplicationContext(),"Flat address has been added",Toast.LENGTH_LONG).show();

    }

}
