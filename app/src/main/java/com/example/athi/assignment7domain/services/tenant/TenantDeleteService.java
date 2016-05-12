package com.example.athi.assignment7domain.services.tenant;

import android.content.Context;

import com.example.athi.assignment7domain.domain.tenant.Tenant;

/**
 * Created by 212160923 on 5/10/2016.
 */
public interface TenantDeleteService {

    void deleteTenant(Context context, Tenant tenant);
}
