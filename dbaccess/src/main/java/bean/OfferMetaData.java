package bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by thieste on 24.01.16.
 */
@Getter
@Setter
public class OfferMetaData {

    @Id
    private String offerKey;

    private String importId;

    private Integer price;

    private String uniqueKey;


    public OfferMetaData() {
    }


}
