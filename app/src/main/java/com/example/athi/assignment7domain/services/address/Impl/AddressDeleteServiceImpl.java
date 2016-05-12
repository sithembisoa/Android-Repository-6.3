package com.example.athi.assignment7domain.services.address.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.address.FlatAddress;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.address.FlatAddressRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.address.FlatAddressTypeRepository;
import com.example.athi.assignment7domain.services.address.AddressDeleteService;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class AddressDeleteServiceImpl extends IntentService implements AddressDeleteService{

    private final FlatAddressTypeRepository repository;
    private static  AddressDeleteServiceImpl service = null;


    private static final String ACTION_ADD ="package com.example.athi.assignment7domain.services.address.Impl.action.ADD";
    private static final String ACTION_UPDATE="package com.example.athi.assignment7domain.services.address.Impl.action.Update";

    private static final String EXTRA_ADD = "package com.example.athi.assignment7domain.services.address.Impl.extra.ADD";


    public AddressDeleteServiceImpl() {
        super("AddressDeleteServiceImpl");
        repository = new FlatAddressRepositoryImpl(App.getAppContext());
    }

    private static AddressDeleteServiceImpl getInstance(){
        if(service == null)
            service = new AddressDeleteServiceImpl();
        return service;
    }



    @Override
    public void deleteAddress(Context context, FlatAddress address) {
        Intent intent = new Intent(context,AddressDeleteServiceImpl.class);
        intent.putExtra(EXTRA_ADD,address);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        FlatAddress addressResources = (FlatAddress) intent.getSerializableExtra(EXTRA_ADD);
        repository.delete(addressResources);
        Toast.makeText(getApplicationContext(),"Management removed",Toast.LENGTH_LONG).show();
    }

}
