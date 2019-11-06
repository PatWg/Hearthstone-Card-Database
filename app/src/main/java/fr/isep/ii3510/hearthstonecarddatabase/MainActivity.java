package fr.isep.ii3510.hearthstonecarddatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import fr.isep.ii3510.hearthstonecarddatabase.model.Card;
import fr.isep.ii3510.hearthstonecarddatabase.model.QueryResponse;
import fr.isep.ii3510.hearthstonecarddatabase.service.HearthstoneService;
import fr.isep.ii3510.hearthstonecarddatabase.service.QueryParam;
import fr.isep.ii3510.hearthstonecarddatabase.widget.CustomAdapter;
import fr.isep.ii3510.hearthstonecarddatabase.widget.CustomListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String INTENT_CARD = "card";

    @BindView(R.id.search_editText)
    EditText editText;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindViews({R.id.druid_checkbox, R.id.hunter_checkbox, R.id.mage_checkbox, R.id.paladin_checkbox, R.id.priest_checkbox, R.id.rogue_checkbox, R.id.shaman_checkbox, R.id.warlock_checkbox, R.id.warrior_checkbox})
    List<CheckBox> classList;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private QueryParam param;
    private List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        param = new QueryParam();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String cost = radioButton.getText().toString();
                if (cost.equals(getString(R.string.cost_all))) param.setCost(null);
                else param.setCost(cost);
            }
        });
    }

    public void searchDatabase(View view) {
        // TODO: Implement this to query the API
        // TODO: 1. Create the Retrofit object with new Retrofit.Builder().baseUrl().addConverterFactory().build()
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HearthstoneService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // TODO: 2. Create the service with retrofit.create(class)
        HearthstoneService service = retrofit.create(HearthstoneService.class);
        // TODO: 3. Set-up the query parameters
        setPlayerClassParams();
        setSearchParam();
        // TODO: 4. Call the service and enqueue it
        Call<QueryResponse> call = service.getCards(param);
        call.enqueue(new Callback<QueryResponse>() {
            @Override
            public void onResponse(Call<QueryResponse> call, Response<QueryResponse> response) {
                cards = response.body().getResults();

                // TODO: 5. Display the results in the RecyclerView
                CustomAdapter adapter = new CustomAdapter(
                        cards.toArray(new Card[0]),
                        new CustomListener() {
                            @Override
                            public void onClick(View v, int position) {
                                showDetails(position);
                            }
                        }
                );
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<QueryResponse> call, Throwable t) {
                Log.d("Query failure", t.getMessage());
            }
        });

    }


    private void setPlayerClassParams() {
        List<String> playerClasses = new ArrayList<>();
        for (CheckBox checkBox : classList) {
            if (checkBox.isChecked()) {
                playerClasses.add(checkBox.getText().toString());
            }
        }
        if (!playerClasses.isEmpty()) param.setPlayerClass(playerClasses.toArray(new String[0]));
    }

    private void setSearchParam() {
        if (!editText.getText().toString().trim().equals(getString(R.string.placeholder))) param.setSearch(editText.getText().toString().trim());
        else param.setSearch(null);
    }


    private void showDetails(int position) {
        Card card = cards.get(position);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(INTENT_CARD, card);
        startActivity(intent);
    }
}
