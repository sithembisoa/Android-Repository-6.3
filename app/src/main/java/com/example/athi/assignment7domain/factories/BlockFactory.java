package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Block;
import com.example.athi.assignment7domain.domain.BlockA;
import com.example.athi.assignment7domain.domain.BlockB;
import com.example.athi.assignment7domain.domain.BlockC;

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
