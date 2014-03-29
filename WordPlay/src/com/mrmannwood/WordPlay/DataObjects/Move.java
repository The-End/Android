package com.mrmannwood.WordPlay.DataObjects;

import com.parse.*;

@ParseClassName("Move")
public class Move extends ParseObject{

    int type;
    int cost;
    String wordset;

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }

    public void setWordset(String wordset){
        this.wordset = wordset;
    }

    public String getWordset(){
        return this.wordset;
    }

    public void push(){
        put("type", type);
        put("cost", cost);
        put("wordset", wordset);
        saveInBackground();
    }

    public void load(){
        this.type = this.getInt("type");
        this.cost = this.getInt("cost");
        this.wordset = this.getString("wordset");
    }

    public static ParseQuery<Move> getQuery(){
        return ParseQuery.getQuery(Move.class);
    }

}
