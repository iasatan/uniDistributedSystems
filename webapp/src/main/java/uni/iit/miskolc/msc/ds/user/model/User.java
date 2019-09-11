package uni.iit.miskolc.msc.ds.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class User {
    @Getter
    @NonNull
    private String username;
}
