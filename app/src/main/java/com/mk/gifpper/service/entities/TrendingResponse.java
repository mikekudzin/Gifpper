
package com.mk.gifpper.service.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class TrendingResponse {

    @SerializedName("data")
    @Expose
    private List<GifModel> data = new ArrayList<GifModel>();
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    /**
     * 
     * @return
     *     The data
     */
    public List<GifModel> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<GifModel> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 
     * @param pagination
     *     The pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).append(meta).append(pagination).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrendingResponse) == false) {
            return false;
        }
        TrendingResponse rhs = ((TrendingResponse) other);
        return new EqualsBuilder().append(data, rhs.data).append(meta, rhs.meta).append(pagination, rhs.pagination).isEquals();
    }

}
