package com.example.herizon;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModuleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        recyclerView = findViewById(R.id.moduleRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);

        apiService.getModules().enqueue(new Callback<List<Module>>() {
            @Override
            public void onResponse(Call<List<Module>> call, Response<List<Module>> response) {
                if (response.isSuccessful()) {
                    List<Module> modules = response.body();
                    adapter = new ModuleAdapter(modules);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Module>> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
