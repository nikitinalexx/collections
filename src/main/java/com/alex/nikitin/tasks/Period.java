package com.alex.nikitin.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Period {
    private int start;
    private int end;

    public Period(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static void main(String[] args) {
        List<Period> periods = Arrays.asList(new Period(0, 100), new Period(100, 133), new Period(70, 170));

        System.out.println(calculateMinRequiredRooms(periods));
    }

    private static int calculateMinRequiredRooms(List<Period> periods) {
        List<Period> sortedByStart = periods.stream().sorted(Comparator.comparingInt(Period::getStart)).collect(Collectors.toList());
        List<Period> sortedByEnd = periods.stream().sorted(Comparator.comparingInt(Period::getEnd)).collect(Collectors.toList());
        int roomsAmount = 0;
        int maxRoomsAmount = 0;

        int startIter = 0;
        int endIter = 0;

        while (startIter != sortedByStart.size() && endIter != sortedByEnd.size()) {
            if (sortedByStart.get(startIter).getStart() < sortedByEnd.get(endIter).getEnd()) {
                startIter++;
                roomsAmount++;
            } else {
                endIter++;
                roomsAmount--;
            }
            maxRoomsAmount = Math.max(maxRoomsAmount, roomsAmount);
        }
        return maxRoomsAmount;
    }
}
