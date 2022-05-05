
package com.bcp.types;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "otp",
    "transactionId"
})
@Generated("jsonschema2pojo")
public class OtpConfirm {

    @JsonProperty("otp")
    private String otp;
    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("otp")
    public String getOtp() {
        return otp;
    }

    @JsonProperty("otp")
    public void setOtp(String otp) {
        this.otp = otp;
    }

    public OtpConfirm withOtp(String otp) {
        this.otp = otp;
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

    public OtpConfirm withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OtpConfirm.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("otp");
        sb.append('=');
        sb.append(((this.otp == null)?"<null>":this.otp));
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
