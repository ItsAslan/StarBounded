package api.util;

public class TimeUtil {

    public static float SecondToMinute(float sec) {

        return sec / 60;

    }

    public static float MinuteToHour(float min) {

        return min / 60;

    }

    public static float HourToDay(float hour) {

        return hour / 24;

    }

    public static float DayToHour(float day) {

        return day * 24;

    }

    public static float HourToMinute(float hour) {

        return hour * 60;

    }

    public static float MinuteToSecond(float min) {

        return min * 60;

    }

    public static float DayToSecond(float day) {

        return MinuteToSecond(HourToMinute(DayToHour(day)));

    }

    public static float DayToMinecraftDay(float day) {

        return day * 72;

    }

    public static float MinecraftDayToDay(float mcDay) {

        return mcDay / 27;

    }

}
