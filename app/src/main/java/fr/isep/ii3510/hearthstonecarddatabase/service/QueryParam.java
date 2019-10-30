package fr.isep.ii3510.hearthstonecarddatabase.service;

public class QueryParam {
    private String[] playerClass;
    private String cost;
    private String search;

    public QueryParam() {
    }

    public String[] getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String[] playerClass) {
        this.playerClass = playerClass;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
