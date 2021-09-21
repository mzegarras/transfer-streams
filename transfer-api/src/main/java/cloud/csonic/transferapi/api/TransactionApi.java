package cloud.csonic.transferapi.api;


import cloud.csonic.transferapi.dto.TransactionDto;
import cloud.csonic.transferapi.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionApi {

    private final TransactionService transactionService;

    @PostMapping()
    public TransactionDto createOrder(@RequestBody TransactionDto request ){

        transactionService.publish(request.getTransaction());

        return TransactionDto.builder()
                .transaction(request.getTransaction())
                .build();

    }


}
