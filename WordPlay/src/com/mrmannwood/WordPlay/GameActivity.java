package com.mrmannwood.WordPlay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mrmannwood.WordPlay.DataObjects.Move;
import com.mrmannwood.WordPlay.DataObjects.PlayerMove;
import com.mrmannwood.WordPlay.DataObjects.Round;
import com.parse.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends WordplayActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);

        final NetworkManager manager = NetworkManager.getNetworkManager();

        final TextView console = (TextView) findViewById(R.id.console);

        final Button button = (Button) findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Round round = new Round();
                round.setTopic("Butts");

                Random r = new Random();

                String[] names = new String[]{"Marshall", "Chris", "Bronte", "Dick Muncher", "Mason"};
                for(int i = 0; i < names.length; i++){

                    PlayerMove playerMove = new PlayerMove();
                    playerMove.setPlayer(names[i]);

                    ArrayList<Move> moves = new ArrayList<Move>();
                    for(int g = 0; g < 4; g++){
                        Move move = new Move();
                        move.setType(r.nextInt(5));
                        move.setCost(r.nextInt(7));
                        move.setWordset("Random:" + r.nextInt());
                        playerMove.addMove(move);
                    }

                    round.addPlayerMove(playerMove);
                }

                round.push();
            }
        });

        Button fetchButton = (Button) findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Round.pull(new Round.RoundPullListener() {
                    @Override
                    public void onPullReturn(List<Round> rounds, ParseException e) {
                        for(Round round : rounds){
                            console.append("Round: " + round.topic);
                            for(PlayerMove move : round.moves){
                                console.append("\n\t" + move.player);
                            }
                        }
                    }
                });
            }
        });

    }

}
