package com.example.athi.assignment7domain.services.tenant;

import android.content.Context;

import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.domain.tenant.Tenant;

/**
 * Created by 212160923 on 5/11/2016.
 */
public interface TenantUpdateService {

    void updateTenant(Context context, Tenant tenant);

}
