package cloud.csonic.transferapi.api;


import cloud.csonic.transferapi.dto.OtpConfirmDto;
import cloud.csonic.transferapi.dto.TransactionDto;
import cloud.csonic.transferapi.service.OtpService;
import cloud.csonic.transferapi.service.TransactionService;
import cloud.csonic.types.avro.TransactionEvent;
import com.bcp.types.OtpConfirm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionApi {

    private final TransactionService transactionService;
    private final OtpService otpService;

    @PostMapping()
    public TransactionDto createOrderAvro(@RequestBody TransactionDto request ){

        TransactionEvent event = TransactionEvent.newBuilder()
                .setOriginId(request.getTransaction().getOriginId())
                .setDestinationId(request.getTransaction().getDestinationId())
                .setAmount(request.getTransaction().getAmount())
                .setCreated(request.getTransaction().getCreated().toInstant())
                .setTransactionId(request.getTransaction().getTransactionId())
                .build();

        transactionService.publishAvro(event);

        return TransactionDto.builder()
                .transaction(request.getTransaction())
                .build();

    }

    @PostMapping("/{id}")
    public OtpConfirmDto confirmOtp(@RequestBody OtpConfirmDto request,@PathVariable String id ){


        var otpConfirm = new OtpConfirm();
        otpConfirm.setOtp(request.getOtp().getOtp());
        otpConfirm.setTransactionId(id);

        otpService.confirmOtp(otpConfirm);

        return OtpConfirmDto.builder()
                .otp(request.getOtp())
                .build();

    }


}
