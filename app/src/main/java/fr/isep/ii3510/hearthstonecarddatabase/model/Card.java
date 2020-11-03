package fr.isep.ii3510.hearthstonecarddatabase.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Card implements Parcelable {
    private String cardid, dbfid, name, cardset, type, rarity, health, playerClass, cost, description, attack, race, img, imggold;

    public Card() {}

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getDbfid() {
        return dbfid;
    }

    public void setDbfid(String dbfid) {
        this.dbfid = dbfid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardset() {
        return cardset;
    }

    public void setCardset(String cardset) {
        this.cardset = cardset;
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

    public String getImggold() {
        return imggold;
    }

    public void setImggold(String imggold) {
        this.imggold = imggold;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cardid);
        parcel.writeString(dbfid);
        parcel.writeString(name);
        parcel.writeString(cardset);
        parcel.writeString(type);
        parcel.writeString(rarity);
        parcel.writeString(health);
        parcel.writeString(playerClass);
        parcel.writeString(cost);
        parcel.writeString(description);
        parcel.writeString(attack);
        parcel.writeString(race);
        parcel.writeString(img);
        parcel.writeString(imggold);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Card createFromParcel(Parcel source) {
            Card card = new Card();
            card.cardid = source.readString();
            card.dbfid = source.readString();
            card.name = source.readString();
            card.cardset = source.readString();
            card.type = source.readString();
            card.rarity = source.readString();
            card.health = source.readString();
            card.playerClass = source.readString();
            card.cost = source.readString();
            card.description = source.readString();
            card.attack = source.readString();
            card.race = source.readString();
            card.img = source.readString();
            card.imggold = source.readString();
            return card;
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[size];
        }
    };
}
