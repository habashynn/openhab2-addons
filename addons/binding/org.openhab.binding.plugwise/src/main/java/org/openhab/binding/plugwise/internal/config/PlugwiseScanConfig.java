/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.plugwise.internal.config;

import static com.google.common.base.CaseFormat.*;
import static org.openhab.binding.plugwise.internal.protocol.field.Sensitivity.MEDIUM;

import java.time.Duration;

import org.openhab.binding.plugwise.internal.protocol.field.MACAddress;
import org.openhab.binding.plugwise.internal.protocol.field.Sensitivity;

/**
 * The {@link PlugwiseScanConfig} class represents the configuration for a Plugwise Scan.
 *
 * @author Wouter Born - Initial contribution
 */
public class PlugwiseScanConfig {

    private String macAddress;
    private String sensitivity = UPPER_UNDERSCORE.to(LOWER_CAMEL, MEDIUM.name());
    private int switchOffDelay = 5; // minutes
    private boolean daylightOverride = false;
    private int wakeupInterval = 1440; // minutes (1 day)
    private int wakeupDuration = 10; // seconds
    private boolean recalibrate = false;
    private boolean updateConfiguration = true;

    public MACAddress getMACAddress() {
        return new MACAddress(macAddress);
    }

    public Sensitivity getSensitivity() {
        return Sensitivity.valueOf(LOWER_CAMEL.to(UPPER_UNDERSCORE, sensitivity));
    }

    public Duration getSwitchOffDelay() {
        return Duration.ofMinutes(switchOffDelay);
    }

    public boolean isDaylightOverride() {
        return daylightOverride;
    }

    public Duration getWakeupInterval() {
        return Duration.ofMinutes(wakeupInterval);
    }

    public Duration getWakeupDuration() {
        return Duration.ofSeconds(wakeupDuration);
    }

    public boolean isRecalibrate() {
        return recalibrate;
    }

    public boolean isUpdateConfiguration() {
        return updateConfiguration;
    }

    public boolean equalScanParameters(PlugwiseScanConfig other) {
        return this.sensitivity.equals(other.sensitivity) && this.switchOffDelay == other.switchOffDelay
                && this.daylightOverride == other.daylightOverride;
    }

    public boolean equalSleepParameters(PlugwiseScanConfig other) {
        return this.wakeupInterval == other.wakeupInterval && this.wakeupDuration == other.wakeupDuration;
    }

    @Override
    public String toString() {
        return "PlugwiseScanConfig [macAddress=" + macAddress + ", sensitivity=" + sensitivity + ", switchOffDelay="
                + switchOffDelay + ", daylightOverride=" + daylightOverride + ", wakeupInterval=" + wakeupInterval
                + ", wakeupDuration=" + wakeupDuration + ", recalibrate=" + recalibrate + ", updateConfiguration="
                + updateConfiguration + "]";
    }

}
