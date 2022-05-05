
package com.bcp.types;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "originId",
    "destinationId",
    "amount",
    "created",
    "transactionId"
})
@Generated("jsonschema2pojo")
public class Transaction {

    @JsonProperty("originId")
    private String originId;
    @JsonProperty("destinationId")
    private String destinationId;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("created")
    private ZonedDateTime created;
    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("originId")
    public String getOriginId() {
        return originId;
    }

    @JsonProperty("originId")
    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public Transaction withOriginId(String originId) {
        this.originId = originId;
        return this;
    }

    @JsonProperty("destinationId")
    public String getDestinationId() {
        return destinationId;
    }

    @JsonProperty("destinationId")
    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public Transaction withDestinationId(String destinationId) {
        this.destinationId = destinationId;
        return this;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    @JsonProperty("created")
    public ZonedDateTime getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Transaction withCreated(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Transaction withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Transaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("originId");
        sb.append('=');
        sb.append(((this.originId == null)?"<null>":this.originId));
        sb.append(',');
        sb.append("destinationId");
        sb.append('=');
        sb.append(((this.destinationId == null)?"<null>":this.destinationId));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null)?"<null>":this.created));
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
