package dev.syntax.employee;

public enum Unit {
	FS("Financial Services"),
    MS("Marketing Services"),
    HR("Human Resources");

    private String unitName;

    private Unit(String name) {
        this.unitName = name;
    }

    public String getUnitName() {
        return unitName;
    }
}
