package fr.isep.ii3510.hearthstonecarddatabase.model;

import java.util.List;

public class QueryResponse {
    private String status;
    private List<Card> results;

    public QueryResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Card> getResults() {
        return results;
    }

    public void setResults(List<Card> results) {
        this.results = results;
    }
}
