
package com.example.types;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acountId",
    "totalAmount",
    "starTime",
    "endTime",
    "numberOfTransactions"
})
@Generated("jsonschema2pojo")
public class StatisticsTransaction {

    @JsonProperty("acountId")
    private String acountId;
    @JsonProperty("totalAmount")
    private Double totalAmount;
    @JsonProperty("starTime")
    private ZonedDateTime starTime;
    @JsonProperty("endTime")
    private ZonedDateTime endTime;
    @JsonProperty("numberOfTransactions")
    private Long numberOfTransactions;

    @JsonProperty("acountId")
    public String getAcountId() {
        return acountId;
    }

    @JsonProperty("acountId")
    public void setAcountId(String acountId) {
        this.acountId = acountId;
    }

    public StatisticsTransaction withAcountId(String acountId) {
        this.acountId = acountId;
        return this;
    }

    @JsonProperty("totalAmount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public StatisticsTransaction withTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    @JsonProperty("starTime")
    public ZonedDateTime getStarTime() {
        return starTime;
    }

    @JsonProperty("starTime")
    public void setStarTime(ZonedDateTime starTime) {
        this.starTime = starTime;
    }

    public StatisticsTransaction withStarTime(ZonedDateTime starTime) {
        this.starTime = starTime;
        return this;
    }

    @JsonProperty("endTime")
    public ZonedDateTime getEndTime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public StatisticsTransaction withEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    @JsonProperty("numberOfTransactions")
    public Long getNumberOfTransactions() {
        return numberOfTransactions;
    }

    @JsonProperty("numberOfTransactions")
    public void setNumberOfTransactions(Long numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public StatisticsTransaction withNumberOfTransactions(Long numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StatisticsTransaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acountId");
        sb.append('=');
        sb.append(((this.acountId == null)?"<null>":this.acountId));
        sb.append(',');
        sb.append("totalAmount");
        sb.append('=');
        sb.append(((this.totalAmount == null)?"<null>":this.totalAmount));
        sb.append(',');
        sb.append("starTime");
        sb.append('=');
        sb.append(((this.starTime == null)?"<null>":this.starTime));
        sb.append(',');
        sb.append("endTime");
        sb.append('=');
        sb.append(((this.endTime == null)?"<null>":this.endTime));
        sb.append(',');
        sb.append("numberOfTransactions");
        sb.append('=');
        sb.append(((this.numberOfTransactions == null)?"<null>":this.numberOfTransactions));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
