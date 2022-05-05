package cloud.csonic.transferapi;

import org.apache.avro.Conversions;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.specific.SpecificData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransferApiApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        //SpecificData.get().addLogicalTypeConversion(new TimeConversions.TimestampMillisConversion());
        /*
        SpecificData.get().addLogicalTypeConversion(new Conversions.DecimalConversion());
        SpecificData.get().addLogicalTypeConversion(new TimeConversions.DateConversion());
        SpecificData.get().addLogicalTypeConversion(new TimeConversions.TimeMillisConversion());
        SpecificData.get().addLogicalTypeConversion(new TimeConversions.TimestampMicrosConversion());
        */
        SpringApplication.run(TransferApiApplication.class, args);
    }

}
