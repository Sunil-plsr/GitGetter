package com.plsr.sunil.gitgetter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.plsr.sunil.gitgetter.R;
import com.plsr.sunil.gitgetter.data.model.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sunil on 4/7/18.
 */

public class RepoAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> myData;
    Context myContext;
    int myResource;

    public RepoAdapter(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.myContext=context;
        this.myData=objects;
        this.myResource=resource;

    }


    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(myResource,parent,false);
        }

        TextView repoName, repoDescription, repoStars;
        ImageView avatar;

        repoName = convertView.findViewById(R.id.repoName);
        repoDescription = convertView.findViewById(R.id.repoDescription);
        repoStars = convertView.findViewById(R.id.repoStars);
        avatar = convertView.findViewById(R.id.avatar);


        repoName.setText(myData.get(position).getName());
        repoDescription.setText(myData.get(position).getDescription());
        repoStars.setText(myData.get(position).getStargazersCount() + "★");
        Picasso.get().load(myData.get(position).getOwner().getAvatarUrl()).into(avatar);

        return convertView;
    }

}