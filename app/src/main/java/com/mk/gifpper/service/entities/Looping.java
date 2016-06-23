
package com.mk.gifpper.service.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Looping {

    @SerializedName("mp4")
    @Expose
    private String mp4;

    /**
     * 
     * @return
     *     The mp4
     */
    public String getMp4() {
        return mp4;
    }

    /**
     * 
     * @param mp4
     *     The mp4
     */
    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mp4).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Looping) == false) {
            return false;
        }
        Looping rhs = ((Looping) other);
        return new EqualsBuilder().append(mp4, rhs.mp4).isEquals();
    }

}
