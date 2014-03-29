package com.mrmannwood.WordPlay.DataObjects;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

@ParseClassName("PlayerMove")
public class PlayerMove extends ParseObject{

    public String player;
    public ArrayList<Move> moves;

    public void setPlayer(String name){
        this.player = name;
    }

    public void addMove(Move move){
        if(moves == null){
            moves = new ArrayList<Move>();
        }
        moves.add(move);
    }

    public void push(){
        for(Move move : moves){
            move.push();
        }
        put("player", player);
        put("moves", moves);
        saveInBackground();
    }

    public void load(){
        this.player = this.getString("player");
        List<Move> moves = this.getList("moves");
        this.moves = new ArrayList<Move>(moves);
        for(Move move : moves){
            //move.load();
        }
    }

    public static ParseQuery<PlayerMove> getQuery(){
        return ParseQuery.getQuery(PlayerMove.class);
    }

}
