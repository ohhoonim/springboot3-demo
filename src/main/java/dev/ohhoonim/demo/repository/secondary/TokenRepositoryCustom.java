package dev.ohhoonim.demo.repository.secondary;

import java.util.List;
import dev.ohhoonim.demo.model.secondary.Tokens;

public interface TokenRepositoryCustom {
     List<Tokens> findAllValidTokenByUserId(String userName);
}
