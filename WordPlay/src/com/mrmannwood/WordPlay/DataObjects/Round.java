package com.mrmannwood.WordPlay.DataObjects;

import com.parse.*;

import java.util.ArrayList;
import java.util.List;

@ParseClassName("Round")
public class Round extends ParseObject{

    public interface RoundPullListener{
        public void onPullReturn(List<Round> rounds, ParseException e);
    }

    public String topic;
    public ArrayList<PlayerMove> moves;

    public void setTopic(String topic){
        this.topic = topic;
    }

    public void addPlayerMove(PlayerMove move){
        if(moves == null){
            moves = new ArrayList<PlayerMove>();
        }
        moves.add(move);
    }

    public void push(){
        for(PlayerMove move : moves){
            move.push();
        }
        put("topic", topic);
        put("playerMoves", moves);
        saveInBackground();
    }

    public static void pull(final RoundPullListener listener){

        ParseQuery<Round> search = ParseQuery.getQuery(Round.class);
        search.include("playerMoves");
        search.findInBackground(new FindCallback<Round>() {
            @Override
            public void done(List<Round> rounds, ParseException e) {
                for(Round round : rounds){
                    round.topic = round.getString("topic");
                    round.moves = new ArrayList<PlayerMove>();
                    List<PlayerMove> moves = round.getList("playerMoves");
                    for(PlayerMove move : moves){
                        round.moves.add(move);
                        move.load();
                    }
                }
                listener.onPullReturn(rounds, e);
            }
        });

    }

}
