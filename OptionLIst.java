package project212deneme;

public enum OptionLIst {
    M1("New Game"),M2("Options"),
    M3("Scores"),M4("Help"),
    M5("About"),M6("Exit");
	
	private String s;

	private OptionLIst(String s) {
		this.s = s;
	}

	public String getStr() {
		return s;
	}

}
