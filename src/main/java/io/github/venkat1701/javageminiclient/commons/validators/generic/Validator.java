package io.github.venkat1701.javageminiclient.commons.validators.generic;

import io.github.venkat1701.javageminiclient.commons.exceptions.ValidationException;

public interface Validator<T> {

    void validate(T object) throws ValidationException;
}
