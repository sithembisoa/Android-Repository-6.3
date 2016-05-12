package com.example.athi.assignment7domain.domain.block;

import com.example.athi.assignment7domain.domain.block.Block;

/**
 * Write a description of class BlockC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockC extends Block
{
    private String id;

    public String handleRequest(int roomNo) {
        if(roomNo > 20 && roomNo < 26){
            return "BlockC";
        }else{
            if (nextBlock!=null) {
                return nextBlock.handleRequest(roomNo);
            }
            return "InvalidBlock";
        }
    }
    
}
