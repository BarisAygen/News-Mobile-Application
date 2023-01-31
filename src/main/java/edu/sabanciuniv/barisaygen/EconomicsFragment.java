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

public class EconomicsFragment extends Fragment {

    String api = "9a2961d567494506b3cd83ae628b63f3";
    Adapter adapter;
    ArrayList<ModelClass> modelClassArrayList;
    String country = "tr";
    private String category = "business";
    private RecyclerView recyclerViewOfEconomics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_economics, null);
        recyclerViewOfEconomics = view.findViewById(R.id.recyclereconomics);
        recyclerViewOfEconomics.setLayoutManager(new LinearLayoutManager(getContext()));
        modelClassArrayList = new ArrayList<>();
        adapter = new Adapter(modelClassArrayList, getContext());
        recyclerViewOfEconomics.setAdapter(adapter);
        FindNews();
        return view;
    }

    private void FindNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}