
package com.mk.gifpper.service.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Images {

    @SerializedName("fixed_height")
    @Expose
    private FixedHeight fixedHeight;
    @SerializedName("fixed_height_still")
    @Expose
    private FixedHeightStill fixedHeightStill;
    @SerializedName("fixed_height_downsampled")
    @Expose
    private FixedHeightDownsampled fixedHeightDownsampled;
    @SerializedName("fixed_width")
    @Expose
    private FixedWidth fixedWidth;
    @SerializedName("fixed_width_still")
    @Expose
    private FixedWidthStill fixedWidthStill;
    @SerializedName("fixed_width_downsampled")
    @Expose
    private FixedWidthDownsampled fixedWidthDownsampled;
    @SerializedName("fixed_height_small")
    @Expose
    private FixedHeightSmall fixedHeightSmall;
    @SerializedName("fixed_height_small_still")
    @Expose
    private FixedHeightSmallStill fixedHeightSmallStill;
    @SerializedName("fixed_width_small")
    @Expose
    private FixedWidthSmall fixedWidthSmall;
    @SerializedName("fixed_width_small_still")
    @Expose
    private FixedWidthSmallStill fixedWidthSmallStill;
    @SerializedName("downsized")
    @Expose
    private Downsized downsized;
    @SerializedName("downsized_still")
    @Expose
    private DownsizedStill downsizedStill;
    @SerializedName("downsized_large")
    @Expose
    private DownsizedLarge downsizedLarge;
    @SerializedName("downsized_medium")
    @Expose
    private DownsizedMedium downsizedMedium;
    @SerializedName("original")
    @Expose
    private Original original;
    @SerializedName("original_still")
    @Expose
    private OriginalStill originalStill;
    @SerializedName("looping")
    @Expose
    private Looping looping;

    /**
     * 
     * @return
     *     The fixedHeight
     */
    public FixedHeight getFixedHeight() {
        return fixedHeight;
    }

    /**
     * 
     * @param fixedHeight
     *     The fixed_height
     */
    public void setFixedHeight(FixedHeight fixedHeight) {
        this.fixedHeight = fixedHeight;
    }

    /**
     * 
     * @return
     *     The fixedHeightStill
     */
    public FixedHeightStill getFixedHeightStill() {
        return fixedHeightStill;
    }

    /**
     * 
     * @param fixedHeightStill
     *     The fixed_height_still
     */
    public void setFixedHeightStill(FixedHeightStill fixedHeightStill) {
        this.fixedHeightStill = fixedHeightStill;
    }

    /**
     * 
     * @return
     *     The fixedHeightDownsampled
     */
    public FixedHeightDownsampled getFixedHeightDownsampled() {
        return fixedHeightDownsampled;
    }

    /**
     * 
     * @param fixedHeightDownsampled
     *     The fixed_height_downsampled
     */
    public void setFixedHeightDownsampled(FixedHeightDownsampled fixedHeightDownsampled) {
        this.fixedHeightDownsampled = fixedHeightDownsampled;
    }

    /**
     * 
     * @return
     *     The fixedWidth
     */
    public FixedWidth getFixedWidth() {
        return fixedWidth;
    }

    /**
     * 
     * @param fixedWidth
     *     The fixed_width
     */
    public void setFixedWidth(FixedWidth fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    /**
     * 
     * @return
     *     The fixedWidthStill
     */
    public FixedWidthStill getFixedWidthStill() {
        return fixedWidthStill;
    }

    /**
     * 
     * @param fixedWidthStill
     *     The fixed_width_still
     */
    public void setFixedWidthStill(FixedWidthStill fixedWidthStill) {
        this.fixedWidthStill = fixedWidthStill;
    }

    /**
     * 
     * @return
     *     The fixedWidthDownsampled
     */
    public FixedWidthDownsampled getFixedWidthDownsampled() {
        return fixedWidthDownsampled;
    }

    /**
     * 
     * @param fixedWidthDownsampled
     *     The fixed_width_downsampled
     */
    public void setFixedWidthDownsampled(FixedWidthDownsampled fixedWidthDownsampled) {
        this.fixedWidthDownsampled = fixedWidthDownsampled;
    }

    /**
     * 
     * @return
     *     The fixedHeightSmall
     */
    public FixedHeightSmall getFixedHeightSmall() {
        return fixedHeightSmall;
    }

    /**
     * 
     * @param fixedHeightSmall
     *     The fixed_height_small
     */
    public void setFixedHeightSmall(FixedHeightSmall fixedHeightSmall) {
        this.fixedHeightSmall = fixedHeightSmall;
    }

    /**
     * 
     * @return
     *     The fixedHeightSmallStill
     */
    public FixedHeightSmallStill getFixedHeightSmallStill() {
        return fixedHeightSmallStill;
    }

    /**
     * 
     * @param fixedHeightSmallStill
     *     The fixed_height_small_still
     */
    public void setFixedHeightSmallStill(FixedHeightSmallStill fixedHeightSmallStill) {
        this.fixedHeightSmallStill = fixedHeightSmallStill;
    }

    /**
     * 
     * @return
     *     The fixedWidthSmall
     */
    public FixedWidthSmall getFixedWidthSmall() {
        return fixedWidthSmall;
    }

    /**
     * 
     * @param fixedWidthSmall
     *     The fixed_width_small
     */
    public void setFixedWidthSmall(FixedWidthSmall fixedWidthSmall) {
        this.fixedWidthSmall = fixedWidthSmall;
    }

    /**
     * 
     * @return
     *     The fixedWidthSmallStill
     */
    public FixedWidthSmallStill getFixedWidthSmallStill() {
        return fixedWidthSmallStill;
    }

    /**
     * 
     * @param fixedWidthSmallStill
     *     The fixed_width_small_still
     */
    public void setFixedWidthSmallStill(FixedWidthSmallStill fixedWidthSmallStill) {
        this.fixedWidthSmallStill = fixedWidthSmallStill;
    }

    /**
     * 
     * @return
     *     The downsized
     */
    public Downsized getDownsized() {
        return downsized;
    }

    /**
     * 
     * @param downsized
     *     The downsized
     */
    public void setDownsized(Downsized downsized) {
        this.downsized = downsized;
    }

    /**
     * 
     * @return
     *     The downsizedStill
     */
    public DownsizedStill getDownsizedStill() {
        return downsizedStill;
    }

    /**
     * 
     * @param downsizedStill
     *     The downsized_still
     */
    public void setDownsizedStill(DownsizedStill downsizedStill) {
        this.downsizedStill = downsizedStill;
    }

    /**
     * 
     * @return
     *     The downsizedLarge
     */
    public DownsizedLarge getDownsizedLarge() {
        return downsizedLarge;
    }

    /**
     * 
     * @param downsizedLarge
     *     The downsized_large
     */
    public void setDownsizedLarge(DownsizedLarge downsizedLarge) {
        this.downsizedLarge = downsizedLarge;
    }

    /**
     * 
     * @return
     *     The downsizedMedium
     */
    public DownsizedMedium getDownsizedMedium() {
        return downsizedMedium;
    }

    /**
     * 
     * @param downsizedMedium
     *     The downsized_medium
     */
    public void setDownsizedMedium(DownsizedMedium downsizedMedium) {
        this.downsizedMedium = downsizedMedium;
    }

    /**
     * 
     * @return
     *     The original
     */
    public Original getOriginal() {
        return original;
    }

    /**
     * 
     * @param original
     *     The original
     */
    public void setOriginal(Original original) {
        this.original = original;
    }

    /**
     * 
     * @return
     *     The originalStill
     */
    public OriginalStill getOriginalStill() {
        return originalStill;
    }

    /**
     * 
     * @param originalStill
     *     The original_still
     */
    public void setOriginalStill(OriginalStill originalStill) {
        this.originalStill = originalStill;
    }

    /**
     * 
     * @return
     *     The looping
     */
    public Looping getLooping() {
        return looping;
    }

    /**
     * 
     * @param looping
     *     The looping
     */
    public void setLooping(Looping looping) {
        this.looping = looping;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fixedHeight).append(fixedHeightStill).append(fixedHeightDownsampled).append(fixedWidth).append(fixedWidthStill).append(fixedWidthDownsampled).append(fixedHeightSmall).append(fixedHeightSmallStill).append(fixedWidthSmall).append(fixedWidthSmallStill).append(downsized).append(downsizedStill).append(downsizedLarge).append(downsizedMedium).append(original).append(originalStill).append(looping).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Images) == false) {
            return false;
        }
        Images rhs = ((Images) other);
        return new EqualsBuilder().append(fixedHeight, rhs.fixedHeight).append(fixedHeightStill, rhs.fixedHeightStill).append(fixedHeightDownsampled, rhs.fixedHeightDownsampled).append(fixedWidth, rhs.fixedWidth).append(fixedWidthStill, rhs.fixedWidthStill).append(fixedWidthDownsampled, rhs.fixedWidthDownsampled).append(fixedHeightSmall, rhs.fixedHeightSmall).append(fixedHeightSmallStill, rhs.fixedHeightSmallStill).append(fixedWidthSmall, rhs.fixedWidthSmall).append(fixedWidthSmallStill, rhs.fixedWidthSmallStill).append(downsized, rhs.downsized).append(downsizedStill, rhs.downsizedStill).append(downsizedLarge, rhs.downsizedLarge).append(downsizedMedium, rhs.downsizedMedium).append(original, rhs.original).append(originalStill, rhs.originalStill).append(looping, rhs.looping).isEquals();
    }

}
