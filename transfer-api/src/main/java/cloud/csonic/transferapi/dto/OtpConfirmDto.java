package cloud.csonic.transferapi.dto;

import com.bcp.types.OtpConfirm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OtpConfirmDto {

    private OtpConfirm otp;
}
