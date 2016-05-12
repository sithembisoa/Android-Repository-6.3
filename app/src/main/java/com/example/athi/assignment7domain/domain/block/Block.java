package com.example.athi.assignment7domain.domain.block;

/**
 * Abstract class Block - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Block
{
    Block nextBlock;

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }
    public abstract String handleRequest(int roomNo);
}
