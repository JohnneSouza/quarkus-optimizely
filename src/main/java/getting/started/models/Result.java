package getting.started.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class Result {

    private String message;
    private boolean success;

    public Result(String message) {
        this.success = true;
        this.message = message;
    }

    public Result(Set<? extends ConstraintViolation<?>> violations) {
        this.success = false;
        this.message = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
    }

}
