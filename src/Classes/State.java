package Classes;

public enum State {
    JOHOR("Johor"),
    KEDAH("Kedah"),
    KELANTAN("Kelantan"),
    KUALA_LUMPUR("Kuala Lumpur"),
    MELAKA("Melaka"),
    NEGERI_SEMBILAN("Negeri Sembilan"),
    PAHANG("Pahang"),
    PERAK("Perak"),
    PERLIS("Perlis"),
    PULAU_PINANG("Pulau Pinang"),
    SABAH("Sabah"),
    SARAWAK("Sarawak"),
    SELANGOR("Selangor"),
    TERENGGANU("Terengganu"),
    WP_LABUAN("WP Labuan"),
    WP_PUTRAJAYA("WP Putrajaya");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String displayState() {
        return state;
    }

    @Override
    public String toString() {
        return state;
    }
}