package Client;

public class WildCard extends Card{
    private String wildAction;

    public WildCard(int point, String wildAction) {
        super(point, "Black");
        this.wildAction = wildAction;
    }

    public String getWildAction() {
        return wildAction;
    }

    public void setWildAction(String wildAction) {
        this.wildAction = wildAction;
    }
}
