package hu.me.msc.ds.demo.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NotBlank
    private String title;
    @Min(12)
    private int isbn;
    @NotBlank
    private String author;
}
