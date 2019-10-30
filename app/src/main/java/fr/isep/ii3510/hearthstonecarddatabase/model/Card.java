package fr.isep.ii3510.hearthstonecarddatabase.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Card implements Parcelable {
    private String cardId, dbfId, name, cardSet, type, rarity, health, playerClass, cost, description, attack, race, img, imgGold;

    public Card() {}

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getDbfId() {
        return dbfId;
    }

    public void setDbfId(String dbfId) {
        this.dbfId = dbfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardSet() {
        return cardSet;
    }

    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cardId);
        parcel.writeString(dbfId);
        parcel.writeString(name);
        parcel.writeString(cardSet);
        parcel.writeString(type);
        parcel.writeString(rarity);
        parcel.writeString(health);
        parcel.writeString(playerClass);
        parcel.writeString(cost);
        parcel.writeString(description);
        parcel.writeString(attack);
        parcel.writeString(race);
        parcel.writeString(img);
        parcel.writeString(imgGold);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Card createFromParcel(Parcel source) {
            Card card = new Card();
            card.cardId = source.readString();
            card.dbfId = source.readString();
            card.name = source.readString();
            card.cardSet = source.readString();
            card.type = source.readString();
            card.rarity = source.readString();
            card.health = source.readString();
            card.playerClass = source.readString();
            card.cost = source.readString();
            card.description = source.readString();
            card.attack = source.readString();
            card.race = source.readString();
            card.img = source.readString();
            card.imgGold = source.readString();
            return card;
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[size];
        }
    };
}
