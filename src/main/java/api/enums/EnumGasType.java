package api.enums;

public enum EnumGasType
{
    NONE(0),
    HYDROGEN(1),
    OXYGEN(2),
    CO2(3),
    CO(4),
    HELIUM(5),
    ARGON(6),
    METHANE(7);

    // The higher the density the long it will take to harvest
    private int density;

    EnumGasType(int density)
    {
        this.density = density;
    }

    public int getDensity()
    {
        return density;
    }
}
