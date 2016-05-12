package com.example.athi.assignment7domain.factories.block;

import com.example.athi.assignment7domain.domain.block.Block;
import com.example.athi.assignment7domain.domain.block.BlockA;
import com.example.athi.assignment7domain.domain.block.BlockB;
import com.example.athi.assignment7domain.domain.block.BlockC;

/**
 * Write a description of class BlockFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockFactory
{
    public static String getBlock(int roomNo){
        Block chain = setUpChain();
        return chain.handleRequest(roomNo);
    }

    public static Block setUpChain(){
        Block a = new BlockA();
        Block b = new BlockB();
        Block c = new BlockC();
        a.setNextBlock(b);
        b.setNextBlock(c);
        return a;
    }
}
