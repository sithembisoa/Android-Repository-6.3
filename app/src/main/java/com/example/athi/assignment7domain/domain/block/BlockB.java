package com.example.athi.assignment7domain.domain.block;

import com.example.athi.assignment7domain.domain.block.Block;

/**
 * Write a description of class BlockB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockB extends Block
{
    private String id;

    public String handleRequest(int roomNo) {
        if(roomNo > 10 && roomNo <=20){
            return "BlockB";
        }else{
            if (nextBlock!=null) {
                return nextBlock.handleRequest(roomNo);
            }
            return "InvalidBlock";
        }
    }
    
}
