/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Calendar;

/**
 *
 * @author aluno
 */
public final class DateDifferential {

    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;
    private String msgDiffData;

    public DateDifferential(Calendar dateOne, Calendar dateTwo) {
        if (dateOne.compareTo(dateTwo) < 0) {
            getDataDiff(dateOne, dateTwo);
        } else {
            getDataDiff(dateTwo, dateOne);
        }
    }

    public int getDiffSecond() {
        return second;
    }

    public int getDiffMinute() {
        return minute;
    }

    public int getDiffHour() {
        return hour;
    }

    public int getDiffDay() {
        return day;
    }

    public int getDiffMonth() {
        return month;
    }

    public int getDiffYear() {
        return year;
    }

    public String getDiffDateString() {
        return msgDiffData;
    }

    public void getDataDiff(Calendar now, Calendar listData) {
        int diffSecond = now.get(Calendar.SECOND) - listData.get(Calendar.SECOND);
        int diffMinute = 0;
        int diffHour = 0;
        int diffDay = 0;
        int diffMonth = 0;
        int diffYear = 0;

        String msgUpdate = "";

        String diffSecondString = "";
        if (diffSecond > 0) {
            if (diffSecond > 1) {
                diffSecondString += diffSecond + " segundos ";
            } else {
                diffSecondString += diffSecond + " segundo ";
            }
        } else if (diffSecond < 0) {
            diffSecond = 60 - diffSecond;
            diffMinute = -1;
            if (diffSecond > 1) {
                diffSecondString += diffSecond + " segundos ";
            } else {
                diffSecondString += diffSecond + " segundo ";
            }
        }

        diffMinute += now.get(Calendar.MINUTE) - listData.get(Calendar.MINUTE);
        String diffMinuteString = "";
        if (diffMinute > 0) {
            if (diffMinute > 1) {
                diffMinuteString += diffMinute + " minutos ";
            } else {
                diffMinuteString += diffMinute + " minuto ";
            }
        } else if (diffMinute < 0) {
            diffMinute = 60 - diffMinute;
            diffHour = -1;
            if (diffMinute > 1) {
                diffMinuteString += diffMinute + " minutos ";
            } else {
                diffMinuteString += diffMinute + " minuto ";
            }
        }

        diffHour += now.get(Calendar.HOUR_OF_DAY) - listData.get(Calendar.HOUR_OF_DAY) - 2;
        String diffHourString = "";
        if (diffHour > 0) {
            if (diffHour > 1) {
                diffHourString += diffHour + " horas ";
            } else {
                diffHourString += diffHour + " hora ";
            }
        } else if (diffHour < 0) {
            diffHour = 24 - diffHour;
            diffDay = -1;
            if (diffHour > 1) {
                diffHourString += diffHour + " horas ";
            } else {
                diffHourString += diffHour + " hora ";
            }
        }

        diffDay += now.get(Calendar.DAY_OF_MONTH) - listData.get(Calendar.DAY_OF_MONTH);
        diffMonth += now.get(Calendar.MONTH) - listData.get(Calendar.MONTH);
        diffYear += now.get(Calendar.YEAR) - listData.get(Calendar.YEAR);

        String diffDayString = "";
        if (diffDay > 0) {
            if (diffDay > 1) {
                diffDayString += diffDay + " dias ";
            } else {
                diffDayString += diffDay + " dia ";
            }
        } else if (diffDay < 0) {
            diffMonth += -1;

            int month = now.get(Calendar.MONTH) - diffMonth;
            int year = now.get(Calendar.YEAR) - diffYear;

            if (month == Calendar.FEBRUARY) {
                if ((year % 4 == 0) && (year % 100 != 0)) {
                    diffDay = 29 - diffDay;
                } else {
                    diffDay = 28 - diffDay;
                }
            } else if ((month % 2 != 0 && month < 8) || (month % 2 == 0 && month > 7)) {
                diffDay = 31 - diffDay;
            } else if ((month % 2 == 0 && month < 8 && month != 2) || (month % 2 != 0 && month > 7)) {
                diffDay = 30 - diffDay;
            }

            if (diffDay > 1) {
                diffDayString += diffHour + " dias ";
            } else {
                diffDayString += diffHour + " dia ";
            }
        }

        String diffMonthString = "";
        if (diffMonth > 0) {
            if (diffMonth > 1) {
                diffMonthString += diffMonth + " meses ";
            } else {
                diffMonthString += diffMonth + " mês ";
            }
        } else if (diffMonth < 0) {
            diffYear += -1;

            if (diffMonth > 1) {
                diffMonthString += diffMonth + " meses ";
            } else {
                diffMonthString += diffMonth + " mês ";
            }
        }

        if (diffYear > 0) {
            if (diffYear > 1) {
                msgUpdate += diffYear + " anos ";
            } else {
                msgUpdate += diffYear + " ano ";
            }
        }

        msgUpdate += diffMonthString + diffDayString + diffHourString + diffMinuteString + diffSecondString;

        second = diffSecond;
        minute = diffMinute;
        hour = diffHour;
        day = diffDay;
        month = diffMonth;
        year = diffYear;
        msgDiffData = msgUpdate;
    }
}
