package org.acme.rest.client;

public class JokeDTO {

    public int id;         // Unique ID for the joke
    public String type;       // Type of the joke (e.g., "general", "programming", etc.)
    public String setup;      // The setup or question part of the joke
    public String punchline;  // The punchline of the joke

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
