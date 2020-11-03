package fr.isep.ii3510.hearthstonecarddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import fr.isep.ii3510.hearthstonecarddatabase.model.Card;

public class DetailActivity extends AppCompatActivity {
    private static final String INTENT_CARD = "card";
    @BindView(R.id.card_textView)
    TextView cardTextView;
    @BindView(R.id.card_imageView)
    ImageView cardImageView;
    @BindView(R.id.gold_switch)
    Switch goldSwitch;

    private Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        card = intent.getParcelableExtra(INTENT_CARD);
        displayCardInfo(card);
    }

    private void displayCardInfo(Card card) {
        cardTextView.setText(card.getName());

        Glide.with(this)
                .load(card.getImg())
                .into(cardImageView);

    }


    @OnCheckedChanged(R.id.gold_switch)
    public void switchImage(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Glide.with(this)
                    .asGif()
                    .load(card.getImggold())
                    .into(cardImageView);
        } else {
            Glide.with(this)
                    .load(card.getImg())
                    .into(cardImageView);
        }
    }

}
