package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private int id;
    private String title;
    private double price;
    private Category catId;
    private String picUrl;
    private User userId;
}
