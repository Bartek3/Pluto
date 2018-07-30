package com.bartek.pluto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchAdapter extends ArrayAdapter<Match> {

    ArrayList<Match> matches = new ArrayList<>();

    public MatchAdapter(Activity context, ArrayList<Match> matches) {
        super(context, 0, matches);
        this.matches = matches;
    }

    @Override
    @Nullable
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Match currentMatch = getItem(position);

        TextView aName = listItemView.findViewById(R.id.teamAName);
        aName.setText(currentMatch.getTeamAName());

        TextView bName = listItemView.findViewById(R.id.teamBName);
        bName.setText(currentMatch.getTeamBName());

        TextView result = listItemView.findViewById(R.id.result);
        result.setText(currentMatch.getSetsA() + ":" + currentMatch.getSetsB());

        final LinearLayout linear = listItemView.findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent afterMatch = new Intent(view.getContext(), AftermatchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("match", currentMatch);
                bundle.putBoolean("endOfMatch", false);
                afterMatch.putExtras(bundle);

                view.getContext().startActivity(afterMatch);
            }
        });

        final LinearLayout trash = listItemView.findViewById(R.id.trash);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryDatabaseHelper db = new HistoryDatabaseHelper(getContext());
                db.deleteRow(position);
                matches.remove(position);
                MatchAdapter.this.notifyDataSetChanged();
            }
        });

        return listItemView;
    }
}

