package com.epam.university.java.core.task006;

import java.util.Collection;
import java.text.DecimalFormat;


public class Task006Impl implements Task006 {

    @Override
    public double resistance(Collection<Measurement> measurements) {

        if (isArgumentInvalid(measurements)) {
            throw new IllegalArgumentException();
        }

        double avgAmpere = 0;
        double avgVoltage = 0;

        for (Measurement measurement :
                measurements) {
            avgAmpere += measurement.getAmperage();
            avgVoltage += measurement.getVoltage();
        }

        if (avgAmpere == 0) {
            return 0;
        }

        avgAmpere /= measurements.size();
        avgVoltage /= measurements.size();

        double slopeNumerator = 0;
        double slopeDenominator = 0;
        for (Measurement measurement :
                measurements) {
            slopeNumerator += (measurement.getAmperage() - avgAmpere)
                    * (measurement.getVoltage() - avgVoltage);
            slopeDenominator += Math.pow((measurement.getAmperage() - avgAmpere), 2);
        }

        DecimalFormat df = new DecimalFormat("#.###");
        int resistance = (int) (slopeNumerator / slopeDenominator * 1000);

        return (double) resistance / 1000;

    }

    private boolean isArgumentInvalid(Collection<Measurement> argument) {
        return argument == null;
    }

}
