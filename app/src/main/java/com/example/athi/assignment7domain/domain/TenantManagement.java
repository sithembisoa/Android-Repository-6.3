package com.example.athi.assignment7domain.domain;
/**
 * Write a description of class TenantManagement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.ArrayList;

public class TenantManagement extends Management
{
    private  ArrayList<Tenant> tenantList = new ArrayList<Tenant>();
    private Long id;
    
   public TenantManagement(Builder builder){
       this.tenantList = builder.tenantList;
       this.id = builder.id;
   }
    
    public void AddTenant(Tenant tenant) {
        try{
            tenantList.add(tenant);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean searchByName(String name){
        try{
            for(int i = 0; i < tenantList.size(); i++){
                if(name.equalsIgnoreCase(tenantList.get(i).getFullName())){
                    System.out.println("Tenant found!");
                    return true;
                } else{
                    System.out.println("Tenant does not exist");
                    return false;
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int getSize(){return tenantList.size();}
  
    public void RemoveTenant(String tenantName) {
        try{
            for(int i = 0; i < tenantList.size(); i++){
                if(tenantName.equalsIgnoreCase(tenantList.get(i).getFullName())){
                    tenantList.remove(i);
                    System.out.println("Tenant removed!");
                } else{
                    System.out.println("Tenant does not exist");
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String DisplayTenants() {
        return "" + tenantList.toString();
    }
    
    public static class Builder{
       
      private  ArrayList<Tenant> tenantList = new ArrayList<Tenant>();
        private Long id;

       public Builder(ArrayList tenantList){
           this.tenantList = tenantList;
        }
       public Builder id(Long id){this.id=id;return this;}

        public Builder (){}
        public Builder list(ArrayList e){this.tenantList=e;return this;}
        public Builder copy(TenantManagement tenantManagement){
            this.tenantList = tenantManagement.tenantList;
            this.id = tenantManagement.id;
            return this;
        }
        
        public TenantManagement build(){
            return new TenantManagement(this);
        }
    }
}
