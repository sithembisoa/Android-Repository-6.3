package com.example.athi.assignment7domain.domain.address;

import com.example.athi.assignment7domain.domain.block.Block;

import java.io.Serializable;

/**
 * Write a description of class FlatAddress here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlatAddress implements Serializable
{
    private int zipcode;
    private Block block;
    private String flatNo;
    private Long id;

    private FlatAddress() {
        
    }
    
    public FlatAddress(Builder builder) {
        zipcode=builder.zipcode;
        block =builder.block;
        flatNo = builder.flatNo;
        id = builder.id;
        
    }
    public Long getId(){return id;}
    public int getZipcode() {
            return zipcode;
        }


        public Block getBlock() {
            return block;
        }

        public String getFlatNo() {
            return flatNo;
        }
    
    public static class Builder{
        private int zipcode;
        private Block block;
        private String flatNo;
        private Long id;

        public Builder(){}
        public Builder zip(int zipcode){this.zipcode=zipcode;return this;}
        public Builder(int zipcode) {
            this.zipcode= zipcode;
        }
        
        public Builder block(Block block){
            this.block=block;
            return this;
        }
        
        public Builder flatNo(String flatNo){
            this.flatNo=flatNo;
            return this;
        }

        public Builder id(Long id){this.id = id; return this;}

        public Builder copy(FlatAddress add){
            this.zipcode= add.zipcode;
            this.block=add.block;
            this.flatNo=add.flatNo;
            this.id = add.id;
            return this;
        }
        
         public FlatAddress build(){
            return new FlatAddress(this);
        }
        
    }
}
