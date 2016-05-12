package com.example.athi.assignment7domain.domain.block;

import com.example.athi.assignment7domain.domain.block.Block;

/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockA extends Block
{
    private String id;

    public String handleRequest(int roomNo) {
        if(roomNo >= 1 && roomNo <=10){
            return "BlockA";
        }else{
            if (nextBlock!=null) {
                return nextBlock.handleRequest(roomNo);
            }
            return "InvalidBlock";
        }
    }
    
}
