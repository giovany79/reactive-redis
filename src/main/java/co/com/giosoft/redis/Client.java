package co.com.giosoft.redis;


import lombok.*;

import java.io.Serializable;


@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private String documentId;
    private String documentType;
    private String name;
    private String mdmKey;

}
