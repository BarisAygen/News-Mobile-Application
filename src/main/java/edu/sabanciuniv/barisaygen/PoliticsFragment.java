package edu.sabanciuniv.barisaygen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoliticsFragment extends Fragment {

    String api = "9a2961d567494506b3cd83ae628b63f3";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "tr";
    private RecyclerView recyclerViewOfPolitics;
    private String category = "politics";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_politics, null);
        recyclerViewOfPolitics = v.findViewById(R.id.recyclerpolitics);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfPolitics.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(modelClassArrayList, getContext());
        recyclerViewOfPolitics.setAdapter(adapter);
        FindNews();
        return v;
    }

    private void FindNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
