package DTO;

import Model.React;
import Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private User userOwner;
    private LocalDate date;
    private List<React> react;
    private String title;
    private String postInfo;
}
